package main.model;

public enum House {

    GRYFFINDOR("Gryffindor"),
    SLYTHERIN("Slytherin"),
    RAVENCLAW("Ravenclaw"),
    HUFFLEPUFF("Hufflepuff");

    private final String displayName;

    House(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
