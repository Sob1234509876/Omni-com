package top.sob.core.exceptions;

import org.apiguardian.api.API;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class MissingResourceException extends ResourceException {

    @SuppressWarnings("unused")
    public MissingResourceException() {
    }

    public MissingResourceException(String resourceName) {
        super("Missing resource \"" + Objects.requireNonNull(resourceName) + "\".");
    }

    public MissingResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingResourceException(Throwable cause) {
        super(cause);
    }

    @SuppressWarnings("unused")
    public MissingResourceException(File file) {
        this(Objects.requireNonNull(file).toString());
    }

    public MissingResourceException(URL url) {
        this(Objects.requireNonNull(url).toString());
    }

    public MissingResourceException(URI uri) {
        this(Objects.requireNonNull(uri).toString());
    }

}
