package models;

public class Passenger extends Person {

    public Passenger(String firstName, String lastName, String nationalCode, String gender, String birthDate, String phoneNumber,String username,String balance) {
        super(firstName, lastName, nationalCode, gender, birthDate, phoneNumber,username,balance);
    }

    public Passenger() {
        super();
    }
}
