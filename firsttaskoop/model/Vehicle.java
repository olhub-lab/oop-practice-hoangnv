package firsttaskoop.model;

import firsttaskoop.exception.NegativeValueException;
import java.math.BigDecimal;
import firsttaskoop.enums.Origin;

public abstract class Vehicle {

  private static final BigDecimal VAT_RATE = new BigDecimal("0.1");
  protected String nameModel;
  protected String manufacturer;
  protected int birthYear;
  protected BigDecimal originalPrice;
  protected Origin origin;
  protected BigDecimal importTax;
  protected int quantity;

  public Vehicle(String nameModel,
      String manufacturer,
      int birthYear,
      BigDecimal originalPrice,
      Origin origin,
      BigDecimal importTax,
      int quantity) {
    this.nameModel = nameModel;
    this.manufacturer = manufacturer;
    this.birthYear = birthYear;
    this.originalPrice = originalPrice;
    this.origin = origin;
    this.importTax = importTax;
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getNameModel() {
    return nameModel;
  }

  public BigDecimal getImportTax() {
    if (this.origin == Origin.DOMESTIC) {

      return BigDecimal.ZERO;
    }

    return originalPrice.multiply(importTax);
  }

  public abstract BigDecimal getExciseTax();

  public BigDecimal calculatePrice() {
    BigDecimal importTax = getImportTax();
    BigDecimal exciseTax = getExciseTax();
    BigDecimal priceBeforeVAT = originalPrice.add(importTax).add(exciseTax);
    BigDecimal taxVAT = priceBeforeVAT.multiply(VAT_RATE);

    return priceBeforeVAT.add(taxVAT);
  }

  public void updateQuantity(int n) {
    if (n < 1) {
      throw new NegativeValueException("Số lượng nhập kho không thể là số âm");
    }

    if (this.quantity < n) {
      throw new NegativeValueException("Kho hàng trong kho không đủ để thực hiện giao dịch");
    }

    this.quantity = this.quantity - n;
  }
}