package top.sob.core.ui;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class IConsole extends JComponent {

    private class ConsoleImpl implements Console {


        private static final Logger log = Logger.getLogger(ConsoleImpl.class);

        private final PrintWriter out;
        private final PrintWriter err;
        private final Scanner in;

        {
            out = new PrintWriter(new Writer() {

                private boolean isClosed = false;

                @Override
                public void write(char @NotNull [] buff, int off, int len) throws IOException {
                    if (isClosed)
                        throw new IOException("Writer closed.");

                    var t = new String(buff, off, len);

                    IConsole.this.textArea.setText(t);
                }

                @Override
                public void flush() throws IOException {
                    if (isClosed)
                        throw new IOException("Writer closed.");

                    IConsole.this.textArea.setText(null);
                }

                @Override
                public void close() throws IOException {
                    if (isClosed)
                        throw new IOException("Writer closed.");

                    isClosed = true;
                }
            });

            err = out;

            in = new Scanner(new Reader() {

                private final StringBuilder buffer = new StringBuilder();

                private boolean isClosed = false;

                @Override
                public int read(char @NotNull [] buff, int off, int len) throws IOException {

                    if (isClosed)
                        throw new IOException("Reader closed.");

                    if (buff.length < off + len)
                        throw new ArrayIndexOutOfBoundsException("Buffer array size is too small.");

                    while (buffer.length() < len) {
                        buffer.append(IConsole.this.getInputString()).append('\n');
                    }

                    buffer.getChars(0, len, buff, off);

                    return len;
                }

                @Override
                public void close() throws IOException {
                    if (isClosed)
                        throw new IOException("Reader closed.");

                    isClosed = true;
                }
            });
        }

        @Override
        public PrintWriter getOut() {
            return out;
        }

        @Override
        public PrintWriter getErr() {
            return err;
        }

        @Override
        public Scanner getIn() {
            return in;
        }

        @Override
        public boolean supportANSI() {
            return false;
        }
    }

    private final JPanel panel = new JPanel();

    private final JScrollPane scrollPane = new JScrollPane();
    private final JTextArea textArea = new JTextArea();

    private final JTextField textField = new JTextField();
    private final JLabel label = new JLabel(">>>");

    private final Console console = new ConsoleImpl();

    private String inputText;

    {

        textArea.setLineWrap(true);

        scrollPane.add(textArea);

        panel.setLayout(new BorderLayout());
        panel.add(label);
        panel.add(textField);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

    }

    public IConsole() {
        textField.addFocusListener(new FocusAdapter() {

            private boolean isEmpty = textField.getText().isEmpty();

            @Override
            public void focusGained(FocusEvent e) {
                if (isEmpty)
                    textField.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

                isEmpty = textField.getText().isEmpty();

                if (isEmpty)
                    textField.setText("~~~");
            }
        });
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public synchronized void keyTyped(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    inputText = textField.getText();
                    textField.setText(null);
                    IConsole.this.notifyAll();
                }

            }
        });
    }

    public Console getConsole() {
        return console;
    }

    public String getInputString() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException("IE :", e);
        }

        return inputText;

    }

}
