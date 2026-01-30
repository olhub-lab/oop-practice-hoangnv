package firsttaskoop.exception;

import java.math.BigDecimal;

public class NegativeValueException extends BaseException {
  public NegativeValueException(String message) {
    super(message);
  }

  public static void check(BigDecimal value, String input) {
    if (value != null && value.compareTo(BigDecimal.ZERO) < 0) {
      throw new NegativeValueException(input + " không được là số âm!!!");
    }
  }

  public static void check(int value, String input) {
    if (value < 0) {
      throw new NegativeValueException(input + " không được là số âm!!!");
    }
  }
}
