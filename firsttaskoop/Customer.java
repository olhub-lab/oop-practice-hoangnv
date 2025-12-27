package firsttaskoop;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Customer {

  private String name;
  private String phoneNumber;
  private String address;
  private BigDecimal accountBalance;
  private LoyaltyLevel level;
  private ArrayList<Vehicle> listOfVehicles;
  private int ownerVehicle;

  public Customer(String name, String phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = BigDecimal.ZERO;
    this.level = updateLoyaltyLevel();
    this.listOfVehicles = new ArrayList<>();
    this.ownerVehicle = 0;
  }

  public Customer(String nameCustomer, String phoneNumber, String address,
      BigDecimal accountBalance) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = accountBalance;
    this.listOfVehicles = new ArrayList<>();
    this.level = updateLoyaltyLevel();
    this.ownerVehicle = 0;
  }

  public String getName() {
    return name;
  }

  public boolean buyVehicle(Vehicle newVehicle) {
    BigDecimal price = newVehicle.calculatePrice();

    if (accountBalance.compareTo(price) >= 0) {
      accountBalance = accountBalance.subtract(price);
      listOfVehicles.add(newVehicle);
      ownerVehicle++;
      this.level = updateLoyaltyLevel();
      return true;
    } else {
      System.out.println(
          "Số dư trong tài khoản chưa đủ!! Vui lòng nạp thêm để tiếp tục giao dịch!!!");
      return false;
    }
  }

  public void deposit(BigDecimal amount) {
    if (accountBalance.compareTo(amount) >= 0) {
      accountBalance = accountBalance.add(amount);
      System.out.println("Giao dịch thành công: Đã nạp " + amount + " VNĐ");
      System.out.println("Số dư hiện tại của khách hàng " + name + " là " + accountBalance);
    } else {
      System.out.println("Lỗi: Số tiền nạp phải lớn hơn 0.");
    }
  }

  private LoyaltyLevel updateLoyaltyLevel() {
    if (ownerVehicle <= 5 && ownerVehicle > 2) {
      return LoyaltyLevel.SILVER;
    } else if (ownerVehicle <= 10 && ownerVehicle > 5) {
      return LoyaltyLevel.GOLD;
    } else if (ownerVehicle > 10) {
      return LoyaltyLevel.PLATINUM;
    }
    return LoyaltyLevel.REGULAR;
  }


  public void displayCustomer() {
    System.out.println("Khách hàng: " + name);
    System.out.println("Số điện thoại: " + phoneNumber);
    System.out.println("Địa chỉ: " + address);
    System.out.printf("Số dư: %f VNĐ\n", accountBalance);
    System.out.println("Cấp độ thân thiết: " + level);
    System.out.println("Số phương tiện đã sở hữu " + ownerVehicle);
    if (!listOfVehicles.isEmpty()) {
      System.out.println("Danh sách xe:");
      for (Vehicle vehicle : listOfVehicles) {
        System.out.println(" - " + vehicle.getNameModel());
      }
    }
  }
}
