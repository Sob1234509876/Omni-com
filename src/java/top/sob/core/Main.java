package top.sob.core;

import java.util.*;
import java.io.*;

import org.apache.log4j.*;

import joptsimple.*;

import top.sob.core.api.*;
import top.sob.core.api.event.*;

/**
 * The main class of the core, also the entry.
 */
public final class Main {

        static {
                // Some init process
                BasicConfigurator.configure();
        }

        public static final Logger LOGGER = Logger.getRootLogger();
        public static OptionSet optSet;
        static final OptionParser optParser = new OptionParser();

        public static void main(String[] args) throws Throwable {
                optParser.accepts("saveDir", "The directory of save") // Save dir
                                .withRequiredArg()
                                .ofType(File.class);
                optParser.accepts("plugDir", "The directory of plugins") // Plugins dir
                                .withRequiredArg()
                                .ofType(File.class);
                optParser.accepts("confDir", "The directory of configs") // Configuration dir
                                .withRequiredArg()
                                .ofType(File.class);
                optParser.accepts("repoDir", "The directory of reports") // Report dir
                                .withRequiredArg()
                                .ofType(File.class);
                ////////////////
                optParser.accepts("charset", "The standard charset of this")
                                .withOptionalArg()
                                .defaultsTo("utf-8")
                                .ofType(String.class);
                optParser.accepts("reportName", "The custom report name")
                                .withOptionalArg()
                                .defaultsTo(String.format("REPORT %d.log", System.currentTimeMillis()))
                                .ofType(String.class);
                ////////////////
                optParser.accepts("username", "The username")
                                .withOptionalArg()
                                .ofType(String.class);
                optParser.accepts("uuid", "The uuid")
                                .withRequiredArg()
                                .ofType(String.class);

                optSet = optParser.parse(args);

                init.run0(); // I //
                init.run1(); // N //
                init.run2(); // I //
                init.run3(); // T //

                LOGGER.debug("FINISH INIT");
                LOGGER.debug("DEBUG INFO: ");
                LOGGER.debug(Arrays.toString(args)); // Get args
                LOGGER.info("Game language: " + meta.LANGUAGE); // Get language

                plugin.fireEvent(new Event("GTInit"));
                plugin.fireEvent(new Event("GameLogicInit"));

        }
}
