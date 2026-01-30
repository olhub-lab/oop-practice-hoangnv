package firsttaskoop.exception;

public class InvalidInputException extends BaseException {
  public InvalidInputException(String message) {
    super(message);
  }

  public static void checkEmpty(String input, String fieldName) {
    if (input == null || input.trim().isEmpty()) {
      throw new InvalidInputException("Lỗi: " + fieldName + " không được để trống!!!");
    }
  }

}
