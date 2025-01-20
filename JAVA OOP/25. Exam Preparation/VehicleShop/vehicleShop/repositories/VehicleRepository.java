package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VehicleRepository<T> implements Repository<Vehicle> {
    private Collection<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(vehicles);
    }

    @Override
    public void add(Vehicle model) {
        this.vehicles.add(model);

    }

    @Override
    public boolean remove(Vehicle model) {
        return this.vehicles.remove(model);
    }

    @Override
    public Vehicle findByName(String name) {
        return this.vehicles.stream().filter(vehicle -> vehicle.getName().equals(name)).findAny().orElse(null);
    }
}
