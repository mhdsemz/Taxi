package models;

import database.DriverDataBase;
import database.PassengerDataBase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public Main() throws SQLException, ClassNotFoundException {
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Driver> drivers = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        DriverDataBase driverDataBase = new DriverDataBase();
        PassengerDataBase passengerDataBase = new PassengerDataBase();
        Manager manager = new Manager();
        System.out.println("***welcome***");
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                manager.creatDriver(1);
                printStar();
                showMenu();
                answer = scanner.nextInt();
            case 2:
                manager.creatPassenger(2);

                printStar();
                showMenu();
                answer = scanner.nextInt();
            case 3:
                System.out.println("please enter username");
                if (driverDataBase.checkDriver(scanner.next())){
                    System.out.println("you had login");
                    System.out.println("please enter 1 to exit");
                    int number=scanner.nextInt();
                    if (number==1){
                        showMenu();
                        answer=scanner.nextInt();
                    }else{
                        System.out.println("1:register\n2:exit");
                        int num=scanner.nextInt();
                        if (num==1){
                            manager.creatDriver(2);
                        }else if (num==2){
                            showMenu();
                            answer=scanner.nextInt();
                            printStar();
                        }
                    }
                }
            case 4:
                System.out.println("please enter username");
                if (passengerDataBase.checkPassenger(scanner.next())){
                    System.out.println("you had login");
                    System.out.println("please enter 1 to exit");
                    int number=scanner.nextInt();
                    if (number==1){
                        showMenu();
                        answer=scanner.nextInt();
                    }else{
                        System.out.println("1:register\n2:exit");
                        int num=scanner.nextInt();
                        if (num==1){
                            manager.creatPassenger(2);
                        }else if (num==2){
                            showMenu();
                            answer=scanner.nextInt();
                            printStar();
                        }
                    }
                }

            case 5:
                manager.showListOfDrivers();
                printStar();
                showMenu();
                answer = scanner.nextInt();

            case 6:
                manager.showListOfPassenger();
                printStar();
                showMenu();
                answer = scanner.nextInt();
        }

    }

    public static void showMenu() {
        System.out.println("**please select** \n" +
                "1..Add a group of drivers \n" +
                "2.Add a group of passengers \n" +
                "3.Driver signup or login  \n" +
                "4.Passenger signup or login \n" +
                "5.Show a list of drivers \n" +
                "6.Show a list of passengers \n" +
                "your answer is : ");
    }

    public static void printStar() {
        System.out.println("************************************");
    }
}
