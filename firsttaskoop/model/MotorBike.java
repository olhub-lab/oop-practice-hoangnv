package firsttaskoop.model;

import java.math.BigDecimal;
import firsttaskoop.enums.Origin;

public class MotorBike extends Vehicle {

  private static final BigDecimal MOTORBIKE_IMPORT_TAX = new BigDecimal("0.3");
  private static final int MOTORBIKE_CAPACITY = 150;
  private static final BigDecimal HIGH_MOTORBIKE_CAPACITY_TAX = new BigDecimal("0.2");
  private int capacity;
  private String typeOfMotorBike;
  private int power;

  public MotorBike(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      Origin origin, int capacity, int power, String typeOfMotorBike, int quantity) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, MOTORBIKE_IMPORT_TAX,
        quantity);
    this.capacity = capacity;
    this.typeOfMotorBike = typeOfMotorBike;
    this.power = power;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getTypeOfMotorBike() {
    return typeOfMotorBike;
  }

  public void setTypeOfMotorBike(String typeOfMotorBike) {
    this.typeOfMotorBike = typeOfMotorBike;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  @Override
  public BigDecimal getExciseTax() {
    BigDecimal basePrice = originalPrice.add(super.getImportTax());
    if (capacity < MOTORBIKE_CAPACITY) {

      return BigDecimal.ZERO;
    }

    return basePrice.multiply(HIGH_MOTORBIKE_CAPACITY_TAX);
  }
}
