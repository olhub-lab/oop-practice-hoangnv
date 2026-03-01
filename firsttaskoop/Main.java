package firsttaskoop;

import firsttaskoop.controller.DealershipController;
import firsttaskoop.repository.CustomerRepository;
import firsttaskoop.repository.DealershipRepository;
import firsttaskoop.repository.VehicleRepository;
import firsttaskoop.repository.impl.CustomerRepoImpl;
import firsttaskoop.repository.impl.DealershipRepoImpl;
import firsttaskoop.repository.impl.VehicleRepoImpl;
import firsttaskoop.service.DealershipService;
import firsttaskoop.view.DealershipView;

public class Main {

  public static void main(String[] args) {
    DealershipRepository dealershipRepository = new DealershipRepoImpl();
    VehicleRepository vehicleRepository = new VehicleRepoImpl();
    CustomerRepository customerRepository = new CustomerRepoImpl();

    DealershipView view = new DealershipView();
    DealershipService dealershipService = new DealershipService(dealershipRepository, vehicleRepository, customerRepository);
    DealershipController controller = new DealershipController(view, dealershipService);

    controller.run();
  }
}