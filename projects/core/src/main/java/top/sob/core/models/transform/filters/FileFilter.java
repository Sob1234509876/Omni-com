package top.sob.core.models.transform.filters;

import java.io.File;
import java.net.URL;
import java.util.function.Predicate;

public class FileFilter implements Predicate<URL> {

    private FileFilter() {
    }

    private static final FileFilter INSTANCE = new FileFilter();

    public static FileFilter getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean test(URL url) {

        var tmp = new File(url.getPath());

        return tmp.isDirectory();
    }

}
