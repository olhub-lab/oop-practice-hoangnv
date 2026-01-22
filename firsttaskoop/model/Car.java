package firsttaskoop.model;

import java.math.BigDecimal;
import firsttaskoop.enums.Origin;

public class Car extends Vehicle {

  private static final BigDecimal CAR_IMPORT_TAX = new BigDecimal("0.5");
  private static final int CAR_CAPACITY = 3000;
  private static final BigDecimal LOW_CAPACITY_TAX = new BigDecimal("0.5");
  private static final BigDecimal HIGH_CAPACITY_TAX = new BigDecimal("1");
  private int seatNumber;
  private String typeOfField;
  private int capacity;
  private String bodyType;

  public Car(String nameModel,
      String manufacturer,
      int birthYear,
      BigDecimal originalPrice,
      Origin origin,
      int seatNumber,
      String typeOfField,
      int capacity,
      String bodyType,
      int quantity) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, CAR_IMPORT_TAX, quantity);
    this.seatNumber = seatNumber;
    this.typeOfField = typeOfField;
    this.capacity = capacity;
    this.bodyType = bodyType;
  }
  @Override
  public BigDecimal getExciseTax() {
    BigDecimal basePrice = originalPrice.add(super.getImportTax());
    if (capacity < CAR_CAPACITY) {
      return basePrice.multiply(LOW_CAPACITY_TAX);
    } else {
      return basePrice.multiply(HIGH_CAPACITY_TAX);
    }
  }

}
