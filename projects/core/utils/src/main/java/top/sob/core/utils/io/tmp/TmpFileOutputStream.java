package top.sob.core.utils.io.tmp;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TmpFileOutputStream extends FileOutputStream {

    public TmpFileOutputStream(@NotNull String name) throws FileNotFoundException {
        this(new TmpFile(name));
    }

    public TmpFileOutputStream(@NotNull String name, boolean append) throws FileNotFoundException {
        this(new TmpFile(name), append);
    }

    public TmpFileOutputStream(@NotNull TmpFile file) throws FileNotFoundException {
        super(file);
    }

    public TmpFileOutputStream(@NotNull TmpFile file, boolean append) throws FileNotFoundException {
        super(file, append);
    }

}
