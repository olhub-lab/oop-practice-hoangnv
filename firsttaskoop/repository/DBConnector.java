package firsttaskoop.repository;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnector {

  private static final String URL = "jdbc:mysql://localhost:3306/vehicle_management";
  private static final String USER = "root";
  private static final String PASS = "145hoang";

  private static DBConnector instance;

  private HikariDataSource dataSource;

  private DBConnector() {
    HikariConfig config = new HikariConfig();

    config.setJdbcUrl(URL);
    config.setUsername(USER);
    config.setPassword(PASS);

    config.setMaximumPoolSize(10);
    config.setConnectionTimeout(5000);
    config.setIdleTimeout(600000);
    config.setMaxLifetime(1800000);

    dataSource = new HikariDataSource(config);
    System.out.println("Đã khởi tạo kết nối database thành công !!!!");
  }
  public static DBConnector getInstance() {
    if (instance == null) {
      instance = new DBConnector();
    }
    return instance;
  }

  public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }
}
