package com.sob.core.ui;

import javax.swing.*;

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

    public GOutput() {
        this("");
    }

    public GOutput(String def_text) {
        super(def_text);
        setEditable(false);
        setLineWrap(true);
    }
}
