package enums;

public enum Vehicle {
    VAN("van"),
    MOTORCYCLE("motorCycle"),
    CAR("car"),
    PICKUP("pickUp");
    private String nameOfVehicle;

    Vehicle(String nameOfVehicle) {
        this.nameOfVehicle = nameOfVehicle;
    }
    public String getNameOfVehicle() {
        return nameOfVehicle;
    }
}