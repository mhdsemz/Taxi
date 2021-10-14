package models;

import dao.DriverDataBase;
import dao.PassengerDataBase;
import dao.TravelDataBase;
import dao.VehicleDataBase;
import enums.Payment;
import enums.TravelStatus;
import enums.UserStatus;
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
    TravelDataBase travelDataBase = new TravelDataBase();
    Driver driver = new Driver();
    Main main = new Main();
    Travel travel = new Travel();
    Passenger passenger = new Passenger();
    String origin;
    String destination;
    private double accountBalance;

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

    public void signUpOrLoginForDriver(int number, Driver driver) throws SQLException {
        System.out.println("please enter your personal id");
        if (driverDataBase.checkDriver(scanner.next())) {
            System.out.println("you had login");
            String status = driver.getUserStatus().toString();

            if (status.equals(UserStatus.WAITING.toString())) {
                System.out.println("you should waiting for travel");
            } else if (status.equals(UserStatus.NO_REQUEST.toString())) {
                System.out.println("1:you can accept a trip \n " +
                        "2:you can exit \n ");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        driver.setUserStatus(UserStatus.WAITING);
                        driverDataBase.updateStatus(driver, driver.getUserStatus());
                        break;
                    case 2:
                        break;
                }
            } else if (status.equals(UserStatus.ON_TRIP.toString())) {
                Payment payment = null;
                boolean configByDriver;
                payment = travel.getPayment();
                System.out.println("now you are on travel!!! please enter your selection \n" +
                        "1:confirm that you got cashPay \n " +
                        "2:end the travel \n " +
                        "3:exit ");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        if (payment.equals(Payment.ACCOUNT_BALANCE)) {
                            System.out.println("your passenger has paid with account balance");
                        } else if (payment.equals(Payment.CASH)) {
                            System.out.println("your payment config !! \n your passenger has paid by cash");
                            configByDriver = true;
                            passengerDataBase.updateStatus(UserStatus.NO_REQUEST, passenger);
                            travelDataBase.updateStatus(travel, TravelStatus.FINISHED);
                            driverDataBase.updateStatus(driver, UserStatus.NO_REQUEST);

                        } else {
                            System.out.println(" something wrong in pay");
                        }
                        break;
                    case 2:
                        System.out.println("your travel is ended");
                }
            } else {
                System.out.println("not valid");

            }
        }
    }

    public void showProPassengerMenu(Passenger passenger) throws SQLException {
        System.out.println("please choose your number \n " +
                " 1.Travel request (pay by cash) \n " +
                " 2.Travel request (pay by account balance) \n " +
                " 3.Increase account balance \n " +
                "4: exit");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
            case 2:
                System.out.print("enter coordinates of origin(split with ',' ): ");
                origin = scanner.nextLine();
                System.out.print("enter coordinates of destination(split with ',' ): ");
                destination = scanner.nextLine();
                setOriginAndDestinationAndReturnCost();
                break;
            case 3:
                System.out.println("please enter amount of increase ");
                double amount = scanner.nextDouble();
                double newAccountBalance = increaseAccountBalance(amount);
                passengerDataBase.increaseBalance(newAccountBalance,passenger.getId());
                break;
            case 4:
                showMenu();
                break;
        }
    }

    public int setOriginAndDestinationAndReturnCost() {
        System.out.println("please enter your origin and destination like this --> (origin,destination)");
        String[] originCoordinates = origin.split(",");
        double x1 = Integer.parseInt(originCoordinates[0]);
        double y1 = Integer.parseInt(originCoordinates[1]);

        String[] destinationCoordinate = destination.split("'");
        double x2 = Integer.parseInt(destinationCoordinate[0]);
        double y2 = Integer.parseInt(destinationCoordinate[1]);


        int cost = (int) (Math.floor(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))) * 1000);
        return cost;
    }

    public static void showMenu() {
        System.out.println("**please select** \n" +
                "1..Add a group of drivers \n" +
                "2.Add a group of passengers \n" +
                "3.Driver signup or login  \n" +
                "4.Passenger signup or login \n" +
                "5.Show a list of drivers \n" +
                "6.Show a list of passengers \n" +
                "7:show ongoing travel \n" +
                "your answer is : ");
    }

    public int increaseAccountBalance(Double amount) {
        return (int) (accountBalance += amount);
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
}



