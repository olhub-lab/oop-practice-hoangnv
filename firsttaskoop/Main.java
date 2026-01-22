package firsttaskoop;

import firsttaskoop.controller.DealershipController;
import firsttaskoop.model.Dealership;
import firsttaskoop.view.DealershipView;

public class Main {
  public static void main(String[] args) {
    DealershipView view = new DealershipView();
    DealershipController controller = new DealershipController(view);

    controller.run();
  }
}