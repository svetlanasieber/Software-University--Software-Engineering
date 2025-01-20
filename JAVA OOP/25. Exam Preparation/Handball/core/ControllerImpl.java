package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.*;

import static handball.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private EquipmentRepository equipment;
    Map<String, Gameplay> gameplays;

    public ControllerImpl() {

        this.equipment = new EquipmentRepository();
        this.gameplays = new LinkedHashMap<>();

    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {

        if (!validateGamePlayType(gameplayType)) {
            throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }
        Gameplay gameplay = null;
        if (gameplayType.equals("Indoor")) {
            gameplay = new Indoor(gameplayName);
        } else if (gameplayType.equals("Outdoor")) {
            gameplay = new Outdoor(gameplayName);
        }
        this.gameplays.put(gameplayName, gameplay);

        return String.format("Successfully added %s.", gameplayType);

    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment;


        switch (equipmentType) {

            case "Kneepad":
                equipment = new Kneepad();
                this.equipment.add(equipment);
                break;
            case "ElbowPad":
                equipment = new ElbowPad();
                this.equipment.add(equipment);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }

        this.equipment.add(equipment);
        return String.format("Successfully added %s.", equipmentType);
    }


    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipmentToAdd = this.equipment.findByType(equipmentType);
        if (!equipmentType.equals("Kneepad") && !equipmentType.equals("ElbowPad")) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));

        }

        this.gameplays.get(gameplayName).addEquipment(equipmentToAdd);
        this.equipment.remove(equipmentToAdd);
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, equipmentType, gameplayName);


    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {

        Team team;

        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }
        String message = "";
        Gameplay gameplay = gameplays.get(gameplayName);
        boolean isSuitable = gameplay.getClass().getSimpleName().equals("Outdoor") && teamType.equals("Bulgaria") ||
                gameplay.getClass().getSimpleName().equals("Indoor") && teamType.equals("Germany");

        if (!isSuitable) {
            return GAMEPLAY_NOT_SUITABLE;
        }
        this.gameplays.get(gameplayName).addTeam(team);
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);


    }

    @Override
    public String playInGameplay(String gameplayName) {

        Gameplay gameplay = this.gameplays.get(gameplayName);
                gameplay.teamsInGameplay();

                return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName,
                this.gameplays.get(gameplayName).getTeam().stream().mapToInt(Team::getAdvantage).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.gameplays.values().forEach(output::append);
        return output.toString().trim();
    }

    private static boolean validateGamePlayType(String gameplayType) {

        return gameplayType.equals("Outdoor") || gameplayType.equals("Indoor");
    }
}

