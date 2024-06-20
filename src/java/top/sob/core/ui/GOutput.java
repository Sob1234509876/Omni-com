package top.sob.core.ui;

import javax.swing.*;

/**
 * A {@link JTextArea} that can`t be editted by the user and is always
 * line-wrapped.
 */
public class GOutput extends JTextArea {

    /**
     * Not allowed to be changed, always sets to <code>false</code>.
     * 
     * @param b useless
     */
    @Override
    public void setEditable(boolean b) {
        super.setEditable(false);
    }

    /**
     * Not allowed to be changed, always sets to <code>true</code>.
     * 
     * @param wrap useless
     */
    @Override
    public void setLineWrap(boolean wrap) {
        super.setLineWrap(true);
    }

    /** Constructs a GOutput text area with no text. */
    public GOutput() {
        this("");
    }

    /**
     * Constructs a GOutput text area with a default text.
     * 
     * @param def_text The default text.
     */
    public GOutput(String def_text) {
        super(def_text);
        setEditable(false);
        setLineWrap(true);
    }
}
