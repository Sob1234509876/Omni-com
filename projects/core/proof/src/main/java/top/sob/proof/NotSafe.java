package top.sob.proof;

import org.apiguardian.api.API;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface NotSafe {
    String desc() default "";

    String links() default "#";
}
