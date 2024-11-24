package top.sob.vanilla.util.serialize;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.core.annotations.From;
import top.sob.vanilla.annotations.Template;
import top.sob.vanilla.annotations.clazz.Builder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

@From(links = "SerializerProvider")
@Template
public abstract class Serializer {

    private static SerializerProvider provider = SerializerProviderImpl.getInstance();

    @NotNull
    public static Builder<? extends Serializer> getBuilderForName(@NotNull String name) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(provider);

        return provider.getBuilderByName(name);
    }

    @SuppressWarnings("unused")
    public static void setProvider(@NotNull SerializerProvider provider) {

        Objects.requireNonNull(provider);

        Serializer.provider = provider;
    }

    @SuppressWarnings("unused")
    @NotNull
    public static SerializerProvider getProvider() {

        Objects.requireNonNull(provider);

        return provider;
    }

    public abstract byte @NotNull [] writeObject(@Nullable Object object);

    @SuppressWarnings("unused")
    public void writeObject(@Nullable Object object, @NotNull OutputStream os) throws IOException {

        Objects.requireNonNull(os);
        os.write(writeObject(object));
        os.flush();

    }

    @Nullable
    public abstract Object readObject(byte @NotNull [] bytes);

    @SuppressWarnings("unused")
    @Nullable
    public Object readObject(InputStream is) throws IOException {
        return readObject(is.readAllBytes());
    }
}
