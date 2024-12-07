package top.sob.core.utils.io.swing;

import org.jetbrains.annotations.NotNull;
import top.sob.core.ui.GInput;
import top.sob.core.utils.io.CloseCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class SwingReader extends BufferedReader {

    private SwingRawReader inTmp;

    public SwingReader(GInput src) {
        super(new SwingRawReader(src));
    }

    public static class SwingRawReader extends Reader implements CloseCheck {

        private final GInput src;
        private boolean isClosed = false;
        private final StringBuilder BUFFER = new StringBuilder();

        public SwingRawReader(@NotNull GInput src) {

            Objects.requireNonNull(src);

            this.src = src;
        }

        @Override
        public int read(char @NotNull [] buff, int off, int len) throws IOException {

            if (isClosed)
                throw new IOException("Reader is closed.");

            do {
                BUFFER.append(src.waitAndGetSubmit()).append('\n');
            } while (BUFFER.length() < len);

            BUFFER.getChars(0, len, buff, off);

            return len;
        }

        @Override
        public void close() throws IOException {
            if (isClosed)
                throw new IOException("Reader is closed.");

            isClosed = true;
        }

        @Override
        public boolean isClosed() {
            return isClosed;
        }
    }

}
