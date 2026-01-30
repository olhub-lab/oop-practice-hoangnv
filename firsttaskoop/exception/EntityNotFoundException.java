package firsttaskoop.exception;

public class EntityNotFoundException extends BaseException {
  public EntityNotFoundException(String message) {
    super(message);
  }

  public static void check(Object entity, String entityName) {
    if (entity == null) {
      throw new EntityNotFoundException("Không tìm thấy " + entityName + " vui lòng thử lại sau!");
    }
  }
}
