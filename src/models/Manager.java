package models;

import dao.DriverDataBase;
import dao.PassengerDataBase;
import dao.VehicleDataBase;
import enums.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    List<Driver> drivers = new ArrayList<>();
    List<Passenger> passengers = new ArrayList<>();
    DriverDataBase driverDataBase = new DriverDataBase();
    PassengerDataBase passengerDataBase = new PassengerDataBase();
    VehicleDataBase vehicleDataBase = new VehicleDataBase();
    Driver driver = new Driver();
    Main main = new Main();

    Scanner scanner = new Scanner(System.in);
    private models.Vehicle vehicle;

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
            System.out.println();
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
            System.out.println("PLEASE SELECT TYPE OF YOUR VEHICLE");
            System.out.println("1:van /n 2:motorCycle /n 3:car");
            int numberType = scanner.nextInt();
            switch (numberType) {
                case 1:
                    vehicle.setVehicleType(Vehicle.CAR.getNameOfVehicle());
                    break;
                case 3:
                    vehicle.setVehicleType(Vehicle.VAN.getNameOfVehicle());
                    break;
                case 2:
                    vehicle.setVehicleType(Vehicle.MOTORCYCLE.getNameOfVehicle());
                    break;
            }
            System.out.print(" enter vehicle number: ");
            String carNumber = scanner.next();
            System.out.println("please enter vehicle color : ");
            String carColor = scanner.next();
            vehicleDataBase.addVehicle(nationalCode, vehicle);
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
}


