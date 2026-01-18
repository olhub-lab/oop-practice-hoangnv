package firsttaskoop;

import firsttaskoop.controller.DealershipController;
import firsttaskoop.model.Dealership;
import firsttaskoop.view.DealershipView;

public class Main {
  public static void main(String[] args) {
    Dealership model = new Dealership("Đại lý Bán Xe");
    DealershipView view = new DealershipView();
    DealershipController controller = new DealershipController(model, view);

    controller.run();
  }
}