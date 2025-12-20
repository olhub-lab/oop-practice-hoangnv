package firsttaskoop;

import java.math.BigDecimal;

public class MotorBike extends Vehicles {

  private static final BigDecimal MOTORBIKE_IMPORT_TAX = new BigDecimal("0.3");
  private int capacity;
  private String typeOfMotorBike;
  private int power;

  public MotorBike(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      String origin, int capacity, int power, String typeOfMotorBike) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, MOTORBIKE_IMPORT_TAX);
    this.capacity = capacity;
    this.typeOfMotorBike = typeOfMotorBike;
    this.power = power;
  }

  @Override
  public BigDecimal getExciseTax() {
    BigDecimal basePrice = originalPrice.add(super.getImportTax());
    if (capacity < 150) {
      return BigDecimal.ZERO;
    } else {
      return basePrice.multiply(BigDecimal.valueOf(0.2));
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
