package game.api;

import java.lang.annotation.*;

// TODO: Redo docs of this, including InvokeRegister and same package classes and others (?).

/**
 * An annotation for stating does your plugin load anything into the game.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Register {
}
