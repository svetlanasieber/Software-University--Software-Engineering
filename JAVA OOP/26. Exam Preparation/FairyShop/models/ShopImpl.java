package fairyShop.models;


public class ShopImpl implements Shop {
    public void craft(Present present, Helper helper) {


    if (helper.canWork()) {
        for (Instrument instrument : helper.getInstruments()) {
            while (!instrument.isBroken()) {
                if (!instrument.isBroken() && helper.canWork()) {
                    present.getCrafted();
                    helper.work();
                    instrument.use();
                }
                if (present.isDone()) {
                    return;
                }
                if (!helper.canWork()) {
                    return;
                }
            }
        }
    }
}
}

