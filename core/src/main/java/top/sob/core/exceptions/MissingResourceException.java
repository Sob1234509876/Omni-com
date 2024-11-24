package top.sob.core.exceptions;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

@Immutable
@API(status = API.Status.STABLE, since = "1.2.8a")
public class MissingResourceException extends ResourceException {

    @SuppressWarnings("unused")
    public MissingResourceException() {
    }

    public MissingResourceException(String resourceName) {
        super("Missing resource \"" + Objects.requireNonNull(resourceName) + "\".");
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
