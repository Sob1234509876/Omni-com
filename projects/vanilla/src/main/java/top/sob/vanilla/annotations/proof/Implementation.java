package top.sob.vanilla.annotations.proof;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Implementation {
    @SuppressWarnings("unused") String desc() default "";

    String[] impl();
}
