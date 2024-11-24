package top.sob.core.exceptions;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;

import java.net.URL;
import java.util.Objects;

@Immutable
@API(status = API.Status.STABLE, since = "1.2.8a")
public class IncompleteJarException extends MissingResourceException {

    public IncompleteJarException(String resourceName) {
        super(Objects.requireNonNull(resourceName));
    }

    @SuppressWarnings("unused")
    public IncompleteJarException(URL url) {
        super(Objects.requireNonNull(url));
    }
}
