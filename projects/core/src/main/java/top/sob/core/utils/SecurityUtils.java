package top.sob.core.utils;

import top.sob.core.api.Script;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class SecurityUtils {

    private static final MessageDigest DEFAULT;

    static {
        var tmp = (MessageDigest) null;

        try {
            tmp = MessageDigest.getInstance("SHA256");
        } catch (NoSuchAlgorithmException ignored) {
        }

        if (tmp == null)
            try {
                tmp = MessageDigest.getInstance("SHA");
            } catch (NoSuchAlgorithmException ignored) {
            }

        if (tmp == null)
            try {
                tmp = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Why don`t you have SHA-256, SHA-1 & MD-5?", e);
            }

        DEFAULT = tmp;
    }

    private SecurityUtils() {
    }

    public static void requireSafeInvoker(Predicate<StackTraceElement> predicate, Supplier<String> message) {
        var stk = Thread.currentThread().getStackTrace();

        if (Stream.of(stk).filter(predicate).toList().size() < stk.length)
            throw new SecurityException(message.get());
    }

    public static void requireSafeInvoker(Predicate<StackTraceElement> predicate, String message) {
        requireSafeInvoker(predicate, () -> message);
    }

    public static void requireSafeInvoker(Predicate<StackTraceElement> predicate) {
        requireSafeInvoker(predicate, "Unsafe invoker");
    }

    public static void requireNonScriptInvoker() {
        requireSafeInvoker(element -> {

            try {
                var clazz = Class.forName(element.getClassName());
                return clazz.getAnnotation(Script.class) == null;
            } catch (ClassNotFoundException e) {
                return true;
            }

        });
    }

    public static MessageDigest getDefaultMessageDigest() {
        return DEFAULT;
    }
}
