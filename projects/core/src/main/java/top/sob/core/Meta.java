package top.sob.core;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.apache.log4j.Logger;
import org.apiguardian.api.API;
import top.sob.core.proof.Static;
import top.sob.core.exceptions.ResourceException;

@SuppressWarnings("ResultOfMethodCallIgnored")
@Static
@API(status = API.Status.STABLE, since = "1.2.8a")
public final class Meta {

    private static final Logger LOGGER = Logger.getLogger(Meta.class);

    private Meta() {
    }

    private static final Charset DEF_CHARSET;
    private static final ClassLoader THIS_CLASS_LOADER = Main.class.getClassLoader();

    private static final URI CONFIGS_URI;
    private static final URI[] PLUGINS_URI;
    private static final URI REPORTS_URI;
    private static final URI REPORT_URI;
    private static final URI SAVES_URI;
    // Some basic URIs

    private static final ResourceBundle CONFIGS_RB;

    private static final Locale LANGUAGE;

    public static Charset getDefCharset() {
        return DEF_CHARSET;
    }

    public static ClassLoader getThisClassLoader() {
        return THIS_CLASS_LOADER;
    }

    public static URI getConfigsUri() {
        return CONFIGS_URI;
    }

    public static URI getReportsUri() {
        return REPORTS_URI;
    }

    public static URI getSavesUri() {
        return SAVES_URI;
    }

    public static URI[] getPluginsUri() {
        return PLUGINS_URI;
    }

    public static URI getReportUri() {
        return REPORT_URI;
    }

    public static Locale getLanguage() {
        return LANGUAGE;
    }

    public static ResourceBundle getConfigsRb() {
        return CONFIGS_RB;
    }

    static {

        DEF_CHARSET = Charset.forName((Main.optSet.valueOf("charset").toString()));
        CONFIGS_URI = Paths.get(Main.optSet.valueOf("confDir").toString()).toUri();

        @SuppressWarnings("unchecked") var t = (List<File>) Main.optSet.valuesOf("plugDir");
        var tmp = t.stream();

        var lst = new ArrayList<URI>();

        for (File file : tmp.toList()) {
            lst.add(file.toURI());
        }

        PLUGINS_URI = lst.toArray(new URI[0]);

        REPORTS_URI = Paths.get(Main.optSet.valueOf("repoDir").toString()).toUri();

        SAVES_URI = Paths.get(Main.optSet.valueOf("saveDir").toString()).toUri();

        REPORT_URI = Paths.get(Paths.get(REPORTS_URI).toString(), Main.optSet.valueOf("reportName").toString()).toUri();

        try {

            var cfgPaths = Paths.get(CONFIGS_URI);
            cfgPaths.toFile().mkdirs();

            var cfgPath = Paths.get(cfgPaths.toString(), "core.cfg");

            LOGGER.debug(cfgPath);

            if (cfgPath.toFile().createNewFile()) {

                try (var is = getThisClassLoader().getResourceAsStream("assets/backup/core.cfg"); var os = Files.newOutputStream(cfgPath)) {
                    os.write(Objects.requireNonNull(is).readAllBytes());
                }

            }

            CONFIGS_RB = new PropertyResourceBundle(new InputStreamReader(Files.newInputStream(cfgPath), getDefCharset()));

        } catch (MalformedURLException e) {
            throw new RuntimeException("How?", e);
        } catch (IOException e) {
            throw new ResourceException("An I/O exception occurred during creating configuration resource bundle :", e);
        }

        LANGUAGE = Locale.forLanguageTag(getConfigsRb().getString("lang"));

    }
}
