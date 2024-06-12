package com.sob.core;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import com.sob.core.api.*;

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
     * 
     * @param s
     * @return
     */
    public static String GetFancyName(String... s) {
        String tmp = new String();
        tmp += s[0];
        for (int i = 1; i < s.length; i++) {
            tmp += "." + s[i];
        }
        // xxx.yyy.zzz....

        return tmp;

    }

    /**
     * 
     * @param f
     * @param cs
     * @param s
     * @return
     * @throws IOException
     * @see {@link #GetFancyName(String...)}
     * @see {@link #GetConfig(String, String...)}
     * @see {@link #GetConfig(String...)}
     */
    public static String GetConfig(File f, Charset cs, String... s) {

        try {

            if (f.equals(O_FILE_ARG) && s.equals(O_STR_ARG)) {
                return O_RESULT;
            } else if (f.equals(O_FILE_ARG)) {
                return PROP_BUF.getProperty(GetFancyName(s));
            } else {
                Properties tmp = new Properties();
                tmp.load(new FileReader(f, cs));
                return tmp.getProperty(GetFancyName(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 
     * @param f
     * @param s
     * @return
     * @throws IOException
     * @see {@link #GetFancyName(String...)}
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
     * @see {@link #GetFancyName(String...)}
     * @see {@link #GetConfig(String, Charset, String...)}
     * @see {@link #GetConfig(String, String...)}
     */
    public static String GetConfig(String... s) {
        return GetConfig(new File(meta.CONFIGS_URI.getPath(), "core.cfg"), s);
    }

}
