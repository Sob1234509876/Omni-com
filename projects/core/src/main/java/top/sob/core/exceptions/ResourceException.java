package top.sob.core.exceptions;

import org.apiguardian.api.API;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class ResourceException extends RuntimeException {

    public ResourceException() {
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}
