package top.sob.core.utils.io.tmp;

import org.jetbrains.annotations.NotNull;
import oshi.SystemInfo;

import java.io.File;

public class TmpFile extends File {

    public static final File TMP_DIR;

    static {

        var dir = (File) null;

        switch (SystemInfo.getCurrentPlatform()) {
            case WINDOWS, WINDOWSCE -> dir = new File(System.getProperty("user.home"), "AppData/Roaming/.OmniCom");
            default -> dir = new File("/tmp/.OmniCom");
        }

        TMP_DIR = dir;

        //noinspection ResultOfMethodCallIgnored
        TMP_DIR.mkdirs();
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
