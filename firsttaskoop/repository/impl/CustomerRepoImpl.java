package firsttaskoop.repository.impl;

import firsttaskoop.enums.LoyaltyLevel;
import firsttaskoop.model.Customer;
import firsttaskoop.repository.CustomerRepository;
import firsttaskoop.repository.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoImpl implements CustomerRepository {
  public void save(Connection conn, Customer c) throws SQLException {
    String sql = "INSERT INTO customer (name, phone_number, address, account_balance, loyalty_level, owner_vehicle) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, c.getName());
      ps.setString(2, c.getPhoneNumber());
      ps.setString(3, c.getAddress());
      ps.setBigDecimal(4, c.getAccountBalance());
      ps.setString(5, c.getLevel().name());
      ps.setInt(6, c.getOwnerVehicle());

      ps.executeUpdate();

      try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) {
          c.setId(rs.getInt(1));
        }
      }
    }
  }

  public Customer findById(Connection conn, int id) throws SQLException {
    String sql = "SELECT * FROM customer WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new Customer(
              rs.getInt("id"),
              rs.getString("name"),
              rs.getString("phone_number"),
              rs.getString("address"),
              rs.getBigDecimal("account_balance"),
              LoyaltyLevel.valueOf(rs.getString("loyalty_level")),
              rs.getInt("owner_vehicle")
          );
        }
      }
    }
    return null;
  }

  public void updateCustomerAfterSale(Connection conn, Customer c) throws SQLException {
    String sql = "UPDATE customer SET account_balance = ?, loyalty_level = ?, owner_vehicle = ? WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setBigDecimal(1, c.getAccountBalance());
      ps.setString(2, c.getLevel().name());
      ps.setInt(3, c.getOwnerVehicle());
      ps.setInt(4, c.getId());
      ps.executeUpdate();
    }
  }

  public List<Customer> findAll() {
    List<Customer> list = new ArrayList<>();
    String sql = "SELECT * FROM customer";

    try (Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {

      while (rs.next()) {
        list.add(new Customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("phone_number"),
            rs.getString("address"),
            rs.getBigDecimal("account_balance"),
            LoyaltyLevel.valueOf(rs.getString("loyalty_level")),
            rs.getInt("owner_vehicle")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
