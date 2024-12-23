package top.sob.core.utils.models.transform.file;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.ArrayUtils;
import top.sob.core.utils.models.transform.FilteredST;
import top.sob.core.utils.models.transform.filters.FileFilter;
import top.sob.core.utils.models.transform.filters.ProtocolFilter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class FileST implements FilteredST {

    public static final String FILTERED_PROTOCOL = "file";

    private final Set<Predicate<URL>> filters = new HashSet<>();

    {
        getFilters().add(ProtocolFilter.forProtocol(FILTERED_PROTOCOL));
        getFilters().add(FileFilter.getInstance());
    }

    @Override
    public @NotNull URL[] transform(@NotNull URL filtered) {

        var file = new File(filtered.getPath());

        if (!file.exists() || file.isFile())
            throw new IllegalArgumentException("Illegal file given.");

        var files = file.listFiles();

        return ArrayUtils.castArray(files, new URL[0], file0 -> {
            try {
                return file0.toURI().toURL();
            } catch (MalformedURLException e) {
                return null;
            }
        });
    }

    @Override
    public Set<Predicate<URL>> getFilters() {
        return filters;
    }
}
