package handball.entities.gameplay;

import handball.common.ExceptionMessages;
import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseGameplay implements Gameplay {

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    protected BaseGameplay(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int allProtection() {

        return this.equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);

    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);

    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);

    }

    @Override
    public void teamsInGameplay() {
        this.teams.forEach(Team::play);

    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {

        return String.format("%s %s%nTeam: %s%nEquipment: %d, Protection: %d%n",
                this.name, this.getClass().getSimpleName(),
                this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")),
                this.equipments.size(), allProtection());
}
    }

