package top.sob.vanilla.util.serialize.raw;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.core.annotations.Singleton;
import top.sob.vanilla.annotations.Instance;
import top.sob.vanilla.util.serialize.Serializer;

import java.io.*;

@Singleton(desc = "Uses java serializable", instance = "RawSerializer#INSTANCE; RawSerializer#getInstance()")
@Instance
public class RawSerializer extends Serializer {

    private static final RawSerializer INSTANCE = new RawSerializer();
    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();
    private static final ObjectOutputStream OBJECT_STREAM;

    static {
        try {
            OBJECT_STREAM = new ObjectOutputStream(OUTPUT_STREAM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private RawSerializer() {
    }

    @NotNull
    public static RawSerializer getInstance() {
        return INSTANCE;
    }

    @Override
    public byte @NotNull [] writeObject(@Nullable Object object) {
        try {
            OBJECT_STREAM.writeObject(object);
        } catch (IOException e) {
            OUTPUT_STREAM.reset();
            return new byte[0];
        }

        var bytes = OUTPUT_STREAM.toByteArray();
        OUTPUT_STREAM.reset();

        return bytes;
    }

    @Override
    public @Nullable Object readObject(byte @NotNull [] bytes) {
        try {
            var stream = new ObjectInputStream(new ByteArrayInputStream(bytes));
            return stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
