package general;

public enum Vehicle {
    VAN("van"),
    MOTORCYCLE("motorCycle"),
    CAR("car"),
    PICKUP("pickUp");
    private String name;

    Vehicle(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}