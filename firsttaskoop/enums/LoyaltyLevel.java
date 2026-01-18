package firsttaskoop.enums;

import java.math.BigDecimal;

public enum LoyaltyLevel {
  REGULAR(BigDecimal.ZERO),
  SILVER(new BigDecimal("0.02")),
  GOLD(new BigDecimal("0.05")),
  PLATINUM(new BigDecimal("0.10"));

  private final BigDecimal discountRate;

  LoyaltyLevel(BigDecimal rate) {
    this.discountRate = rate;
  }
  public BigDecimal getDiscountRate() {
    return discountRate;
  }

}
