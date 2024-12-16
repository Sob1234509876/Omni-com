package top.sob.core.proof;

import org.apiguardian.api.API;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface Modifiable {
}
