package top.sob.proof;

import org.apiguardian.api.API;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@API(status = API.Status.STABLE, since = "1.2.8a")
public @interface Creates {
    String[] links();
}
