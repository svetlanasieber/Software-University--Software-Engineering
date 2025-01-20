package climbers.models.mountain;

import climbers.common.ExceptionMessages;

import java.util.*;

public class MountainImpl implements Mountain {
    private String name;
    private Collection<String> peakList;

    public MountainImpl(String name) {
       setName(name);
        this.peakList = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.MOUNTAIN_NAME_NULL_OR_EMPTY);

        }
        this.name = name;
    }

    @Override
    public Collection<String> getPeaksList() {
        return this.peakList;
    }

    @Override
    public String getName() {
        return name;
    }


}
