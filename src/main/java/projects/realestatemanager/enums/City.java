package projects.realestatemanager.enums;

public enum City {
    WROCLAW("Wrocław"),
    KATOWICE("Katowice"),
    POZNAN("Poznań"),
    BERLIN("Berlin");

    private final String displayValue;

    City(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
