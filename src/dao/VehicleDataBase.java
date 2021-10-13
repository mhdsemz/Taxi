package dao;

import models.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleDataBase extends DataBaseAccess {
    public VehicleDataBase() throws ClassNotFoundException, SQLException {
    }

    DriverDataBase driverDataBase = new DriverDataBase();

    public void addVehicle(String nationalCode, Vehicle vehicle) throws SQLException {
        if (getConnection() != null) {
            if (!checkVehicle(vehicle.getTag())) {
                if (driverDataBase.checkDriver(nationalCode)) {
                    Statement statement = getConnection().createStatement();
                    ResultSet resultSet = statement.executeQuery(String.format("INSERT INTO taxi.vehicle " +
                                    "(id,name, tag, color, vehicle_type, driverid) VALUES (null,'%s', '%s', '%s', '%s', '%s');",
                            vehicle.getName(), vehicle.getTag(), vehicle.getColor(), vehicle.getVehicleType(),
                            driverDataBase.findDriverId(nationalCode)));

                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("your vehicle already exist");

            }
        }
    }

    public boolean checkVehicle(String tag) throws SQLException {
        if (getConnection() != null) {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM taxidatabase.vehicle");
            while (resultSet.next()) {
                if (tag.equals(resultSet.getString("vehicle"))) {
                    return true;
                }
            }
        }
        return false;
    }

}
