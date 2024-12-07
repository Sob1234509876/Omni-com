package top.sob.vanilla.models.serialize;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.proof.From;
import top.sob.vanilla.annotations.proof.Template;
import top.sob.vanilla.utils.misc.Builder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

@From(links = "SerializerProvider")
@Template
public interface Serializer {

    @NotNull
    static Builder<? extends Serializer> getBuilderForName(@NotNull String name) {

        Objects.requireNonNull(name);

        return SerializerProviderImpl.getInstance().getBuilderByName(name);
    }

    byte @NotNull [] writeObject(@NotNull Object object);

    @NotNull Object readObject(byte @NotNull [] bytes);

    @SuppressWarnings("unused")
    default void writeObject(@NotNull Object object, @NotNull OutputStream os) throws IOException {

        Objects.requireNonNull(os);
        Objects.requireNonNull(object);

        os.write(writeObject(object));
        os.flush();

    }

    @SuppressWarnings("unused")
    @NotNull
    default Object readObject(InputStream is) throws IOException {
        return readObject(is.readAllBytes());
    }
}
