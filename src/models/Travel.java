package models;

public class Travel {
    int travelId;
    String source;
    String destination;
    Driver driver;
    Passenger passenger;
    boolean status;
    boolean payType;

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPayType() {
        return payType;
    }

    public void setPayType(boolean payType) {
        this.payType = payType;
    }

    public Travel(int travelId, String source, String destination, Driver driver, Passenger passenger, boolean status, boolean payType) {
        this.travelId = travelId;
        this.source = source;
        this.destination = destination;
        this.driver = driver;
        this.passenger = passenger;
        this.status = status;
        this.payType = payType;
    }
}
