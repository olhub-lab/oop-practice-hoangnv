package firsttaskoop.model;

import java.math.BigDecimal;
import firsttaskoop.enums.Origin;

public class Bike extends Vehicle {

  private static final BigDecimal BIKE_IMPORT_TAX = new BigDecimal("0.1");
  private String bikeType;
  private String frameMaterial;

  public Bike(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      Origin origin,
      String bikeType, String frameMaterial, int quantity) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, BIKE_IMPORT_TAX, quantity);
    this.bikeType = bikeType;
    this.frameMaterial = frameMaterial;
  }
  @Override
  public BigDecimal getExciseTax() {

    return BigDecimal.ZERO;
  }

}