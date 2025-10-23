package main.model;

public enum SpellAlignment {

    LIGHT("Light"),
    NEUTRAL("Neutral"),
    DARK("Dark");

    private final String displayName;

    SpellAlignment(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
