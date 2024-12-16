package top.sob.core;

import java.nio.file.Paths;
import java.util.Arrays;
import java.io.File;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

import joptsimple.OptionSet;
import joptsimple.OptionParser;
import top.sob.core.proof.Static;
import top.sob.core.api.Plugins;
import top.sob.core.utils.CommonUtils;
import top.sob.core.utils.io.tmp.TmpFile;

@Static
public final class Main {

    private Main() {
    }

    public static final Logger LOGGER = Logger.getRootLogger();
    public static OptionSet optSet;
    static final OptionParser optParser = new OptionParser();

    static {
        // Some Initializations process
        LOGGER.addAppender(new ConsoleAppender(CommonUtils.DefConsoleLayout.getInstance()));
    }

    public static void main(String[] args) throws Throwable {

        optParser.acceptsAll(Arrays.asList("plug", "plugin", "plugDir"), "The directories of plugins").withRequiredArg().withValuesSeparatedBy(';').ofType(File.class);
        optParser.acceptsAll(Arrays.asList("save", "saveDir"), "The directory of save").withOptionalArg().defaultsTo(new TmpFile("saves").getAbsolutePath()).ofType(File.class);
        optParser.acceptsAll(Arrays.asList("conf", "configuration", "confDir"), "The directory of configs").withOptionalArg().defaultsTo(new TmpFile("configs").getAbsolutePath()).ofType(File.class);
        optParser.acceptsAll(Arrays.asList("repo", "report", "repoDir"), "The directory of reports").withOptionalArg().defaultsTo(new TmpFile("reports").getAbsolutePath()).ofType(File.class);
        optParser.acceptsAll(Arrays.asList("charset", "encoding"), "The standard charset/encoding of this").withOptionalArg().defaultsTo("utf-8").ofType(String.class);
        optParser.accepts("reportName", "The custom report name").withOptionalArg().defaultsTo(String.format("REPORT %s.log", System.currentTimeMillis())).ofType(String.class);
        optParser.acceptsAll(Arrays.asList("username", "name"), "The username").withOptionalArg().defaultsTo("Jacob").ofType(String.class);
        optParser.acceptsAll(Arrays.asList("h", "help")).forHelp();

        optSet = optParser.parse(args);

        LOGGER.info("Parsed options.");

        Initializations.run0(); // I //
        Initializations.run1(); // N //
        Initializations.run2(); // I //
        Initializations.run3(); // T //

        LOGGER.debug("FINISH INIT");
        LOGGER.debug("DEBUG INFO: ");
        LOGGER.debug(Arrays.toString(args)); // Get args
        LOGGER.info("Game language: " + Meta.getLanguage()); // Get language

        LOGGER.debug("Loaded plugins: " + Arrays.toString(Plugins.getRegistered().toArray()));

        Plugins.init();
        Plugins.run();

    }
}
