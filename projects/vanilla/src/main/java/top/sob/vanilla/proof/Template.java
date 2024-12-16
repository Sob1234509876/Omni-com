package top.sob.vanilla.proof;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Template {
    @SuppressWarnings("unused") String desc() default "";
}
