package models;

public class Passenger extends Person {
    private boolean stateOfAttendance;
    public Passenger(String firstName, String lastName, String nationalCode, String gender, String birthDate, String phoneNumber,String username,String balance,boolean stateOfAttendance) {
        super(firstName, lastName, nationalCode, gender, birthDate, phoneNumber,username,balance);
        this.stateOfAttendance=stateOfAttendance;
    }

    public Passenger() {
        super();
    }
}
