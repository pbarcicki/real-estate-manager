package projects.realestatemanager.enums;

public enum KitchenType {
    ANNEX("Annex"),
    STUDIO("Studio");

    private final String displayValue;

    KitchenType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
