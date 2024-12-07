package top.sob.core.utils.io.swing;

import org.jetbrains.annotations.NotNull;
import top.sob.core.ui.GOutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class SwingWriter extends BufferedWriter {

    public SwingWriter(GOutput snk) {
        super(new SwingRawWriter(snk));
    }

    public static class SwingRawWriter extends Writer {

        private final GOutput SNK;
        private final StringBuilder BUFFER = new StringBuilder();
        private boolean isClosed = false;

        public SwingRawWriter(GOutput output) {
            SNK = output;
        }

        @Override
        public void write(char @NotNull [] buff, int off, int len) throws IOException {
            if (isClosed)
                throw new IOException("Writer is closed.");

            SNK.setText(BUFFER.toString());
        }

        @Override
        public void flush() throws IOException {
            if (isClosed)
                throw new IOException("Writer is closed.");

            BUFFER.delete(0, BUFFER.length());
        }

        @Override
        public void close() throws IOException {
            if (isClosed)
                throw new IOException("Writer is closed.");

            isClosed = true;
        }
    }

}
