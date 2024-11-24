package top.sob.core.exceptions;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;

import java.io.File;
import java.net.URL;
import java.util.Objects;

@Immutable
@API(status = API.Status.STABLE, since = "1.2.8a")
public class MalformedResourceException extends ResourceException {


    @SuppressWarnings("unused")
    public MalformedResourceException() {
    }

    public MalformedResourceException(String resourceName) {
        super("Missing resource \"" + Objects.requireNonNull(resourceName) + "\".");
    }

    @SuppressWarnings("unused")
    public MalformedResourceException(File file) {
        this(Objects.requireNonNull(file).toString());
    }

    @SuppressWarnings("unused")
    public MalformedResourceException(URL url) {
        this(Objects.requireNonNull(url).toString());
    }

}
