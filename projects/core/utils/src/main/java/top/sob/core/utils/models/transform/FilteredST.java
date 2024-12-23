package top.sob.core.utils.models.transform;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Filterable;

import java.net.URL;

public interface FilteredST extends Filterable<URL>, SpecificTransformer {

    @NotNull URL[] transform(@NotNull URL filtered);

    @NotNull
    default URL[] transformURL(URL url) {

        if (!canTransform(url))
            throw new IllegalArgumentException("The url did not pass filter.");

        return transform(url);
    }

    default boolean canTransform(URL url) {
        return test(url);
    }
}
