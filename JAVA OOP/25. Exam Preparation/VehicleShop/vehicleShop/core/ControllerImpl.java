package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private WorkerRepository<Worker> workerRepository;
    private VehicleRepository<Vehicle> vehicleRepository;
    private Shop shop;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        switch (type) {
            case "FirstShift":
                worker = new FirstShift(workerName);
                break;
            case "SecondShift":
                worker = new SecondShift(workerName);
                break;
            default:
                throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }

        workerRepository.add(worker);
        return String.format(ConstantMessages.ADDED_WORKER, type, worker.getName());

    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);

        vehicleRepository.add(vehicle);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {

        Tool tool = new ToolImpl(power);

        Worker worker = this.workerRepository.findByName(workerName);
        if (this.workerRepository.getWorkers().contains(worker)) {
            this.workerRepository.findByName(workerName).addTool(tool);
        } else {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }


        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> workersList = this.workerRepository.getWorkers().stream().filter(worker -> worker.getStrength() > 70).collect(Collectors.toList());
        if (workersList.isEmpty()) {

            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        int brokenToolsCount = 0;

        Vehicle vehicle = this.vehicleRepository.findByName(vehicleName);

        for (Worker worker : workersList) {
            List<Tool> toolsList = worker.getTools().stream().collect(Collectors.toList());
            shop.make(vehicle, worker);
            brokenToolsCount = (int) worker.getTools().stream().filter(Tool::isUnfit).count();
            if (vehicle.reached()) {
                break;
            }
        }
        if (vehicle.reached()) {
            return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenToolsCount);
        }
        return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenToolsCount);



    }

    @Override
    public String statistics() {
        int size = (int) vehicleRepository.getWorkers().stream().filter(Vehicle::reached).count();
        List<String> collect = workerRepository.getWorkers().stream()
                .map(helper -> String.format("Name: %s, Strength: %d%n" +
                                "Tools: %d fit left%n", helper.getName(), helper.getStrength(),
                        (int) helper.getTools().stream().filter(instrument -> !instrument.isUnfit()).count())).collect(Collectors.toList());
        return String.format("%d vehicles are ready!%n", size) + String.format("Info for workers:%n") + String.join("", collect).trim();
    }
}
