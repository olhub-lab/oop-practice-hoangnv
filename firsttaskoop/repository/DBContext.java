package firsttaskoop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class DBContext {

  private static DBContext instance;
  private final String url = "jdbc:mysql://localhost:3306/vehicle_management";
  private final String user = "root";
  private final String pass = "145hoang";
  private final int MAX_POOL_SIZE = 10;
  private LinkedList<Connection> connectionPool = new LinkedList<>();

  private DBContext() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      for (int i = 0; i < 5; i++) {
        connectionPool.add(DriverManager.getConnection(url, user, pass));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static synchronized DBContext getInstance() {
    if (instance == null) {
      instance = new DBContext();
    }
    return instance;
  }

  public synchronized Connection getConnection() throws SQLException {
    if (connectionPool.isEmpty()) {
      return DriverManager.getConnection(url, user, pass);
    }
    return connectionPool.removeFirst();
  }

  public synchronized void releaseConnection(Connection conn) {
    try {
      if (conn != null && !conn.isClosed()) {
        conn.setAutoCommit(true);

        if (connectionPool.size() < MAX_POOL_SIZE) {
          connectionPool.addLast(conn);
        } else {
          conn.close();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}