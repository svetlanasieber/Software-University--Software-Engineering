package com.example.battleships.service.impl;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.service.ShipAddServiceModel;
import com.example.battleships.model.view.ShipsViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import com.example.battleships.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public ShipAddServiceModel addShip(ShipAddServiceModel shipAddServiceModel) {

//        Category category = categoryService.findCategoryByNameEnum(shipAddServiceModel.getCategory());
//        User user = userService.findUserById(currentUser.getId());

        Ship ship = modelMapper.map(shipAddServiceModel, Ship.class)
                .setCategory(categoryService.findCategoryByNameEnum(shipAddServiceModel.getCategory()))
                .setUser(userService.findUserById(currentUser.getId()));

        return modelMapper.map(shipRepository.save(ship), ShipAddServiceModel.class);
    }

    @Override
    public List<ShipsViewModel> findAllShipsByUser(Long id) {

        return shipRepository
                .findByUser_Id(id)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipsViewModel.class))
                .toList();
    }

    @Override
    public List<ShipsViewModel> findAllShipsByUserNot(Long id) {

        return shipRepository
                .findAllOtherShips(id)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipsViewModel.class))
                .toList();
    }

    @Override
    public List<ShipsViewModel> findAllShips() {

        return shipRepository.findAll()
                .stream()
                .map(ship -> modelMapper.map(ship, ShipsViewModel.class))
                .toList();
    }

    @Override
    public void fire(String attackerShip, String defenderShip) {
        Ship attacker = shipRepository.getByName(attackerShip).orElse(null);
        Ship defender = shipRepository.getByName(defenderShip).orElse(null);

        if (defender != null && attacker != null) {
            defender.setHealth(defender.getHealth() - attacker.getPower());

            if (defender.getHealth() <= 0) {
                shipRepository.delete(defender);
            } else {
                shipRepository.save(defender);
            }
        }
    }

}
