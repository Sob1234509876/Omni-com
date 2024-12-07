package top.sob.core.models.transform;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.proof.From;
import top.sob.core.annotations.proof.Modifiable;
import top.sob.core.utils.ArrayUtils;
import top.sob.core.models.transform.file.FileST;

import java.net.URL;
import java.util.*;

@From(links = "Transformer#getProvided()")
public class TransformerImpl implements Transformer {

    private static final Logger LOGGER = Logger.getLogger(TransformerImpl.class);

    private final Set<SpecificTransformer> sts = new HashSet<>();

    {
        getSpecTransformers().add(new FileST());
    }

    @NotNull
    public URL[] transform(@NotNull URL[] cp) {

        Objects.requireNonNull(cp);

        var tmp = new LinkedList<URL[]>();
        var flag = true;

        for (URL cpo : cp) {

            try {

                Objects.requireNonNull(cpo);

                for (SpecificTransformer st : sts) {
                    if (!flag || !st.canTransform(cpo)) continue;

                    flag = false;
                    tmp.add(st.transformURL(cpo));

                }

                if (flag)
                    tmp.add(new URL[]{cpo});

                flag = true;

            } catch (RuntimeException re) {
                LOGGER.error("Runtime exception in TransformerImpl#transform(URL[]) :", re);
            }
        }

        return ArrayUtils.concat(tmp.toArray(new URL[0][])).toArray(new URL[0]);

    }

    @Modifiable
    public Set<SpecificTransformer> getSpecTransformers() {
        return sts;
    }
}
