package projects.realestatemanager.enums;

public enum Region {
    WEST("West"),
    EAST("East"),
    NORTH("North"),
    SOUTH("South");

    private final String displayValue;

    Region(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
