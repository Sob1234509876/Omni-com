package top.sob.core.annotations;

import org.apiguardian.api.API;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface Consumes {
    @SuppressWarnings("unused") String[] links();
}
