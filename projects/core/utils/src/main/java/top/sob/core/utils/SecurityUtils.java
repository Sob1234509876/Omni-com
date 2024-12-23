package top.sob.core.utils;

import top.sob.core.api.Plugin;
import top.sob.core.api.Script;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class SecurityUtils {

    private static final MessageDigest DEFAULT;

    private static final Predicate<StackTraceElement> IS_SCRIPT = (element -> {

        try {
            var clazz = Class.forName(element.getClassName());
            return clazz.getAnnotation(Script.class) == null;
        } catch (ClassNotFoundException e) {
            return true;
        }

    });

    private static final Predicate<StackTraceElement> IS_PLUGIN = (element -> {

        try {
            var clazz = Class.forName(element.getClassName());
            return clazz.getAnnotation(Plugin.class) == null;
        } catch (ClassNotFoundException e) {
            return true;
        }

    });

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
        if (isSpecInvoker(predicate))
            throw new SecurityException(message.get());
    }

    public static void requireSafeInvoker(Predicate<StackTraceElement> predicate, String message) {
        requireSafeInvoker(predicate, () -> message);
    }

    public static void requireSafeInvoker(Predicate<StackTraceElement> predicate) {
        requireSafeInvoker(predicate, "Unsafe invoker");
    }

    public static void requireNonScriptInvoker() {
        requireSafeInvoker(IS_PLUGIN);
    }

    public static boolean isSpecInvoker(Predicate<StackTraceElement> predicate) {
        var stk = Thread.currentThread().getStackTrace();

        for (var e : stk) {
            if (predicate.test(e))
                return true;
        }

        return false;
    }

    public static boolean isPluginInvoker() {
        return isSpecInvoker(IS_PLUGIN);
    }

    public static boolean isScriptInvoker() {
        return isSpecInvoker(IS_SCRIPT);
    }

    public static MessageDigest getDefaultMessageDigest() {
        return DEFAULT;
    }
}
