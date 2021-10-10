package database;

import models.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriverDataBase extends DataBaseAccess {
    public DriverDataBase() throws ClassNotFoundException, SQLException {
    }

    public int addDriver(Driver driver) throws SQLException {
        if (getConnection() != null) {
            if (!checkDriver(driver.getUsername())) {
                Statement statement = getConnection().createStatement();
                String sqlQuery = String.format("INSERT INTO driver (first_name , last_name , national_code , mobile_phone , gender , birthDate,username ) VALUES ('%s','%s','%s','%s',%b,'%s','%s',%f)",
                        driver.getFirstName(), driver.getLastName(), driver.getNationalCode(), driver.getPhoneNumber(), driver.getBirthDate(), driver.getGender(), driver.getUsername());
                int J = statement.executeUpdate(sqlQuery);
                return J;
            } else {
                return 0;
            }
        }
        return 0;
    }

        public List<Driver> showListDrivers () throws SQLException {
            List<Driver> drivers = new ArrayList<>();
            if (getConnection() != null) {
                Statement statement = getConnection().createStatement();
                String sqlQuery = String.format("SELECT * FROM driver");
                ResultSet resultSet = statement.executeQuery(sqlQuery);
                while (resultSet.next()) {
                    Driver driver = new Driver(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("nationalcode")
                            , resultSet.getString("gender"), resultSet.getString("birth_date"), resultSet.getString("phone_number"), resultSet.getString("username"));
                    drivers.add(driver);
                }
                return drivers;
            }
            return null;
        }


        public boolean checkDriver (String nationalCode) throws SQLException {
            if (getConnection() != null) {
                Statement statement = null;
                try {
                    statement = getConnection().createStatement();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ResultSet resultSet = statement.executeQuery("SELECT nationalcode from taxidatabase.driver");
                while (resultSet.next()) {
                    if (nationalCode.equals(resultSet.getString("nationalCode"))) {
                        System.out.println("your nationalCode is valid");
                    }
                }
            }
            return false;
        }
        public int findDriverId(String username) throws SQLException {
            int id=0;
        if(getConnection() !=null){
            Statement statement=getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(String.format("SELECT id FROM taxidatabase.driver where user_name='%s'",username));
            if (resultSet.next()){
                id=resultSet.getInt("id");
            }
        }
            return id;
        }

    }



