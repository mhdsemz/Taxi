package general;

import database.DriverDataBase;
import database.PassengerDataBase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    List<Driver> drivers = new ArrayList<>();
    List<Passenger> passengers = new ArrayList<>();
    DriverDataBase driverDataBase = new DriverDataBase();
    PassengerDataBase passengerDataBase = new PassengerDataBase();
    Driver driver = new Driver();
    Main main=new Main();

    Scanner scanner = new Scanner(System.in);

    public Manager() throws SQLException, ClassNotFoundException {
    }


    public void creatDriver(int caseNumber) throws SQLException {
        int count = 0;
        if (caseNumber == 1) {
            System.out.println("please enter number of drivers that you want to add");
            count = scanner.nextInt();
        } else if (caseNumber == 3) {
            count = 1;
        }
        Driver[] drivers = new Driver[count];
        for (int i = 0; i < count; i++) {
            System.out.println("please enter new information for Driver");
            scanner.nextLine();
            System.out.println("enter firstName : ");
            String firstName = scanner.next();
            System.out.println("enter lastName : ");
            String lastName = scanner.next();
            System.out.println("enter nationalCode : ");
            String nationalCode = scanner.next();
            System.out.println("enter gender : ");
            String gender = scanner.next();
            System.out.println("enter birthDate : ");
            String birthdate = scanner.next();
            System.out.println("enter phoneNumber : ");
            String phoneNumber = scanner.next();
            System.out.print(" enter vehicle number: ");
            String carNumber = scanner.next();
            System.out.println("enter vehicleModel : ");
            String carModel = scanner.next();
            System.out.println("please enter vehicle color : ");
            String carColor = scanner.next();
            drivers[i] = new Driver();
        }
    }

    public void creatPassenger(int caseNumber) throws SQLException {
        int count = 0;
        if (caseNumber == 2) {
            System.out.println("please enter number of passengers that you want to add");
            count = scanner.nextInt();
        } else if (caseNumber == 4) {
            count = 1;
        }
        Passenger[] passengers = new Passenger[count];
        Passenger passenger = new Passenger();
        for (int i = 0; i < count; i++) {
            System.out.println("please enter new information for Passenger");
            scanner.nextLine();
            System.out.println("enter firstName : ");
            String firstName = scanner.next();
            System.out.println("enter lastName : ");
            String lastName = scanner.next();
            System.out.println("enter nationalCode : ");
            String nationalCode = scanner.next();
            System.out.println("enter gender : ");
            String gender = scanner.next();
            System.out.println("enter birthDate : ");
            String birthdate = scanner.next();
            System.out.println("enter phoneNumber : ");
            String phoneNumber = scanner.next();
            passengers[i] = new Passenger();
            passengerDataBase.addPassenger(passengers[i]);
        }
    }


    public void showListOfDrivers() throws SQLException {
        drivers = driverDataBase.showListDrivers();
        for (int i = 0; i < drivers.size(); i++) {
            System.out.println(drivers.get(i));
        }
    }

    public void showListOfPassenger() throws SQLException {
        passengers = passengerDataBase.showListPassengers();
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println(passengers.get(i));
        }
    }

//    public void signupOrLoginPassenger() throws SQLException {
//        System.out.println("enter your username (nationalCode)");
//        String inputNationalCode = scanner.nextLine();
//        if (passengerDataBase.checkPassenger(inputNationalCode)){
//            System.out.println("you had log in ");
//            System.out.println("please enter 1 ");
//
//            }
//        }
}


