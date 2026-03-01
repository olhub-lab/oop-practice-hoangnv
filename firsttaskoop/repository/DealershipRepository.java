package firsttaskoop.repository;

import firsttaskoop.model.Dealership;
import java.util.List;

public interface DealershipRepository {

  List<Dealership> findAll();

  void save(Dealership dealer);

}