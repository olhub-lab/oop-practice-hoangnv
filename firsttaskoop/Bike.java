package firsttaskoop;

import java.math.BigDecimal;

public class Bike extends Vehicles {

  private static final BigDecimal BIKE_IMPORT_TAX = new BigDecimal("0.1");
  private String bikeType;
  private String frameMaterial;

  public Bike(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      String origin,
      String bikeType, String frameMaterial) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, BIKE_IMPORT_TAX);
    this.bikeType = bikeType;
    this.frameMaterial = frameMaterial;
  }

  @Override
  public BigDecimal getExciseTax() {
    return BigDecimal.ZERO;
  }

  @Override
  public void giveApplicableTax() {
    System.out.printf("Thuế nhập khẩu: %.2f || Thuế tiêu thụ đặc biệt: %.2f",
        super.getImportTax(), getExciseTax());
  }

  @Override
  public void giveBasicInformation() {
    super.giveBasicInformation();
    System.out.printf("Loại xe: %s\n", bikeType);
    System.out.printf("Chất liệu khung: %s\n", frameMaterial);
  }
}
