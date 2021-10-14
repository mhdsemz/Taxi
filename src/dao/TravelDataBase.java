package dao;

import enums.TravelStatus;
import models.Travel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TravelDataBase extends DataBaseAccess {
    Travel travel=new Travel();
    private Connection getconnection;


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
            statement.setDouble(5, travel.getCost());
            statement.executeUpdate(sqlQuery);
        }
    }


    public void updateStatus(Travel travel, TravelStatus travelStatus) throws SQLException {
        if (getConnection() != null) {
            String sql = "UPDATE trips SET status = ? WHERE id = ?;";
            PreparedStatement statement = getconnection.prepareStatement(sql);
            statement.setString(1, travelStatus.toString().toLowerCase());
            statement.setInt(2, travel.getId());
            statement.executeUpdate();
        }
    }

}
