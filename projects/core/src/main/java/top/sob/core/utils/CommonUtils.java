package top.sob.core.utils;

import java.awt.*;
import java.io.*;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.apache.log4j.Category;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

import org.apache.log4j.spi.ThrowableInformation;
import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.jetbrains.annotations.Range;
import top.sob.core.proof.NotSafe;
import top.sob.core.proof.Singleton;
import top.sob.core.proof.Static;

/**
 * Some utilities that might or might not be useful and used commonly. Stupid getConfig method.
 */
@Static
@API(status = API.Status.STABLE, since = "1.2.8a")
public final class CommonUtils {

    private CommonUtils() {
    }

    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static boolean and(boolean... b) {
        var tmp = true;

        for (boolean b0 : b)
            tmp &= b0;

        return tmp;
    }

    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static boolean or(boolean... b) {
        var tmp = false;

        for (boolean b0 : b)
            tmp |= b0;

        return tmp;
    }

    public static <P, R> List<R> castArray(P[] array, Function<P, R> castFun) {
        return Stream.of(array).map(castFun).toList();
    }

    @NotNull
    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static String getFileName(@NotNull File f) {
        return f.getName().substring(f.getName().lastIndexOf(File.pathSeparator) + 1);
    }

    @Singleton(desc = """
            Singleton because of it is instance independent,
            meaning it has no differences between each other
            """, instance = """
            DefLayout#getInstance(),
            DefLayout#INSTANCE
            """)
    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static class DefLayout extends Layout {

        @NotNull
        @API(status = API.Status.STABLE, since = "1.2.8a")
        public static Layout getInstance() {
            return INSTANCE;
        }

        private static final Layout INSTANCE = new DefLayout();

        private DefLayout() {
        }

        @Override
        public String format(LoggingEvent loggingEvent) {

            return getLevelString(loggingEvent.getLevel()) +
                    getLoggerNames(loggingEvent.getFQNOfLoggerClass(), loggingEvent.getLogger()) +
                    getThreadString(loggingEvent.getThreadName()) +
                    getNDCString(loggingEvent.getNDC()) +
                    getLocationString(loggingEvent.getLocationInformation()) +
                    getPropertiesString(loggingEvent.getProperties()) +
                    getTimeString(loggingEvent.getTimeStamp()) +
                    '\n' +
                    getMessageString(loggingEvent.getMessage()) +
                    getThrowableMessage(loggingEvent.getThrowableInformation()) +
                    '\n' +
                    '\n';
        }

        @NotNull
        protected String getLevelString(@NotNull Level level) {

            Objects.requireNonNull(level);

            return String.format("[%s]", level);
        }

        @NotNull
        protected String getLoggerNames(@NotNull String loggerClass, @NotNull Category logger) {

            Objects.requireNonNull(logger);
            Objects.requireNonNull(loggerClass);

            return String.format("[%s:%s]", loggerClass, logger.getName());
        }

        @NotNull
        protected String getThreadString(@NotNull String threadName) {

            Objects.requireNonNull(threadName);

            return String.format("[%s]", threadName);
        }

        @NotNull
        protected String getNDCString(@Nullable String ndc) {
            return String.format("[%s]", ndc);
        }

        @NotNull
        protected String getLocationString(@NotNull LocationInfo info) {

            Objects.requireNonNull(info);

            return String.format("[at %s.%s (%s:%s)]", info.getClassName(), info.getMethodName(), info.getFileName(), info.getLineNumber());
        }

        @NotNull
        protected String getPropertiesString(@NotNull Map<?, ?> properties) {

            Objects.requireNonNull(properties);

            var sb = new StringBuilder();

            sb.append('[');
            properties.entrySet().forEach((entry -> sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("; ")));
            sb.append(']');

            return sb.toString();
        }

        @NotNull
        protected String getTimeString(long timeStamp) {
            return String.format("[%s]", new Date(timeStamp));
        }

        @NotNull
        protected String getMessageString(@NotNull Object message) {

            Objects.requireNonNull(message);

            return "    " + message;
        }

        @NotNull
        protected String getThrowableMessage(@Nullable ThrowableInformation info) {
            if (info == null || info.getThrowable() == null)
                return "";

            var writer = new StringWriter();
            var printer = new PrintWriter(writer);

            info.getThrowable().printStackTrace(printer);

            return writer.toString();
        }

        @Override
        public boolean ignoresThrowable() {
            return false;
        }

        @Override
        public void activateOptions() {
        }
    }

    @Singleton(desc = "See CommonUtils.DefLayout", instance = "#INSTANCE; #getInstance()")
    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static class DefConsoleLayout extends DefLayout {

        public static final Color DEF_TEXT_BACKGROUND_COLOR = new Color(0xffffff);
        public static final Color DEF_BACKGROUND_COLOR = new Color(0x000000);
        public static final Color DEF_TEXT_COLOR = new Color(0xff0000);

        private static final Layout INSTANCE = new DefConsoleLayout();

        @NotNull
        @API(status = API.Status.STABLE, since = "1.2.8a")
        public static Layout getInstance() {
            return INSTANCE;
        }

        @NotNull
        @Override
        protected String getLevelString(@NotNull Level level) {

            var alpha = s(level.toInt() / 10000.0);
            var nAlpha = 1 - alpha;

            var foreground = new Color(
                    (int) (DEF_TEXT_BACKGROUND_COLOR.getRed() * nAlpha + DEF_TEXT_COLOR.getRed() * alpha),
                    (int) (DEF_TEXT_BACKGROUND_COLOR.getGreen() * nAlpha + DEF_TEXT_COLOR.getGreen() * alpha),
                    (int) (DEF_TEXT_BACKGROUND_COLOR.getBlue() * nAlpha + DEF_TEXT_COLOR.getBlue() * alpha)
            );

            return setConsoleColorString(foreground, DEF_BACKGROUND_COLOR) + super.getLevelString(level) + getSGIClearString();
        }

        @Range(from = 0, to = 1)
        private double s(double x) {
            return 1 / (1 + Math.exp(-x));
        }

    }

    @NotSafe(desc = "Does not checks for illegal parameters.")
    public static String getANSIString(char mType, char method, String... par) {
        var sb = new StringBuilder();

        sb.append('\033')
                .append(mType);

        for (var tmp : par)
            sb.append(tmp).append(';');

        sb.append(method);

        return sb.toString();
    }

    @SuppressWarnings("unused")
    public static String getClearString() {
        return getANSIString('c', '?');
    }

    @NotSafe(links = "CommonUtils#getANSIString(char, char, String)")
    public static String getCSIString(char method, String... par) {
        return getANSIString('[', method, par);
    }

    @NotSafe(links = "CommonUtils#getANSIString(char, char, String)")
    public static String getSGIString(String... par) {
        return getCSIString('m', par);
    }

    public static String getSGIClearString() {
        return getSGIString("0");
    }

    @NotSafe(links = "CommonUtils#getANSIString(char, char, String)")
    public static String setConsoleColorString(Color foreColor, Color backColor) {
        return getSGIString("38",
                "2",
                foreColor.getRed() + "",
                foreColor.getGreen() + "",
                foreColor.getBlue() + "") + getSGIString(
                "48",
                "2",
                backColor.getRed() + "",
                backColor.getGreen() + "",
                backColor.getBlue() + ""
        );
    }

}
