package top.sob.core.proof;

import org.apiguardian.api.API;

import java.lang.annotation.*;

@Documented
@NotSafe
@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface Unsupported {
}
