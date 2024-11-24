package top.sob.core.api;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apiguardian.api.API;
import top.sob.core.annotations.Static;
import top.sob.core.exceptions.ResourceException;
import top.sob.core.Utilities;
import top.sob.core.Main;

@Static
@API(status = API.Status.STABLE, since = "1.2.8a")
public final class Meta {

    private Meta() {
    }

    public static final Charset DEF_CHARSET;
    public static final ClassLoader THIS_CLASS_LOADER = Main.class.getClassLoader();

    public static final URI CONFIGS_URI;
    public static final URI CONFIG_URI;
    public static final URI[] PLUGINS_URI;
    public static final URI REPORTS_URI;
    public static final URI REPORT_URI;
    public static final URI SAVES_URI;
    public static final URI LANG_URI;
    // Some basic URIs

    public static final String LANGUAGE;

    static {

        DEF_CHARSET = Charset.forName(((String) (Main.optSet.valueOf("charset"))));
        CONFIGS_URI = ((File) (Main.optSet.valueOf("confDir"))).toURI();

        try {

            CONFIG_URI = new URL(CONFIGS_URI.toURL(), "core.cfg").toURI();

            CONFIG_URI.toURL().openConnection(); // Check is it able to connect

        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new ResourceException(e.toString());
        }

        @SuppressWarnings("unchecked")
        List<File> t = (List<File>) Main.optSet.valuesOf("plugDir");
        var tmp = t.stream();

        var lst = new ArrayList<URI>();
        for (File file : tmp.toList()) {
            lst.add(file.toURI());
        }
        PLUGINS_URI = lst.toArray(new URI[0]);

        REPORTS_URI = ((File) (Main.optSet.valueOf("repoDir"))).toURI();
        SAVES_URI = ((File) (Main.optSet.valueOf("saveDir"))).toURI();
        REPORT_URI = new File(REPORTS_URI.getPath(), ((String) (Main.optSet.valueOf("reportName"))))
                .toURI();

        var tmpLang = Utilities.getConfig("base", "lang");

        LANGUAGE = (tmpLang == null ? "en_us" : tmpLang);

        try {
            LANG_URI = Objects.requireNonNull(THIS_CLASS_LOADER.getResource("assets/lang/" + LANGUAGE + ".lang")).toURI();
        } catch (Throwable e) {
            throw new ResourceException(e.toString());
        }

    }
}
