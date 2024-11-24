package top.sob.vanilla.exceptions;

public class MissingResourceException extends IncompleteJarException {
    public MissingResourceException(String resName) {
        super(String.format("Missing resource \"%s\"", resName));
    }
}
