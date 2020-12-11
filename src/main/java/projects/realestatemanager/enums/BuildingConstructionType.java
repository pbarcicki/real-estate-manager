package projects.realestatemanager.enums;

public enum BuildingConstructionType {
    BRICK("Brick"),
    PANEL("Panel"),
    CONCRETE("Concrete"),
    OTHER("Other");

    private final String displayValue;

    BuildingConstructionType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
