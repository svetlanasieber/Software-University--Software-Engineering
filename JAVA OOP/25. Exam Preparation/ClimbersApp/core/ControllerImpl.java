package climbers.core;

import climbers.common.ConstantMessages;
import climbers.common.ExceptionMessages;
import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.Collection;


public class ControllerImpl implements Controller {
    private Repository<Mountain> mountainRepository;
    private Repository<Climber> climberRepository;
    private int mountains;

    public ControllerImpl() {
        this.mountainRepository = new MountainRepository();
        this.climberRepository = new ClimberRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type) {
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }
        this.climberRepository.add(climber);
        return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        this.mountainRepository.add(mountain);
        return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climberToRemove = this.climberRepository.byName(climberName);
        if (climberToRemove == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }

        climberRepository.remove(climberToRemove);
        return String.format(ConstantMessages.CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = this.climberRepository.getCollection();
        Repository<Mountain> mountains = this.mountainRepository;
        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }
        Mountain mountain = this.mountainRepository.byName(mountainName);
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountain, climbers);
        long removed = climbers.stream().filter(d -> d.getStrength() == 0).count();
        this.mountains++;
        return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, removed);

    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT, this.mountains));
        builder.append(System.lineSeparator());
        builder.append(ConstantMessages.FINAL_CLIMBERS_STATISTICS);

        Collection<Climber> climbers = climberRepository.getCollection();
        for (Climber climber : climbers) {
            builder.append(System.lineSeparator());
            builder.append(String.format(ConstantMessages.FINAL_CLIMBER_NAME, climber.getName()));
            builder.append(System.lineSeparator());
            builder.append(String.format(ConstantMessages.FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            builder.append(System.lineSeparator());
            if (climber.getRoster().getPeaks().isEmpty()) {
                builder.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS, "None"));

            } else {
                builder.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS,
                        String.join(ConstantMessages.FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks())));
            }
        }
        return builder.toString();
    }
}
