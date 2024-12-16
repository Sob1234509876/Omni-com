package top.sob.vanilla.proof;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Provider {
    @SuppressWarnings("unused") String desc() default "";

    String[] defaultProviders();
}
