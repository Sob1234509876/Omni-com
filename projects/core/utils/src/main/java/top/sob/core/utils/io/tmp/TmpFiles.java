package top.sob.core.utils.io.tmp;

import top.sob.core.utils.SecurityUtils;

import java.io.IOException;
import java.nio.file.Path;

public final class TmpFiles {

    private static final Path TMP_RES_PATH = Path.of(TmpFile.getTmpPath().toString(), "resources");
    private static final Path TMP_PLUGINS_RES_PATH = Path.of(TmpFile.getTmpPath().toString(), "plugins");
    private static final Path TMP_SCRIPTS_RES_PATH = Path.of(TmpFile.getTmpPath().toString(), "scripts");
    private static final Path TMP_URL_RES_PATH = Path.of(TmpFile.getTmpPath().toString(), "protocols");

    static {
        TMP_RES_PATH.toFile().mkdirs();
        TMP_SCRIPTS_RES_PATH.toFile().mkdirs();
        TMP_PLUGINS_RES_PATH.toFile().mkdirs();
        TMP_URL_RES_PATH.toFile().mkdirs();
    }

    private TmpFiles() {
    }

    public static void copyResources(ClassLoader icl, String... paths) throws IOException {

        var p = getTmpResPath();

        if (SecurityUtils.isScriptInvoker())
            p = getTmpScriptsResPath();

        if (SecurityUtils.isPluginInvoker())
            p = getTmpPluginsResPath();

        for (String path : paths) {

            try (var is = icl.getResourceAsStream(path)) {
            }

        }

    }

    public static Path getTmpPluginsResPath() {
        return TMP_PLUGINS_RES_PATH;
    }

    public static Path getTmpResPath() {
        return TMP_RES_PATH;
    }

    public static Path getTmpScriptsResPath() {
        return TMP_SCRIPTS_RES_PATH;
    }

    public static Path getTmpUrlResPath() {
        return TMP_URL_RES_PATH;
    }
}
