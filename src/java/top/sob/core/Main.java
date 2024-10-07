package top.sob.core;

import java.util.Arrays;
import java.io.File;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

import joptsimple.OptionSet;
import joptsimple.OptionParser;
import top.sob.core.api.meta;
import top.sob.core.api.event.Event;
import top.sob.core.api.event.Events;

/**
 * The main class of the core, also the entry.
 */
public final class Main {


        public static final Logger LOGGER = Logger.getRootLogger();
        public static OptionSet optSet;
        static final OptionParser optParser = new OptionParser();

        static {
                // Some init process
                LOGGER.addAppender(new ConsoleAppender(new util.DefLayout()));
        }

        public static void main(String[] args) throws Throwable {
                optParser.acceptsAll(Arrays.asList("save", "saveDir"), "The directory of save")
                                .withRequiredArg()
                                .required()
                                .ofType(File.class);
                optParser.acceptsAll(Arrays.asList("plug", "plugin", "plugDir"), "The directories of plugins")
                                .withRequiredArg()
                                .withValuesSeparatedBy(';')
                                .ofType(File.class);
                optParser.acceptsAll(Arrays.asList("conf", "configuration", "confDir"), "The directory of configs")
                                .withRequiredArg()
                                .required()
                                .ofType(File.class);
                optParser.acceptsAll(Arrays.asList("repo", "report", "repoDir"), "The directory of reports")
                                .withRequiredArg()
                                .required()
                                .ofType(File.class);
                ////////////////
                optParser.acceptsAll(Arrays.asList("charset", "encoding"), "The standard charset/encoding of this")
                                .withOptionalArg()
                                .defaultsTo("utf-8")
                                .ofType(String.class);
                optParser.accepts("reportName", "The custom report name")
                                .withOptionalArg()
                                .defaultsTo(String.format("REPORT %d.log", System.currentTimeMillis()))
                                .ofType(String.class);
                ////////////////
                optParser.acceptsAll(Arrays.asList("username", "name"), "The username")
                                .withOptionalArg()
                                .ofType(String.class);
                optParser.accepts("uuid", "The uuid")
                                .withRequiredArg()
                                .ofType(String.class);
                optParser.acceptsAll(Arrays.asList("h", "help"))
                                .forHelp();

                optSet = optParser.parse(args);

                init.run0(); // I //
                init.run1(); // N //
                init.run2(); // I //
                init.run3(); // T //

                LOGGER.debug("FINISH INIT");
                LOGGER.debug("DEBUG INFO: ");
                LOGGER.debug(Arrays.toString(args)); // Get args
                LOGGER.info("Game language: " + meta.LANGUAGE); // Get language

                Events.fireEvent(new Event("GTInit"));
                Events.fireEvent(new Event("GameLogicInit"));

        }
}
