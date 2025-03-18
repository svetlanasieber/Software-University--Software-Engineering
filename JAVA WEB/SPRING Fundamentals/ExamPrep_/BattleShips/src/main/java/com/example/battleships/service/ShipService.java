package com.example.battleships.service;

import com.example.battleships.model.service.ShipAddServiceModel;
import com.example.battleships.model.view.ShipsViewModel;

import java.util.List;

public interface ShipService {

    ShipAddServiceModel addShip(ShipAddServiceModel shipAddServiceModel);

    List<ShipsViewModel> findAllShipsByUser(Long id);

    List<ShipsViewModel> findAllShipsByUserNot(Long id);

    List<ShipsViewModel> findAllShips();

    void fire(String attackerShip, String defenderShip);
}
