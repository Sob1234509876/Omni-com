package top.sob.core.models.transform;

import java.net.URL;

public interface SpecificTransformer {

    URL[] transformURL(URL url);

    boolean canTransform(URL url);

}
