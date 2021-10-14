package models;

import enums.Payment;
import enums.TravelStatus;

public class Travel {
    private int id;
    private int driverId;
    private int passengerId;
    private String origin;
    private String destination;
    private double cost;
    private Payment payment;
    private TravelStatus travelStatus;

    public Travel(int id, int driverId, int passengerId, String origin, String destination, double cost, Payment payment, TravelStatus travelStatus) {
        this.id = id;
        this.driverId = driverId;
        this.passengerId = passengerId;
        this.origin = origin;
        this.destination = destination;
        this.cost = cost;
        this.payment = payment;
        this.travelStatus = travelStatus;
    }

    public Travel() {

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

    public double getCost() {
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

    public TravelStatus getTripStatus() {
        return travelStatus;
    }

    public void setTripStatus(TravelStatus travelStatus) {
        this.travelStatus = travelStatus;
    }
}
