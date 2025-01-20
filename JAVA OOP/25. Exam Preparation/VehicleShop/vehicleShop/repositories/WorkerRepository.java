package vehicleShop.repositories;


import vehicleShop.models.worker.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WorkerRepository<T> implements Repository<Worker> {

    private Collection<Worker> workers;

    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }


    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(workers);
    }


    public void add(Worker worker) {
        this.workers.add(worker);

    }


    public boolean remove(Worker worker) {
        return this.workers.remove(worker);
    }


    public Worker findByName(String name) {
        return this.workers.stream().filter(worker -> worker.getName().equals(name)).findAny().orElse(null);
    }
}
