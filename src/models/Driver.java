package models;

public class Driver extends Person {
    public Driver(String firstName, String lastName, String nationalCode, String gender, String birthDate, String phoneNumber,String username,String balance) {
        super(firstName, lastName, nationalCode, gender, birthDate, phoneNumber,username,balance);
    }

    public Driver() {
        super();
    }

}
