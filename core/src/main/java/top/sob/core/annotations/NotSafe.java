package top.sob.core.annotations;

import org.apiguardian.api.API;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface NotSafe {
    String desc() default "";

    String[] links() default "#";
}
