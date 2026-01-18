package firsttaskoop.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import firsttaskoop.model.*;
import firsttaskoop.view.DealershipView;
import firsttaskoop.enums.*;

public class DealershipController {
  private Dealership dealership;
  private List<Customer> customerSystem = new ArrayList<>();
  private DealershipView view;

  public DealershipController(Dealership dealership, DealershipView view) {
    this.dealership = dealership;
    this.view = view;
  }

  public void run() {
    while (true) {
      int choice = view.showMainMenu();
      if (choice == 0) break;
      switch (choice) {
        case 1 -> addVehicleLogic();
        case 2 -> addCustomerLogic();
        case 3 -> sellLogic();
        case 4 -> view.listVehicles(dealership.getInventory());
      }
    }
  }

  private void sellLogic() {
    if (customerSystem.isEmpty()) { view.showMessage("Chưa có khách hàng!"); return; }

    String phone = view.ask("Nhập số điện thoại khách");
    Customer c = null;
    for (Customer cust : customerSystem) {
      if (cust.getPhoneNumber().equals(phone)) { c = cust; break; }
    }

    if (c == null) { view.showMessage("Khách chưa đăng ký!"); return; }

    String model = view.ask("Tên xe mua");
    Vehicle v = dealership.findVehicle(model);
    boolean success = dealership.processActionBuy(v, c);

    if (success) {
      view.showMessage("MUA XE THÀNH CÔNG! Số dư: " + c.getAccountBalance());
    } else {
      view.showMessage("Giao dịch thất bại (Hết hàng hoặc thiếu tiền)");
      if (v != null) view.showSuggestions(dealership.getAlternatives(v));
    }
  }

  private void addVehicleLogic() {
    view.showMessage("--- CHỌN LOẠI XE CẦN NHẬP ---");
    view.showMessage("1. Ô tô (Car) | 2. Xe máy (MotorBike) | 3. Xe đạp (Bike)");
    int type = Integer.parseInt(view.ask("Lựa chọn"));

    String name = view.ask("Tên Model");
    String manufacturer = view.ask("Hãng sản xuất");
    int year = Integer.parseInt(view.ask("Năm sản xuất"));
    BigDecimal price = new BigDecimal(view.ask("Giá gốc"));
    Origin origin = view.askOrigin();
    int qty = Integer.parseInt(view.ask("Số lượng nhập"));

    switch (type) {
      case 1 -> {
        int seats = Integer.parseInt(view.ask("Số chỗ ngồi"));
        String fuel = view.ask("Loại nhiên liệu");
        int cap = Integer.parseInt(view.ask("Dung tích xi lanh"));
        String body = view.ask("Kiểu dáng (Sedan/SUV...)");
        dealership.addVehicle(new Car(name, manufacturer, year, price, origin, seats, fuel, cap, body, qty));
      }
      case 2 -> {
        int cap = Integer.parseInt(view.ask("Phân khối (cc)"));
        int power = Integer.parseInt(view.ask("Công suất"));
        String bikeType = view.ask("Loại xe máy (Sport/Naked...)");
        dealership.addVehicle(new MotorBike(name, manufacturer, year, price, origin, cap, power, bikeType, qty));
      }
      case 3 -> {
        String bikeType = view.ask("Loại xe đạp");
        String material = view.ask("Chất liệu khung");
        dealership.addVehicle(new Bike(name, manufacturer, year, price, origin, bikeType, material, qty));
      }
      default -> view.showMessage("Loại xe không hợp lệ!");
    }
    view.showMessage("Đã cập nhật kho xe thành công!");
  }

  private void addCustomerLogic() {
    String name = view.ask("Tên khách hàng");
    String phone = view.ask("Số điện thoại");
    String address = view.ask("Địa chỉ");
    BigDecimal balance = new BigDecimal(view.ask("Số dư nạp vào"));

    customerSystem.add(new Customer(name, phone, address, balance));
    view.showMessage("Đăng ký khách hàng thành công!");
  }
}