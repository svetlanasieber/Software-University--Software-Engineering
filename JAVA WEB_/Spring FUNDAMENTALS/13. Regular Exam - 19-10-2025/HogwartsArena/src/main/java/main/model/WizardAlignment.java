package main.model;

public enum WizardAlignment {

    LIGHT("Light"),
    DARK("Dark");

    private final String displayName;

    WizardAlignment(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
