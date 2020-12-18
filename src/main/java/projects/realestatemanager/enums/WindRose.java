package projects.realestatemanager.enums;

public enum WindRose {
    WEST("West"),
    EAST("East"),
    NORTH("North"),
    SOUTH("South");

    private final String displayValue;

    WindRose(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
