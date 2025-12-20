package firsttaskoop;

import java.math.BigDecimal;

public class Car extends Vehicles {

  private static final BigDecimal CAR_IMPORT_TAX = new BigDecimal("0.5");
  private int seatNumber;
  private String typeOfField;
  private int capacity;
  private String bodyType;

  public Car(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      String origin,
      int seatNumber, String typeOfField, int capacity, String bodyType) {
    super(nameModel, manufacturer, birthYear, originalPrice, origin, CAR_IMPORT_TAX);
    this.seatNumber = seatNumber;
    this.typeOfField = typeOfField;
    this.capacity = capacity;
    this.bodyType = bodyType;
  }

  @Override
  public BigDecimal getExciseTax() {
    BigDecimal basePrice = originalPrice.add(super.getImportTax());
    if (capacity < 3000) {
      return basePrice.multiply(BigDecimal.valueOf(0.5));
    } else {
      return basePrice.multiply(BigDecimal.valueOf(1));
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
    System.out.printf("Số chỗ ngồi: %d\n", seatNumber);
    System.out.printf("Loại nhiên liệu: %s\n", typeOfField);
    System.out.printf("Dung tích động cơ: %d\n", capacity);
    System.out.printf("Loại thân xe: %s\n", bodyType);
  }
}
