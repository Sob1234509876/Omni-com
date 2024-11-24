package top.sob.vanilla.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Provider {
    @SuppressWarnings("unused") String desc() default "";

    String[] defaultProviders();
}
