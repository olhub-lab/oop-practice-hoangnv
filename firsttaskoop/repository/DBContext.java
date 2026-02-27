package firsttaskoop.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBContext {

  private static final HikariDataSource dataSource;

  static {
    HikariConfig config = new HikariConfig();

    config.setJdbcUrl("jdbc:mysql://localhost:3306/vehicle_management");
    config.setUsername("root");
    config.setPassword("145hoang");
    config.setDriverClassName("com.mysql.cj.jdbc.Driver");

    config.setMaximumPoolSize(10);
    config.setMinimumIdle(5);
    config.setIdleTimeout(300000);
    config.setConnectionTimeout(20000);

    config.addDataSourceProperty("cachePrepStmts", "true");
    config.addDataSourceProperty("prepStmtCacheSize", "250");
    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

    dataSource = new HikariDataSource(config);
  }

  public static Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }
}