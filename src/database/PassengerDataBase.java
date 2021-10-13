package database;

import models.Passenger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassengerDataBase extends DataBaseAccess {
    public PassengerDataBase() throws ClassNotFoundException, SQLException {
        super();
    }

    public List<Passenger> showListPassengers() throws SQLException {
        List<Passenger> passengers = new ArrayList<>();
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("SELECT * FROM passenger");
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Passenger passenger = new Passenger(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("phone_number"), resultSet.getString("national_code"), resultSet.getString("gender"), resultSet.getString("birth_date"), resultSet.getString("username"),resultSet.getString("balance"));
                passengers.add(passenger);
            }
            return passengers;
        }
        return null;
    }

    public void addPassenger(Passenger passenger) throws SQLException {
        if (getConnection() != null) {
            if (!checkPassenger(passenger.getUsername())) {
                Statement statement = getConnection().createStatement();
                statement.executeUpdate(String.format("INSERT INTO passenger (first_name , last_name , national_code , gender , birth_date, mobile_phone)"
                        + "VALUES ('%s','%s','%s',%b,'%s',%b,%f,'%s')", passenger.getFirstName(), passenger.getLastName(), passenger.getNationalCode(), passenger.getBirthDate(), passenger.getPhoneNumber()));
            }
        }
    }

    public boolean checkPassenger(String username) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT user_name from taxidatabase.passenger");
            while (resultSet.next()) {
                if (username.equals(resultSet.getString("user_name"))) {
                    System.out.println("your username is valid");
                }
            }
        }
        return false;
    }

    public double showBalance(String nationalCode) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String sqlQuery = String.format("SELECT balance from taxidatabase.passenger WHERE national_code='%s'", nationalCode);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                return resultSet.getDouble(1);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public boolean increaseBalance(double balance, String national_code) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            String query = String.format("UPDATE passenger SET balance=%2f WHERE national_code='%s'", national_code, balance);
            int i = statement.executeUpdate(query);
            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}





