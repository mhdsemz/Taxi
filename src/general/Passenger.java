package general;

public class Passenger extends Person {

    public Passenger(String firstName, String lastName, String nationalCode, String gender, String birthDate, String phoneNumber,String username) {
        super(firstName, lastName, nationalCode, gender, birthDate, phoneNumber,username);
    }

    public Passenger() {
        super();
    }
}
