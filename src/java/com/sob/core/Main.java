package com.sob.core;

import java.util.*;
import java.io.*;

import org.apache.log4j.*;

/**
 * The main class of the core, also the entry.
 */
public class Main {

    static {
        // Some init process
        BasicConfigurator.configure();
    }

    public static final Logger LOGGER = Logger.getRootLogger();

    public static void main(String[] args) throws Throwable {

        init.run0(); // I //
        init.run1(); // N //
        init.run2(); // I //
        init.run3(); // T //

        LOGGER.debug("FINISH INIT");
        LOGGER.debug("DEBUG INFO: ");
        LOGGER.debug(Arrays.toString(args)); // Get args
        LOGGER.debug(new File("").getAbsolutePath()); // Get this path

    }
}
