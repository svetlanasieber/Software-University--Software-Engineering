package climbers.repositories;

import climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MountainRepository implements Repository<Mountain> {
    private Map<String, Mountain> mountains;

    public MountainRepository() {
        this.mountains = new LinkedHashMap<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(this.mountains.values());
    }

    @Override
    public void add(Mountain mountain) {
        this.mountains.putIfAbsent(mountain.getName(), mountain);


    }

    @Override
    public boolean remove(Mountain mountain) {
        return this.mountains.remove(mountain.getName()) != null;
    }

    @Override
    public Mountain byName(String name) {
        if (!this.mountains.containsKey(name)){
            return null;
        }
        return this.mountains.get(name);
    }
}
