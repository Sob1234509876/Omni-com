package top.sob.proof;

import org.apiguardian.api.API;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface Consumes {
    @SuppressWarnings("unused") String[] links();
}
