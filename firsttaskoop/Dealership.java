package firsttaskoop;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {

  private String name;
  private ArrayList<Vehicle> vehicles = new ArrayList<>();
  private ArrayList<Customer> customers = new ArrayList<>();

  public Dealership(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);

    System.out.println(
        "Đã thêm " + vehicle.getNameModel() + " vào kho. " + "Số lượng: " + vehicle.getQuantity());
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
    System.out.println("Đã thêm khách hàng " + customer.getName() + " vào danh sách!");
  }

  public ArrayList<Vehicle> showAllVehicles() {
    ArrayList<Vehicle> ans = new ArrayList<>();

    ans.addAll(vehicles);

    return ans;
  }

  public void suggestAlternative(Vehicle vehicleWantToBuy) {
    System.out.println("---Gợi ý các mẫu xe khác cùng loại đang có sẵn tại cửa hàng!!!");
    boolean found = false;
    for (Vehicle vehicle : vehicles) {
      if ((vehicle.getClass().equals(vehicleWantToBuy.getClass()))
          && !(vehicle.equals(vehicleWantToBuy.getName()))
          && vehicle.getQuantity() > 0) {

        System.out.printf("- %s || Giá: %.2f || SL: %d\n",
            vehicle.getName(),
            vehicle.calculatePrice(),
            vehicle.getQuantity());

        found = true;
      }
    }
    if (!found) {
      System.out.println("Rất tiếc!! Không có phương tiện nào có cùng loại mẫu xe");
    }
  }

  public boolean checkingExistCustomer(Customer otherCustomer) {
    boolean found = false;

    for (Customer customer : customers) {
      if (customer.getPhoneNumber().equals(otherCustomer.getPhoneNumber())) {
        found = true;
        break;
      }
    }
    return found;
  }

  public void sellVehicle(String nameVehicle, Customer customer) {
    Vehicle targetVehicle = null;

    for (Vehicle vehicle : vehicles) {
      if (vehicle.getName().equals(nameVehicle)) {
        targetVehicle = vehicle;
        break;
      }
    }

    if (targetVehicle == null || targetVehicle.getQuantity() <= 0) {
      System.out.println("Giao dịch thất bại: Xe không tồn tại hoặc đã hết hàng!!");
      if (targetVehicle != null) {
        suggestAlternative(targetVehicle);
        return;
      }
    }

    BigDecimal rawPrice = targetVehicle.calculatePrice();
    BigDecimal discountRate = customer.getDiscount();
    BigDecimal discountAmount = rawPrice.multiply(discountRate);
    BigDecimal finalPrice = rawPrice.subtract(discountAmount);

    System.out.printf("Giá gốc %.2f VNĐ|| Giảm giá: %.2f VNĐ || Cần thanh toán: %.2f VNĐ\n",
        rawPrice,
        discountAmount,
        finalPrice);

    if (customer.checkingBalance(finalPrice)) {

      customer.pay(finalPrice);
      customer.addVehicle(targetVehicle);
      targetVehicle.updateQuantity(1);

      System.out.println("==> MUA XE THÀNH CÔNG <==");
      System.out.println("Số dư còn lại: " + customer.getAccountBalance());
      System.out.println("Cấp độ hiện tại: " + customer.getLoyaltyLevel());

    } else {
      System.out.println("Giao dịch thất bại: Khách không đủ tiền!!!");
      System.out.println("Khách hàng có thể tham khảo một số chiếc xe khác cùng loại!!");

      this.suggestAlternative(targetVehicle);
    }
  }

  public void showVehicles() {
    for (int i = 0; i < vehicles.size(); i++) {
      System.out.println("Xe số " + (i + 1) + " có thông tin cơ bản như sau:");
      vehicles.get(i).giveBasicInformation();
    }
  }
}
