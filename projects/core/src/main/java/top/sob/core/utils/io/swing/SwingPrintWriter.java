package top.sob.core.utils.io.swing;

import org.jetbrains.annotations.NotNull;
import top.sob.core.ui.GOutput;

import java.io.PrintWriter;

public class SwingPrintWriter extends PrintWriter {

    public SwingPrintWriter(@NotNull GOutput out) {
        super(new SwingWriter(out));
    }

}
