package com.example.battleships.model.binding;

public class BattleShipsBindingModel {

    private String attackerShip;
    private String defenderShip;

    public BattleShipsBindingModel() {
    }

    public String getAttackerShip() {
        return attackerShip;
    }

    public BattleShipsBindingModel setAttackerShip(String attackerShip) {
        this.attackerShip = attackerShip;
        return this;
    }

    public String getDefenderShip() {
        return defenderShip;
    }

    public BattleShipsBindingModel setDefenderShip(String defenderShip) {
        this.defenderShip = defenderShip;
        return this;
    }
}
