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

  @Override
  public void save(Connection conn, Customer c) throws SQLException {
  }

  @Override
  public Customer findById(Connection conn, int id) throws SQLException {
    return null;
  }

  @Override
  public void updateCustomerAfterSale(Connection conn, Customer c) throws SQLException {

  }

  @Override
  public List<Customer> findAll() {
    return null;
  }
}
