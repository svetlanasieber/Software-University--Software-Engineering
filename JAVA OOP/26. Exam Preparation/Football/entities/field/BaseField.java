package football.entities.field;

import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() == this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);

        }
        this.players.add(player);

    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);

    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);

    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);

    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder()
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Player: ");

        if (this.players.isEmpty()) {
            builder.append("none");
        } else {

            builder.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }

        builder
                .append(System.lineSeparator())
                .append("Supplement: ")
                .append(this.supplements.size())
                .append(System.lineSeparator())
                .append("Energy: ")
                .append(this.sumEnergy());

        return builder.toString().trim();

    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
