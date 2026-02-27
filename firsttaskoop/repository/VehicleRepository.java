package firsttaskoop.repository;

import firsttaskoop.model.*;
import firsttaskoop.enums.Origin;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

  private final String BASE_SELECT_SQL =
      "SELECT v.*, c.seat_number, c.capacity AS car_cap, c.body_type, c.fuel_type, " +
          "m.capacity AS mb_cap, m.power, m.type_of_motorbike, " +
          "b.bike_type, b.frame_material " +
          "FROM vehicles v " +
          "LEFT JOIN car c ON v.id = c.vehicle_id " +
          "LEFT JOIN motorbike m ON v.id = m.vehicle_id " +
          "LEFT JOIN bike b ON v.id = b.vehicle_id ";

  public Vehicle findByNameAndDealer(Connection conn, String modelName, int dealerId)
      throws SQLException {
    String sql = "SELECT v.*, c.seat_number, c.capacity AS car_cap, c.body_type, c.fuel_type, " +
        "m.capacity AS mb_cap, m.power, m.type_of_motorbike, " +
        "b.bike_type, b.frame_material " +
        "FROM vehicles v " +
        "LEFT JOIN car c ON v.id = c.vehicle_id " +
        "LEFT JOIN motorbike m ON v.id = m.vehicle_id " +
        "LEFT JOIN bike b ON v.id = b.vehicle_id " +
        "WHERE v.name_model = ? AND v.dealership_id = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, modelName);
      ps.setInt(2, dealerId);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return mapRowToVehicle(rs);
        }
      }
    }
    return null;
  }

  public List<Vehicle> findByDealerId(int dealerId) throws SQLException {
    List<Vehicle> list = new ArrayList<>();
    String sql = BASE_SELECT_SQL + "WHERE v.dealership_id = ?";

    try (Connection conn = DBContext.getConnection();) {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, dealerId);

      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          list.add(mapRowToVehicle(rs));
        }
      }
    }
    return list;
  }

  public List<Vehicle> findAlternatives(int dealerId, int targetId, String type,
      BigDecimal targetPrice) throws SQLException {
    List<Vehicle> list = new ArrayList<>();
    String sql = "SELECT v.*, c.seat_number, c.capacity AS car_cap, c.body_type, c.fuel_type, " +
        "m.capacity AS mb_cap, m.power, m.type_of_motorbike, " +
        "b.bike_type, b.frame_material " +
        "FROM vehicles v " +
        "LEFT JOIN car c ON v.id = c.vehicle_id " +
        "LEFT JOIN motorbike m ON v.id = m.vehicle_id " +
        "LEFT JOIN bike b ON v.id = b.vehicle_id " +
        "WHERE v.dealership_id = ? AND v.vehicle_type = ? AND v.id != ? AND v.base_price < ? AND v.quantity > 0";

    try (Connection conn = DBContext.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, dealerId);
      ps.setString(2, type);
      ps.setInt(3, targetId);
      ps.setBigDecimal(4, targetPrice);
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          list.add(mapRowToVehicle(rs));
        }
      }
    }
    return list;
  }

  private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
    String type = rs.getString("vehicle_type");
    String name = rs.getString("name_model");
    String manu = rs.getString("manufacturer");
    int year = rs.getInt("birth_year");
    BigDecimal price = rs.getBigDecimal("base_price");
    Origin origin = Origin.valueOf(rs.getString("origin"));
    int qty = rs.getInt("quantity");
    int id = rs.getInt("id");

    Vehicle v;
    if ("car".equalsIgnoreCase(type)) {
      v = new Car(name, manu, year, price, origin,
          rs.getInt("seat_number"), rs.getString("fuel_type"),
          rs.getInt("car_cap"), rs.getString("body_type"), qty);
    } else if ("motorbike".equalsIgnoreCase(type)) {
      v = new MotorBike(name, manu, year, price, origin,
          rs.getInt("mb_cap"), rs.getInt("power"),
          rs.getString("type_of_motorbike"), qty);
    } else {
      v = new Bike(name, manu, year, price, origin,
          rs.getString("bike_type"), rs.getString("frame_material"), qty);
    }
    v.setId(id);
    return v;
  }

  public void save(Connection conn, Vehicle v, int dealerId) throws SQLException {
    String sqlParent = "INSERT INTO vehicles (name_model, manufacturer, birth_year, base_price, quantity, origin, vehicle_type, dealership_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    int generatedId = -1;

    try (PreparedStatement ps = conn.prepareStatement(sqlParent, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, v.getNameModel());
      ps.setString(2, v.getManufacturer());
      ps.setInt(3, v.getBirthYear());
      ps.setBigDecimal(4, v.getOriginalPrice());
      ps.setInt(5, v.getQuantity());
      ps.setString(6, v.getOrigin().name());
      ps.setString(7, v.getClass().getSimpleName().toLowerCase());
      ps.setInt(8, dealerId);
      ps.executeUpdate();

      try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
          generatedId = rs.getInt(1);
        }
      }
    }

    if (v instanceof Car) {
      saveCar(conn, (Car) v, generatedId);
    } else if (v instanceof MotorBike) {
      saveMotorBike(conn, (MotorBike) v, generatedId);
    } else if (v instanceof Bike) {
      saveBike(conn, (Bike) v, generatedId);
    }
  }

  private void saveCar(Connection conn, Car c, int id) throws SQLException {
    String sql = "INSERT INTO car (vehicle_id, seat_number, capacity, body_type, fuel_type) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.setInt(2, c.getSeatNumber());
      ps.setInt(3, c.getCapacity());
      ps.setString(4, c.getBodyType());
      ps.setString(5, c.getFuelType());
      ps.executeUpdate();
    }
  }

  private void saveMotorBike(Connection conn, MotorBike m, int id) throws SQLException {
    String sql = "INSERT INTO motorbike (vehicle_id, capacity, power, type_of_motorbike) VALUES (?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.setInt(2, m.getCapacity());
      ps.setInt(3, m.getPower());
      ps.setString(4, m.getTypeOfMotorBike());
      ps.executeUpdate();
    }
  }

  private void saveBike(Connection conn, Bike b, int id) throws SQLException {
    String sql = "INSERT INTO bike (vehicle_id, bike_type, frame_material) VALUES (?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.setString(2, b.getBikeType());
      ps.setString(3, b.getFrameMaterial());
      ps.executeUpdate();
    }
  }

  public void updateQuantity(Connection conn, int vehicleId, int delta) throws SQLException {
    String sql = "UPDATE vehicles SET quantity = quantity + ? WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, delta);
      ps.setInt(2, vehicleId);
      ps.executeUpdate();
    }
  }
}