package top.sob.vanilla.proof;

public class WIPException extends RuntimeException {
  public WIPException() {
  }

  public WIPException(String message) {
    super(message);
  }

  public WIPException(String message, Throwable cause) {
    super(message, cause);
  }

  public WIPException(Throwable cause) {
    super(cause);
  }
}
