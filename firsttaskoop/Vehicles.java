package firsttaskoop;

import java.math.BigDecimal;

public abstract class Vehicles {

  private static final BigDecimal VAT_RATE = new BigDecimal("0.1");
  private static final String ORIGIN = "Trong nuoc";
  protected String nameModel;
  protected String manufacturer;
  protected int birthYear;
  protected BigDecimal originalPrice;
  protected String origin;
  protected BigDecimal importTax;

  public Vehicles(String nameModel, String manufacturer, int birthYear, BigDecimal originalPrice,
      String origin,
      BigDecimal importTax) {
    this.nameModel = nameModel;
    this.manufacturer = manufacturer;
    this.birthYear = birthYear;
    this.originalPrice = originalPrice;
    this.origin = origin;
    this.importTax = importTax;
  }

  public BigDecimal getImportTax() {
    if (origin.equalsIgnoreCase(ORIGIN)) {
      return BigDecimal.ZERO;
    } else {
      return originalPrice.multiply(importTax);
    }
  }

  public abstract BigDecimal getExciseTax();

  public BigDecimal calculatePrice() {
    BigDecimal importTax = getImportTax();
    BigDecimal exciseTax = getExciseTax();
    BigDecimal priceBeforeVAT = originalPrice.add(importTax).add(exciseTax);
    BigDecimal taxVAT = priceBeforeVAT.multiply(VAT_RATE);
    return priceBeforeVAT.add(taxVAT);
  }

  public void giveBasicInformation() {
    System.out.printf("Tên: %s\n", nameModel);
    System.out.printf("Hãng %s\n", manufacturer);
    System.out.printf("Năm sản xuất %d\n", birthYear);
    System.out.printf("Xuất xứ: %s\n", origin);
  }

  abstract void giveApplicableTax();
}