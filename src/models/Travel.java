package models;

import enums.Payment;
import enums.TripStatus;

public class Travel {
    private int id;
    private int driverId;
    private int passengerId;
    private String origin;
    private String destination;
    private double cost;
    private Payment payment;
    private TripStatus tripStatus;

    public Travel(int id, int driverId, int passengerId, String origin, String destination, double cost, Payment payment, TripStatus tripStatus) {
        this.id = id;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.payment = payment;
        this.tripStatus = tripStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
}
