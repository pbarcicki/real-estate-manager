package projects.realestatemanager.enums;

public enum ApartmentStatus {
    FREE("Free"),
    RESERVED("Reserved"),
    CHECK("Check with developer");

    private final String displayValue;

    ApartmentStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
