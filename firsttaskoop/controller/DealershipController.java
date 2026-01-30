package firsttaskoop.controller;

import firsttaskoop.service.DealershipService;
import java.math.BigDecimal;
import firsttaskoop.model.*;
import firsttaskoop.view.DealershipView;
import firsttaskoop.enums.*;
import java.util.List;

public class DealershipController {

  private DealershipView view;
  private DealershipService dealershipService;

  public DealershipController(DealershipView view, DealershipService dealershipService) {
    this.view = view;
    this.dealershipService = dealershipService;
  }

  public void run() {
    initialSystem();

    while (true) {
      int choice = view.showMainMenu();
      if (choice == 0) {
        break;
      }
      switch (choice) {
        case 1:
          addVehicleLogic();
          break;
        case 2:
          sellLogic();
          break;
        case 3:
          showDealerInventoryLogic();
          break;
        default:
          System.out.println(">> Vui lòng nhập đúng số thứ tự!!");
          break;
      }
    }
  }

  private void initialSystem() {
    int numDealers = view.askInt("Nhập số lượng đại lý muốn tạo?!");
    for (int i = 0; i < numDealers; i++) {
      String name = view.askNotEmpty("Tên đại lý thứ " + (i + 1));
      dealershipService.addDealership(name);
    }

    int numCustomers = view.askInt("Nhập số lượng khách hàng muốn đăng ký");
    for (int i = 0; i < numCustomers; i++) {
      addCustomerLogic();
    }
  }

  private void showDealerInventoryLogic() {
    if (dealershipService.getAllDealerships().isEmpty()) {
      view.showMessage("Hệ thống chưa có đại lý nào!!");
      return;
    }

    Dealership selectedDealer = view.selectDealership(dealershipService.getAllDealerships());
    if (selectedDealer != null) {
      view.listVehicles(selectedDealer.getInventory());
    }
  }

  private void sellLogic() {
    if (dealershipService.getAllCustomers().isEmpty()) {
      view.showMessage("Chưa có khách hàng!");
      return;
    }
    if (dealershipService.getAllDealerships().isEmpty()) {
      view.showMessage("Chưa có đại lý nào!!");
      return;
    }

    Customer customer = view.selectCustomer(dealershipService.getAllCustomers());
    Dealership selectedDealer = view.selectDealership(dealershipService.getAllDealerships());
    view.listVehicles(selectedDealer.getInventory());

    String model = view.askNotEmpty("Tên xe mua");
    boolean success = dealershipService.sellVehicle(customer,model,selectedDealer);

    if (success) {
      view.showMessage("MUA XE THÀNH CÔNG! Số dư: " + customer.getAccountBalance());
    } else {
      view.showMessage("Giao dịch thất bại (Hết hàng hoặc thiếu tiền)");

      List<Vehicle> suggestedVehicles = dealershipService.getSuggestedVehicles(selectedDealer, model);

      view.showSuggestions(suggestedVehicles);
    }
  }

  private void addVehicleLogic() {
    if (dealershipService.getAllDealerships().isEmpty()) {
      view.showMessage("Phải có đại lý mới được nhập xe!!");
      return;
    }

    Dealership targetDealer = view.selectDealership(dealershipService.getAllDealerships());
    if (targetDealer == null) {
      return;
    }

    view.showMessage("--- CHỌN LOẠI XE CẦN NHẬP ---");
    view.showMessage("1. Ô tô (Car) | 2. Xe máy (MotorBike) | 3. Xe đạp (Bike)");
    int type = view.askInt("Lựa chọn");

    String name = view.askNotEmpty("Tên Model");
    String manufacturer = view.askNotEmpty("Hãng sản xuất");
    int year = view.askInt("Năm sản xuất");
    BigDecimal price = view.askBigDecimal("Giá gốc");
    Origin origin = view.askOrigin();
    int qty = view.askInt("Số lượng nhập");

    switch (type) {
      case 1: {
        int seats = view.askInt("Số chỗ ngồi");
        String fuel = view.askNotEmpty("Loại nhiên liệu");
        int cap = view.askInt("Dung tích xi lanh");
        String body = view.askNotEmpty("Kiểu dáng (Sedan/SUV...)");
        dealershipService.addCarToDealer(targetDealer,
            name, manufacturer, year, price, origin,
            seats, fuel, cap, body, qty);
        break;
      }
      case 2: {
        int cap = view.askInt("Phân khối (cc)");
        int power = view.askInt("Công suất");
        String bikeType = view.askNotEmpty("Loại xe máy (Sport/Naked...)");
        dealershipService.addMotorbikeToDealer(targetDealer, name, manufacturer, year, price, origin, cap, power, bikeType, qty);
        break;
      }
      case 3: {
        String bikeType = view.askNotEmpty("Loại xe đạp");
        String material = view.askNotEmpty("Chất liệu khung");
        dealershipService.addBikeToDealer(targetDealer, name, manufacturer, year, price, origin, bikeType, material, qty);
        break;
      }
      default:
        view.showMessage("Loại xe không hợp lệ!");
        break;
    }
    view.showMessage("Đã cập nhật kho xe thành công!");
  }

  private void addCustomerLogic() {
    String name = view.askNotEmpty("Tên khách hàng");
    String phone = view.askNotEmpty("Số điện thoại");
    String address = view.askNotEmpty("Địa chỉ");
    BigDecimal balance = view.askBigDecimal("Số dư nạp vào");

    dealershipService.addCustomer(name, phone, address, balance);
    view.showMessage("Đăng ký khách hàng thành công!");
  }
}