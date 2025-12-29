package firsttaskoop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;
  private String phoneNumber;
  private String address;
  private BigDecimal accountBalance;
  private LoyaltyLevel level;
  private List<Vehicle> vehicles;
  private int ownerVehicle;

  private static final int MIN_VEHICLE_SILVER = 3;
  private static final int MAX_VEHICLE_SILVER = 5;
  private static final int MIN_VEHICLE_GOLD = 6;
  private static final int MAX_VEHICLE_GOLD = 10;
  private static final int MIN_VEHICLE_PLATINUM = 11;

  public Customer(String name, String phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = BigDecimal.ZERO;
    this.level = updateLoyaltyLevel();
    this.vehicles = new ArrayList<>();
    this.ownerVehicle = 0;
  }

  public Customer(String name, String phoneNumber, String address,
      BigDecimal accountBalance) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = accountBalance;
    this.vehicles = new ArrayList<>();
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
      vehicles.add(newVehicle);
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
    if (amount.compareTo(BigDecimal.ZERO) > 0) {
      accountBalance = accountBalance.add(amount);
      System.out.println("Giao dịch thành công: Đã nạp " + amount + " VNĐ");
      System.out.println("Số dư hiện tại của khách hàng " + name + " là " + accountBalance);
    } else {
      System.out.println("Lỗi: Số tiền nạp phải lớn hơn 0.");
    }
  }

  private LoyaltyLevel updateLoyaltyLevel() {
    if (ownerVehicle <= MAX_VEHICLE_SILVER && ownerVehicle >= MIN_VEHICLE_SILVER) {
      return LoyaltyLevel.SILVER;
    } else if (ownerVehicle <= MAX_VEHICLE_GOLD && ownerVehicle > MIN_VEHICLE_GOLD) {
      return LoyaltyLevel.GOLD;
    } else if (ownerVehicle >= MIN_VEHICLE_PLATINUM) {
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
    if (!vehicles.isEmpty()) {
      System.out.println("Danh sách xe:");
      for (Vehicle vehicle : vehicles) {
        System.out.println(" - " + vehicle.getNameModel());
      }
    }
  }
}
