package top.sob.core;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import top.sob.core.api.*;
import static top.sob.core.Main.LOGGER;
import static top.sob.core.api.meta.DEF_CHARSET;

/**
 * Some useful tools for
 */
public final class util {

    private static String[] O_STR_ARG; // The last s argument
    private static Properties O_PROP_ARG; // The last used property
    private static String O_RESULT; // The result of the last usage
    // Buffer for GetConfig

    /**
     * Returns the property of the {@link Properties} object that might exist in the
     * reader`s stream (The parameter {@code r}) with the given string array
     * {@code s} (which will first be processed with the method
     * {@link #getFancyStr(String...)}).
     * 
     * @param r The reader and it`s source is the {@link Properties} object.
     * @param s The string array that will be the key for the {@link Properties}
     *          object.
     * @return The value from the {@link Properties} object.
     * 
     * @see #getProperty(File, Charset, String...)
     * @see #getProperty(InputStream, Charset, String...)
     */
    public static String getProperty(Reader r, String... s) {

        try {

            Properties tmp = new Properties();
            tmp.load(r);
            return getProperty(tmp, s);

        } catch (IOException e) {
            LOGGER.error(
                    String.format("With parameters : ReaderCLass=%s, Strings=%s",
                            r.getClass(), // Since it is not possible to tell what reader is this
                            Arrays.toString(s)),
                    e);
            // Error, not fatal because this is not so important
            return null;
        }

    }

    /**
     * Gets the {@link Properties} object from the input stream {@code is} and uses
     * the charset {@code cs}. Then gets the value from the {@link Properties}
     * object using the key {@code s} (it will be processed using the method
     * {@link #getFancyStr(String...)}).
     * <p>
     * This method is equivalent to
     * 
     * <pre>{@code
     * 
     * util.getProperty(new InputStreamReader(is, cs), s);
     * }</pre>
     * 
     * @param is The {@link Properties} object`s input stream.
     * @param cs The charset.
     * @param s  The key.
     * @return The value.
     */
    public static String getProperty(InputStream is, Charset cs, String... s) {
        return getProperty(new InputStreamReader(is, cs), s);
    }

    /**
     * Gets the property of the targeted file using the charset {@code cs} and the
     * string array {@code s} as the key (Note that the key will be first processed
     * through the method {@link #getFancyStr(String...)} then been searched).
     * <p>
     * This method is equivalent to
     * 
     * <pre>{@code
     * util.getProperty(new FileReader(f, cs), s);
     * }</pre>
     * 
     * @param f  The {@link Properties} ` file path.
     * @param cs The charset.
     * @param s  The key.
     * @return The value.
     */
    public static String getProperty(File f, Charset cs, String... s) {

        try {
            return getProperty(new FileInputStream(f), cs, s);
        } catch (FileNotFoundException e) {
            LOGGER.error(String.format("With parameters: File=%s, Charset=%s, Strings=%s ",
                    getFileName(f),
                    cs,
                    Arrays.toString(s)),
                    e);
            return null;
        }

    }

    /**
     * Gets property from the input stream {@code is} and get value using the key
     * 
     * <pre>{@code
     * util.getFancyStr(s);
     * }</pre>
     * 
     * where s is the string array parameter {@code s}. The charset used for this is
     * from {@link meta#DEF_CHARSET}. This is equivalent to
     * 
     * <pre>{@code
     * util.getProperty(is, meta.DEF_CHARSET, s);
     * }</pre>
     * 
     * @param is The {@link Properties} object`s input stream.
     * @param s  The key.
     * @return The value.
     */
    public static String getProperty(InputStream is, String... s) {
        return getProperty(is, DEF_CHARSET, s);
    }

    /**
     * Gets property from the file {@code f} and get value using the key
     * 
     * <pre>{@code
     * util.getFancyStr(s);
     * }</pre>
     * 
     * where s is the string array parameter {@code s}. The charset used for this is
     * from {@link meta#DEF_CHARSET}. This is equivalent to
     * 
     * <pre>{@code
     * util.getProperty(f, meta.DEF_CHARSET, s);
     * }</pre>
     * 
     * @param f The property file.
     * @param s The key.
     * @return The value.
     */
    public static String getProperty(File f, String... s) {
        return getProperty(f, DEF_CHARSET, s);
    }

    /**
     * Gets the file {@code core.cfg} `s property with the key {@code s} (Will be
     * processed using the method {@link #getFancyStr(String...)}). Equivalent to
     * 
     * <pre>{@code
     * util.getProperty(new File(meta.CONFIGS_URI.getPath(), "core.cfg"), s);
     * }</pre>
     * 
     * @param s The key.
     * @return The value.
     */
    public static String getProperty(String... s) {
        return getProperty(new File(meta.CONFIGS_URI.getPath(), "core.cfg"), s);
    }

    /**
     * Gets the value of the key {@code s} processed with the method
     * {@link #getFancyStr(String...)} in the arg {@code p}.
     * 
     * @param p The {@link Properties} object.
     * @param s The keys.
     * @return The value.
     */
    public static String getProperty(Properties p, String... s) {
        if (p.equals(O_PROP_ARG) && Arrays.equals(s, O_STR_ARG)) {
            return O_RESULT; // Buffered args and result
        } else {
            return p.getProperty(getFancyStr(s));
        }
    }

    /**
     * Gets the file name of the directory.
     * 
     * @param f The directory.
     * @return The file name.
     */
    public static String getFileName(File f) {
        return f.getName().substring(f.getName().lastIndexOf(File.pathSeparator) + 1);
    }

    /**
     * Gets a fancy string of an array of strings. The fancy string is a string that
     * has all of the string from the parameter {@code s} connected using the
     * character {@code .} . E.x. :
     * 
     * <pre>
     * >>> getFancyStr("org", "apache", "log4j");
     * org.apache.log4j
     * >>> getFancyStr("ui", "d", "height");
     * ui.d.height
     * </pre>
     * 
     * @param s The array of strings
     * @return The fancy string
     */
    public static String getFancyStr(String... s) {
        String tmp = new String();
        tmp += s[0];
        for (int i = 1; i < s.length; i++) {
            tmp += "." + s[i];
        }
        // xxx.yyy.zzz....

        return tmp;

    }

}
