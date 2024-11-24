package top.sob.core.exceptions;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;

@Immutable
@API(status = API.Status.STABLE, since = "1.2.8a")
public class ResourceException extends RuntimeException {

    public ResourceException() {
    }

    public ResourceException(String m) {
        super(m);
    }

}
