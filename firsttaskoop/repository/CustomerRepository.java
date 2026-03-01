package firsttaskoop.repository;

import firsttaskoop.model.Customer;
import java.sql.*;
import java.util.List;

public interface CustomerRepository {

  void save(Connection conn, Customer c) throws SQLException;

  Customer findById(Connection conn, int id) throws SQLException;

  void updateCustomerAfterSale(Connection conn, Customer c) throws SQLException;

  List<Customer> findAll();
}