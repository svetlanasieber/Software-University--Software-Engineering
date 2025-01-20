package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClimberRepository implements Repository<Climber> {

    private Map<String, Climber> climbers;

    public ClimberRepository() {
        this.climbers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(this.climbers.values());
    }

    @Override
    public void add(Climber climber) {
        climbers.putIfAbsent(climber.getName(), climber);


    }

    @Override
    public boolean remove(Climber climber) {
        return this.climbers.remove(climber.getName()) != null ;
    }

    @Override
    public Climber byName(String name) {
       if (!this.climbers.containsKey(name)){
           return  null;
       }
       return  this.climbers.get(name);
    }
}
