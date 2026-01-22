package firsttaskoop.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import firsttaskoop.model.*;
import firsttaskoop.view.DealershipView;
import firsttaskoop.enums.*;

public class DealershipController {

  private List<Dealership> dealerships = new ArrayList<>();
  private List<Customer> customerSystem = new ArrayList<>();
  private DealershipView view;

  public DealershipController(DealershipView view) {
    this.view = view;
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
          addCustomerLogic();
          break;
        case 3:
          sellLogic();
          break;
        case 4:
          showDealerInventoryLogic();
          break;
      }
    }
  }

  private void initialSystem() {
    int numDealers = view.askInt("Nhập số lượng đại lý muốn tạo?!");
    for (int i = 0; i < numDealers; i++) {
      String name = view.askNotEmpty("Tên đại lý thứ " + (i + 1));
      dealerships.add(new Dealership(name));
    }

    int numCustomers = view.askInt("Nhập số lượng khách hàng muốn đăng ký");
    for (int i = 0; i < numCustomers; i++) {
      addCustomerLogic();
    }
  }

  private void showDealerInventoryLogic() {
    if (dealerships.isEmpty()) {
      view.showMessage("Hệ thống chưa có đại lý nào!!");
      return;
    }

    Dealership selectedDealer = view.selectDealership(dealerships);
    if (selectedDealer != null) {
      view.listVehicles(selectedDealer.getInventory());
    }
  }

  private void sellLogic() {
    if (customerSystem.isEmpty()) {
      view.showMessage("Chưa có khách hàng!");
      return;
    }
    if (dealerships.isEmpty()) {
      view.showMessage("Chưa có đại lý nào!!");
      return;
    }

    Customer customer = view.selectCustomer(customerSystem);

    Dealership selectedDealer = view.selectDealership(dealerships);

    String model = view.askNotEmpty("Tên xe mua");
    Vehicle vehicle = selectedDealer.findVehicle(model);
    boolean success = selectedDealer.processActionBuy(vehicle, customer);

    if (success) {
      view.showMessage("MUA XE THÀNH CÔNG! Số dư: " + customer.getAccountBalance());
    } else {
      view.showMessage("Giao dịch thất bại (Hết hàng hoặc thiếu tiền)");
      if (vehicle != null) {
        view.showSuggestions(selectedDealer.getAlternatives(vehicle));
      }
    }
  }

  private void addVehicleLogic() {
    if (dealerships.isEmpty()) {
      view.showMessage("Phải có đại lý mới được nhập xe!!");
      return;
    }

    Dealership targetDealer = view.selectDealership(dealerships);
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
        targetDealer.addVehicle(
            new Car(name, manufacturer, year, price, origin, seats, fuel, cap, body, qty));
        break;
      }
      case 2: {
        int cap = view.askInt("Phân khối (cc)");
        int power = view.askInt("Công suất");
        String bikeType = view.askNotEmpty("Loại xe máy (Sport/Naked...)");
        targetDealer.addVehicle(
            new MotorBike(name, manufacturer, year, price, origin, cap, power, bikeType, qty));
        break;
      }
      case 3: {
        String bikeType = view.askNotEmpty("Loại xe đạp");
        String material = view.askNotEmpty("Chất liệu khung");
        targetDealer.addVehicle(
            new Bike(name, manufacturer, year, price, origin, bikeType, material, qty));
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

    customerSystem.add(new Customer(name, phone, address, balance));
    view.showMessage("Đăng ký khách hàng thành công!");
  }
}