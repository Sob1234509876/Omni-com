package top.sob.core;

import static top.sob.core.Main.LOGGER;
import static top.sob.core.api.meta.CONFIGS_URI;
import static top.sob.core.api.meta.DEF_CHARSET;

import java.io.*;
import java.net.*;
import java.nio.charset.*;

import com.moandjiezana.toml.*;

import top.sob.core.api.*;

/**
 * Some useful tools for something (Random tools).
 */
public final class util {

    private static Toml O_TOML_ARG; // The last used property
    private static File O_FILE_ARG; // The last file
    // Buffer for getConfig

    public static String getConfig(String... args) {
        try {
            return getConfig(new File(CONFIGS_URI.getPath(), "core.cfg"), args);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * 
     * Gets the configuration from a url connection and decodes with the
     * {@link meta#DEF_CHARSET}, returns a string. If the string is not found, it
     * will return null.
     * 
     * @param url  The url where the toml is.
     * @param args The arguments
     * @return The string.
     * @throws IOException When an I/O exception occurs.
     */
    public static String getConfig(URL url, String... args) throws IOException {
        return getConfig(url.openStream(), args);
    }

    /**
     * Gets the configuration from a file and decodes with the
     * {@link meta#DEF_CHARSET}, returns a string. If the string is not found, it
     * will return null.
     * 
     * @param file The abstract path where the toml file is.
     * @param args The arguments.
     * @return The string.
     * @throws FileNotFoundException When the file is not found or the abstract path
     *                               given is a directory or any thing else but not
     *                               a file.
     */
    public static String getConfig(File file, String... args) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Argument \"file\" is null");
        } else if (file.equals(O_FILE_ARG)) {
            return getConfig(O_TOML_ARG, args);
        } else {
            return getConfig(new FileInputStream(file), args);
        }
    }

    /**
     * Gets the configuration from a input stream and decodes with the
     * {@link meta#DEF_CHARSET}, returns a string. If the string is not found, it
     * will return null.
     * 
     * @param is   The input stream for the toml configuration.
     * @param args The arguments.
     * @return The string.
     */
    public static String getConfig(InputStream is, String... args) {
        return getConfig(is, DEF_CHARSET, args);
    }

    /**
     * Gets the configuration from a input stream and decodes with the charset
     * given, returns a string. If the string is not found, it will return null.
     * 
     * @param is      The input stream for the toml configuration.
     * @param charset The charset for the toml configuration.
     * @param args    The arguments.
     * @return The string.
     */
    public static String getConfig(InputStream is, Charset charset, String... args) {
        return getConfig(new InputStreamReader(is, charset), args);
    }

    /**
     * Gets the configuration from a reader, returns a string. If the string is
     * not found, it will return null.
     * 
     * @param reader The input stream reader for the toml configuration.
     * @param args   The arguments.
     * @return The string.
     */
    public static String getConfig(Reader reader, String... args) {
        Toml toml = new Toml().read(reader);
        return getConfig(toml, args);
    }

    /**
     * Gets the configuration from a toml file, returns a string. If the string is
     * not found, it will return null.
     * 
     * @param cfg  The toml configuration file.
     * @param args The arguments.
     * @return The string.
     */
    public static String getConfig(Toml cfg, String... args) {
        return getConfig(cfg, null, args);
    }

    /**
     * Gets the configuration from a toml file, returns a string. If the string is
     * not found, it will return the argument {@code def}.
     * 
     * @param cfg  The toml configuration file.
     * @param def  The default value if the targetted string is not found.
     * @param args The arguments.
     * @return The string.
     */
    public static String getConfig(Toml cfg, String def, String... args) {
        try {

            for (int i = 0; i < args.length - 1; i++) {
                cfg = cfg.getTable(args[i]);
            }

            return cfg.getString(args[args.length - 1], def);

        } catch (NullPointerException e) {
            LOGGER.warn("Something went wrong:", e); // Just for debug and info.

            return def;
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
