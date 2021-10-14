package models;

public class Driver extends Person {
    public Driver(String username, String firstName, String lastName, String nationalCode, String gender, String birthDate, String phoneNumber, String balance, int id) {
        super(username, firstName, lastName, nationalCode, gender, birthDate, phoneNumber, balance, id);
    }

    public Driver() {
        super();
    }

    public Driver(String gender) {
        super(gender);
    }

}
