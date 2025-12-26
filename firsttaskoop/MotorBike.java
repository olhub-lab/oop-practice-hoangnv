package firsttaskoop;

import java.math.BigDecimal;

public class MotorBike extends Vehicle {

  private static final BigDecimal MOTORBIKE_IMPORT_TAX = new BigDecimal("0.3");
  private static final int MOTORBIKE_CAPACITY = 150;
  private static final BigDecimal HIGH_MOTORBIKE_CAPACITY_TAX = new BigDecimal("0.2");
  private int capacity;
  private String typeOfMotorBike;
  private int power;

  public MotorBike(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      String origin, int capacity, int power, String typeOfMotorBike, int quantity) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, MOTORBIKE_IMPORT_TAX,quantity);
    this.capacity = capacity;
    this.typeOfMotorBike = typeOfMotorBike;
    this.power = power;
  }

  @Override
  public BigDecimal getExciseTax() {
    BigDecimal basePrice = originalPrice.add(super.getImportTax());
    if (capacity < MOTORBIKE_CAPACITY) {
      return BigDecimal.ZERO;
    } else {
      return basePrice.multiply(HIGH_MOTORBIKE_CAPACITY_TAX);
    }
  }

  @Override
  public void giveApplicableTax() {
    System.out.printf("Thuế nhập khẩu: %.2f || Thuế tiêu thụ đặc biệt: %.2f",
        super.getImportTax(), getExciseTax());
  }

  @Override
  public void giveBasicInformation() {
    super.giveBasicInformation();
    System.out.printf("Dung tích xi-lanh: %d", capacity);
    System.out.printf("Loại xe: %s\n", typeOfMotorBike);
    System.out.printf("Công suất: %d\n", power);
  }
}
