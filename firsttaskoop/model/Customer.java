package firsttaskoop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import firsttaskoop.enums.LoyaltyLevel;

public class Customer {

  private static final int MIN_VEHICLE_SILVER = 3;
  private static final int MAX_VEHICLE_SILVER = 5;
  private static final int MIN_VEHICLE_GOLD = 6;
  private static final int MAX_VEHICLE_GOLD = 10;
  private static final int MIN_VEHICLE_PLATINUM = 11;
  private String name;
  private String phoneNumber;
  private String address;
  private BigDecimal accountBalance;
  private LoyaltyLevel level;
  private List<Vehicle> purchasedHistory;
  private int ownerVehicle;

  public Customer(String name, String phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = BigDecimal.ZERO;
    this.level = LoyaltyLevel.REGULAR;
    this.purchasedHistory = new ArrayList<>();
    this.ownerVehicle = 0;
  }

  public Customer(String name, String phoneNumber, String address,
      BigDecimal accountBalance) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = accountBalance;
    this.purchasedHistory = new ArrayList<>();
    this.level = LoyaltyLevel.REGULAR;
    this.ownerVehicle = 0;
  }

  public String getName() {

    return name;
  }

  public String getPhoneNumber() {

    return phoneNumber;
  }

  public BigDecimal getAccountBalance() {

    return accountBalance;
  }

  public void pay(BigDecimal amount) {
    if (checkingBalance(amount)) {
      this.accountBalance = this.accountBalance.subtract(amount);
    }
  }

  public void addVehicle(Vehicle vehicle) {
    this.purchasedHistory.add(vehicle);
    this.ownerVehicle++;
    updateLoyaltyLevel();
  }

  public boolean checkingBalance(BigDecimal amount) {

    return accountBalance.compareTo(amount) >= 0;
  }

  public BigDecimal getDiscount() {

    return level.getDiscountRate();
  }

  private void updateLoyaltyLevel() {
    if (ownerVehicle <= MAX_VEHICLE_SILVER && ownerVehicle >= MIN_VEHICLE_SILVER) {
      this.level = LoyaltyLevel.SILVER;
    } else if (ownerVehicle <= MAX_VEHICLE_GOLD && ownerVehicle >= MIN_VEHICLE_GOLD) {
      this.level = LoyaltyLevel.GOLD;
    } else if (ownerVehicle >= MIN_VEHICLE_PLATINUM) {
      this.level = LoyaltyLevel.PLATINUM;
    }
  }
}