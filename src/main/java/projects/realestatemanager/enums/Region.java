package projects.realestatemanager.enums;

public enum Region {
    POM("Pomerian"),
    SIL("Silesian"),
    LOWERSIL("Lower Silesia"),
    WESTPOM("West Pomerian");

    private final String displayValue;

    Region(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
