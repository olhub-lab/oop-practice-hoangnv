package firsttaskoop.repository;

import firsttaskoop.model.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public interface VehicleRepository {

  Vehicle findByNameAndDealer(Connection conn, String modelName, int dealerId)
      throws SQLException;

  List<Vehicle> findByDealerId(int dealerId) throws SQLException;

  List<Vehicle> findAlternatives(int dealerId, int targetId, String type,
      BigDecimal targetPrice) throws SQLException;

  void save(Connection conn, Vehicle v, int dealerId) throws SQLException;

  void updateQuantity(Connection conn, int vehicleId, int delta) throws SQLException;

}