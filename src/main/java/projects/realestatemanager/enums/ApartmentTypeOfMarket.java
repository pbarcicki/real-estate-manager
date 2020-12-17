package projects.realestatemanager.enums;

public enum ApartmentTypeOfMarket {
    PRIMARY("Primary"),
    SECONDARY("Secondary"),
    RENOVATE("To renovate");

    private final String displayValue;

    ApartmentTypeOfMarket(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
