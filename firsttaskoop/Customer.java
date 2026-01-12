package firsttaskoop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {

  private static final int MIN_VEHICLE_SILVER = 3;
  private static final int MAX_VEHICLE_SILVER = 5;
  private static final int MIN_VEHICLE_GOLD = 6;
  private static final int MAX_VEHICLE_GOLD = 10;
  private static final int MIN_VEHICLE_PLATINUM = 11;
  private static final BigDecimal DISCOUNT_FOR_GOLD = new BigDecimal("0.05");
  private static final BigDecimal DISCOUNT_FOR_PLATINUM = new BigDecimal("0.10");
  private String name;
  private String phoneNumber;
  private String address;
  private BigDecimal accountBalance;
  private LoyaltyLevel level;
  private List<Vehicle> purschaseHistory;
  private int ownerVehicle;

  public Customer(String name, String phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = BigDecimal.ZERO;
    this.level = updateLoyaltyLevel();
    this.purschaseHistory = new ArrayList<>();
    this.ownerVehicle = 0;
  }

  public Customer(String name, String phoneNumber, String address,
      BigDecimal accountBalance) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = accountBalance;
    this.purschaseHistory = new ArrayList<>();
    this.level = updateLoyaltyLevel();
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
    this.purschaseHistory.add(vehicle);
    this.ownerVehicle++;
    this.level = updateLoyaltyLevel();
  }

  public boolean checkingBalance(BigDecimal amount) {
    return accountBalance.compareTo(amount) >= 0;
  }

  public BigDecimal getDiscount() {
    switch (this.level) {
      case GOLD:
        return DISCOUNT_FOR_GOLD;
      case PLATINUM:
        return DISCOUNT_FOR_PLATINUM;
      default:
        return BigDecimal.ZERO;
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

  public LoyaltyLevel getLoyaltyLevel() {
    return this.level;
  }
}
