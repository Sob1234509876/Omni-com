package top.sob.core.utils.io.tmp;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TmpFileInputStream extends FileInputStream {
    public TmpFileInputStream(@NotNull String name) throws FileNotFoundException {
        super(new TmpFile(name));
    }

    public TmpFileInputStream(@NotNull File file) throws FileNotFoundException {
        super(new TmpFile(file));
    }
}
