package top.sob.vanilla.models.serialize.raw;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.proof.Creates;
import top.sob.vanilla.utils.misc.Builder;

@SuppressWarnings("unused")
@Creates(links = "RawSerializer")
public class RawSerializerBuilder extends Builder<RawSerializer> {

    @Override
    public @NotNull RawSerializer build() {
        return RawSerializer.getInstance();
    }

}
