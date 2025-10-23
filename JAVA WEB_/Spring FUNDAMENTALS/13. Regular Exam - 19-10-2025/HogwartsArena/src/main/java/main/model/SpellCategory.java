package main.model;

public enum SpellCategory {

    OFFENSE("Offense"),
    DEFENSE("Defense"),
    UTILITY("Utility");

    private final String displayName;

    SpellCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
