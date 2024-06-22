package top.sob.core;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import top.sob.core.api.*;

/**
 * Some useful tools for
 */
public final class util {

    private static File O_FILE_ARG; // The last f argument
    private static String[] O_STR_ARG; // The last s argument
    private static String O_RESULT; // The result of the last usage
    private static Properties PROP_BUF; // The last used property
    // Buffer for GetConfig

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

    /**
     * Gets the configuration named the string parameter {@code s} (Uses the
     * {@link #getFancyStr(String...)} method to process into one string) from the
     * config file (The parameter {@code f}) using the charset (The parameter
     * {@code cs}) to read.
     * <p>
     * This method has caches, which works like this :
     * 1. Check is the file parameter and the requested string parameter the same as
     * the last parameters, if true then return the last result.
     * 2. Check is the file parameter the same as the last file parameter, if true
     * then get the config from the last loaded config file.
     * 3. Loads the config file and gets the
     * 
     * @param f  The config file
     * @param cs The charset for opening the config file
     * @param s  The requested property name
     * @return The property
     * @throws IOException When the config file can`t be accessed or other problems.
     * @see {@link #getFancyStr(String...)} The method for turning a string array
     *      into a string
     * @see {@link #GetConfig(File, String...)} A method that you only need to set
     *      the config file.
     * @see {@link #GetConfig(String...)} A method that uses the core config file as
     *      the config file that will be loaded.
     */
    public static String GetConfig(File f, Charset cs, String... s) {

        try {

            if (f.equals(O_FILE_ARG) && s.equals(O_STR_ARG)) {
                return O_RESULT;
            } else if (f.equals(O_FILE_ARG)) {
                return PROP_BUF.getProperty(getFancyStr(s));
            } else {
                Properties tmp = new Properties();
                tmp.load(new FileReader(f, cs));
                return tmp.getProperty(getFancyStr(s));
            }

        } catch (IOException e) {
            Main.LOGGER.error(
                    String.format("With parameters : File=%s, Charset=%s, Strings=%s",
                            f,
                            cs,
                            Arrays.toString(s)),
                    e); // Output error, not fatal since devs could let the plugin try accessing
                        // multiple configs that all works
            return null;
        }

    }

    /**
     * 
     * @param f
     * @param s
     * @return
     * @throws IOException
     * @see {@link #getFancyStr(String...)}
     * @see {@link #GetConfig(String, Charset, String...)}
     * @see {@link #GetConfig(String...)}
     */
    public static String GetConfig(File f, String... s) {
        return GetConfig(f, meta.DEF_CHARSET, s);
    }

    /**
     * 
     * @param s
     * @return
     * @throws IOException
     * @see {@link #getFancyStr(String...)}
     * @see {@link #GetConfig(String, Charset, String...)}
     * @see {@link #GetConfig(String, String...)}
     */
    public static String GetConfig(String... s) {
        return GetConfig(new File(meta.CONFIGS_URI.getPath(), "core.cfg"), s);
    }

}
