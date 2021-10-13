package dao;

import models.Travel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TravelDataBase extends DataBaseAccess {


    public void addTravel(Travel travel) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = String.format("INSERT INTO `taxi`.`travel` (`passenger_id_fk`, `origin`, `destination`, `cost`, `payment_type`, `driver_id_fk`," +
                    " `status`) VALUES (?,?,?,?,?,?,?);");
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setString(6, "on_travel");
            statement.setInt(1, travel.getPassengerId());
            statement.setString(2, travel.getDestination());
            statement.setString(3, travel.getOrigin());
            statement.setInt(4, travel.getDriverId());
            statement.setInt(5, travel.getCost());
            statement.executeUpdate(sqlQuery);
        }
    }


    public void createTravel() {
        //TO DO
    }


}
