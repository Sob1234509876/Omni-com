package top.sob.core.utils.models.transform;

import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Set;

public interface Transformer {
    URL[] transform(URL[] cp);

    Set<SpecificTransformer> getSpecTransformers();

    @NotNull
    static Transformer getDefault() {
        return new TransformerImpl();
    }
}
