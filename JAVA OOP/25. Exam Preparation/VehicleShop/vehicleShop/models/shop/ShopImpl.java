package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {

        if (worker.canWork()) {
            for (Tool tool : worker.getTools()) {
                while (!tool.isUnfit()) {
                    if (!tool.isUnfit() && worker.canWork()) {
                        vehicle.making();
                        worker.working();
                        tool.decreasesPower();
                    }
                    if (vehicle.reached()) {
                        return;
                    }
                    if (!worker.canWork()) {
                        return;
                    }
                }
            }
        }

    }
}
