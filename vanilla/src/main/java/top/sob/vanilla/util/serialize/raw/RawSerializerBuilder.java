package top.sob.vanilla.util.serialize.raw;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Creates;
import top.sob.vanilla.annotations.clazz.Builder;

@SuppressWarnings("unused")
@Creates(links = "RawSerializer")
public class RawSerializerBuilder extends Builder<RawSerializer> {

    @Override
    public @NotNull RawSerializer build() {
        return RawSerializer.getInstance();
    }

}
