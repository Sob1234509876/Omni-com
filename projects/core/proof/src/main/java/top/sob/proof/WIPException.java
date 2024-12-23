package top.sob.proof;

public class WIPException extends RuntimeException {
    public WIPException(String message) {
        super(message);
    }

    public WIPException(String message, Throwable cause) {
        super(message, cause);
    }

    public WIPException(Throwable cause) {
        super(cause);
    }

    public WIPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WIPException() {
    }
}
