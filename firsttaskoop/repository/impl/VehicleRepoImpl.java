package firsttaskoop.repository.impl;

import firsttaskoop.enums.Origin;
import firsttaskoop.model.Bike;
import firsttaskoop.model.Car;
import firsttaskoop.model.MotorBike;
import firsttaskoop.model.Vehicle;
import firsttaskoop.repository.DBConnector;
import firsttaskoop.repository.VehicleRepository;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepoImpl implements VehicleRepository {

  @Override
  public Vehicle findByNameAndDealer(Connection conn, String modelName, int dealerId)
      throws SQLException {

    return null;
  }

  @Override
  public List<Vehicle> findByDealerId(int dealerId) throws SQLException {
    return null;
  }

  @Override
  public List<Vehicle> findAlternatives(int dealerId, int targetId, String type,
      BigDecimal targetPrice) throws SQLException {

    return null;
  }

  private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
    return null;
  }

  @Override
  public void save(Connection conn, Vehicle v, int dealerId) throws SQLException {

  }

  private void saveCar(Connection conn, Car c, int id) throws SQLException {

  }

  private void saveMotorBike(Connection conn, MotorBike m, int id) throws SQLException {

  }

  private void saveBike(Connection conn, Bike b, int id) throws SQLException {

  }

  @Override
  public void updateQuantity(Connection conn, int vehicleId, int delta) throws SQLException {

  }
}
