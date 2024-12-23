package top.sob.core.utils.io.tmp;

import org.jetbrains.annotations.NotNull;
import oshi.SystemInfo;

import java.io.File;
import java.nio.file.Path;

public class TmpFile extends File {

    private static final File TMP_DIR;
    private static final Path TMP_PATH;

    static {

        var dir = (File) null;

        switch (SystemInfo.getCurrentPlatform()) {
            case WINDOWS, WINDOWSCE -> dir = new File(System.getProperty("user.home"), "AppData/Roaming/.OmniCom");
            default -> dir = new File("/tmp/.OmniCom");
        }

        TMP_DIR = dir;

        TMP_DIR.mkdirs();

        TMP_PATH = TMP_DIR.toPath();
    }

    public static File getTmpDir() {
        return TMP_DIR;
    }

    public static Path getTmpPath() {
        return TMP_PATH;
    }

    public TmpFile(@NotNull String pathname) {
        super(TMP_DIR, pathname);
    }

    public TmpFile(String parent, @NotNull String child) {
        super(new File(TMP_DIR, parent), child);
    }

    public TmpFile(File parent, @NotNull String child) {
        super(new File(TMP_DIR, parent.getPath()), child);
    }

    public TmpFile(File file) {
        this(file.getPath());
    }
}
