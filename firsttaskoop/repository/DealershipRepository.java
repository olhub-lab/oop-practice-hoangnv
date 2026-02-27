package firsttaskoop.repository;

import firsttaskoop.model.Dealership;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipRepository {

  public List<Dealership> findAll() {
    List<Dealership> list = new ArrayList<>();
    String sql = "SELECT * FROM dealership";
    try (Connection conn = DBContext.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        Dealership d = new Dealership(rs.getString("name"));
        d.setId(rs.getInt("id"));
        list.add(d);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public void save(Dealership dealer) {
    String sql = "INSERT INTO dealership (name) VALUES (?)";
    try (Connection conn = DBContext.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, dealer.getName());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}