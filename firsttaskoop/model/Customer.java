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

  private int id;
  private String name;
  private String phoneNumber;
  private String address;
  private BigDecimal accountBalance;
  private LoyaltyLevel level;
  private int ownerVehicle;

  public Customer(int id,
      String name,
      String phoneNumber,
      String address,
      BigDecimal accountBalance,
      LoyaltyLevel level,
      int ownerVehicle) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = accountBalance;
    this.level = level;
    this.ownerVehicle = 0;
  }

  public Customer(String name,
      String phoneNumber,
      String address,
      BigDecimal accountBalance) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.accountBalance = accountBalance;
    this.level = LoyaltyLevel.REGULAR;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public BigDecimal getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(BigDecimal accountBalance) {
    this.accountBalance = accountBalance;
  }

  public LoyaltyLevel getLevel() {
    return level;
  }

  public void setLevel(LoyaltyLevel level) {
    this.level = level;
  }

  public int getOwnerVehicle() {
    return ownerVehicle;
  }

  public void setOwnerVehicle(int ownerVehicle) {
    this.ownerVehicle = ownerVehicle;
  }

  public boolean checkingBalance(BigDecimal amount) {

    return accountBalance.compareTo(amount) >= 0;
  }

  public BigDecimal getDiscount() {

    return level.getDiscountRate();
  }

  public void updateLoyaltyLevel() {
    if (ownerVehicle <= MAX_VEHICLE_SILVER && ownerVehicle >= MIN_VEHICLE_SILVER) {
      this.level = LoyaltyLevel.SILVER;
    } else if (ownerVehicle <= MAX_VEHICLE_GOLD && ownerVehicle >= MIN_VEHICLE_GOLD) {
      this.level = LoyaltyLevel.GOLD;
    } else if (ownerVehicle >= MIN_VEHICLE_PLATINUM) {
      this.level = LoyaltyLevel.PLATINUM;
    }
  }
}
