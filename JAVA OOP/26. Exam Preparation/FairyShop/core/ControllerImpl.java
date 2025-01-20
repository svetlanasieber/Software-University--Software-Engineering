package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.models.*;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.HELPER_DOESNT_EXIST;
import static fairyShop.common.ExceptionMessages.HELPER_TYPE_DOESNT_EXIST;

public class ControllerImpl implements Controller {
    private HelperRepository helpers;
    private PresentRepository presents;
    private Shop shop;

    public ControllerImpl() {
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        this.helpers.add(helper);
        return String.format(ADDED_HELPER, type, helperName);

    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Instrument instrument = new InstrumentImpl(power);
        Helper helper = this.helpers.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        helper.addInstrument(instrument);

        return String.format("Successfully added instrument with power %d to helper %s!", power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        Present present = new PresentImpl(presentName, energyRequired);
        this.presents.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> helpersList = this.helpers.getModels().stream().filter(helper -> helper.getEnergy() > 50).collect(Collectors.toList());


        if (helpersList.isEmpty()) {
            throw new IllegalArgumentException("There is no helper ready to start crafting!");

        }
        int brokenInstrumentCount = 0;
        Present present = this.presents.findByName(presentName);
        for (Helper helper : helpersList) {
            shop.craft(present, helper);
            brokenInstrumentCount += helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (present.isDone()) {
                break;
            }
        }
        if (present.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstrumentCount);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstrumentCount);


    }

    @Override
    public String report() {
        int size = (int) this.presents.getModels().stream().filter(Present::isDone).count();
        List<String> collect = this.helpers.getModels().stream().map(helper -> String.format("Name: %s%n" +
                        "Energy: %d%n" +
                        "Instruments: %d not broken left%n", helper.getName(), helper.getEnergy(),
                (int) helper.getInstruments().stream().filter(instrument -> !instrument.isBroken()).count())).collect(Collectors.toList());
        return String.format("%d presents are done!%n", size) + String.format("Helpers info:%n") + String.join("", collect).trim();
    }
}
