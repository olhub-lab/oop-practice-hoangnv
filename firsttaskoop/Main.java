package firsttaskoop;

import firsttaskoop.controller.DealershipController;
import firsttaskoop.service.DealershipService;
import firsttaskoop.view.DealershipView;

public class Main {
  public static void main(String[] args) {
    DealershipView view = new DealershipView();
    DealershipService dealershipService = new DealershipService();
    DealershipController controller = new DealershipController(view, dealershipService);

    controller.run();
  }
}