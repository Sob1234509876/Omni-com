package top.sob.core;

import java.util.Arrays;
import java.io.File;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

import joptsimple.OptionSet;
import joptsimple.OptionParser;
import top.sob.core.annotations.Immutable;
import top.sob.core.annotations.Static;
import top.sob.core.api.Events;
import top.sob.core.api.Meta;

@Static
@Immutable
public final class Main {

    private Main() {
    }

    public static final Logger LOGGER = Logger.getRootLogger();
    public static OptionSet optSet;
    static final OptionParser optParser = new OptionParser();

    static {
        // Some Initializations process
        LOGGER.addAppender(new ConsoleAppender(Utilities.DefConsoleLayout.getInstance()));
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
                .defaultsTo(String.format("REPORT %s.log", System.currentTimeMillis()))
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

        LOGGER.info("Parsed options.");

        Initializations.run0(); // I //
        Initializations.run1(); // N //
        Initializations.run2(); // I //
        Initializations.run3(); // T //

        LOGGER.debug("FINISH INIT");
        LOGGER.debug("DEBUG INFO: ");
        LOGGER.debug(Arrays.toString(args)); // Get args
        LOGGER.info("Game language: " + Meta.LANGUAGE); // Get language

        Buses.getRootBus().post(Events.GTInit);
        Buses.getRootBus().post(Events.GameLogicInit);

    }
}
