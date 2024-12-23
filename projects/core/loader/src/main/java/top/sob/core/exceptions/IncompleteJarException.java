package top.sob.core.exceptions;

import org.apiguardian.api.API;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class IncompleteJarException extends MissingResourceException {

    public IncompleteJarException(String resourceName) {
        super(Objects.requireNonNull(resourceName));
    }

    public IncompleteJarException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncompleteJarException(Throwable cause) {
        super(cause);
    }

    public IncompleteJarException(File file) {
        super(file);
    }

    @SuppressWarnings("unused")
    public IncompleteJarException(URL url) {
        super(Objects.requireNonNull(url));
    }

    public IncompleteJarException(URI uri) {
        super(uri);
    }

    public IncompleteJarException() {
    }
}
