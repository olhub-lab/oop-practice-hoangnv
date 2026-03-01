package firsttaskoop.repository.impl;

import firsttaskoop.model.Dealership;
import firsttaskoop.repository.DBConnector;
import firsttaskoop.repository.DealershipRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DealershipRepoImpl implements DealershipRepository {

  @Override
  public List<Dealership> findAll() {
    return null;
  }

  @Override
  public void save(Dealership dealer) {

  }
}
