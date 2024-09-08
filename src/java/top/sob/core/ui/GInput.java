package top.sob.core.ui;

import javax.swing.JTextField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class GInput extends JTextField {

    private int Submit_Key = '\n';
    private String Enabled_Text;
    private String Disabled_Text;
    private boolean Has_Text = false;
    private volatile String Submit_Text;

    private static final String NO_STR = new String(); // LOL

    /**
     * A key listener, listens for the user`s keys and changes the submit text when
     * the user typed the submit key (the enter key at default).
     */
    private class SubmitListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {

            if (event.getKeyCode() == Submit_Key) {

                checkHasText(); // Checks is there text.

                if (GInput.this.Has_Text) {
                    GInput.this.Submit_Text = getText();
                } else if (!GInput.this.Has_Text) {
                    GInput.this.Submit_Text = NO_STR;
                }
                setText(NO_STR);

            }

        }

    }

    /**
     * A focus listener, when the mouse leaves the <code>GInput</code>, it first
     * checks does this <code>GInput</code> has a string. If it has then nothing
     * happens, else it changes it`s text into the enabled text.
     */
    private class LeaveListener extends FocusAdapter {

        @Override
        public void focusLost(FocusEvent event) {
            checkHasText(); // Checks does this has a string
            if (!Has_Text) {
                setText(Enabled_Text);
            }
        }

        @Override
        public void focusGained(FocusEvent event) {
            if (!Has_Text) {
                setText(NO_STR);
            }
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        super.setText((enabled) ? (Enabled_Text) : (Disabled_Text));
    }

    /**
     * Constructs a <code>GInput</code>. The enabled text and the disabled text are
     * set to an empty string and "~~~" respectively.
     */
    public GInput() {
        this("");
    }

    /**
     * Constructs a <code>GInput</code> with the enabled text modified. The disabled
     * text is set to "~".
     * 
     * @param enable_text the enable text
     */
    public GInput(String enable_text) {
        this(enable_text, "~~~");
    }

    /**
     * Constructs a <code>GInput</code> with the enabled text and disabled text
     * modified.
     * 
     * @param enable_text  the enabled text
     * @param disable_text the disabled text
     */
    public GInput(String enable_text, String disable_text) {
        Enabled_Text = enable_text;
        Disabled_Text = disable_text;
        setText(enable_text);
        addKeyListener(new SubmitListener());
        addFocusListener(new LeaveListener());
    }

    /**
     * Gets the submitted text from the user. If the user hadn`t submitted anything
     * or the submit text had been resetted, it returns a null pointer.
     * 
     * @return the submitted text
     */
    public String getSubmitText() {
        return Submit_Text;
    }

    /**
     * Resets the submitted text. It simply sets the submit text into a null
     * pointer.
     */
    public void resetSubmitText() {
        Submit_Text = null;
    }

    /**
     * Waits until the user submits a string. It`s check-rate is 1000hz (or every
     * milisecond it checks for once)
     * 
     * @return the submitted string.
     * @see #waitAndGetSubmit(int)
     */
    public synchronized String waitAndGetSubmit() {
        return waitAndGetSubmit(1); // If set to 0, the resource needed will be too high
    }

    /**
     * Waits until the user submits a string. It checks for the change of the submit
     * text every <code>milis</code> miliseconds.
     * 
     * @param milis the check-rate
     * @return the submitted string.
     * @throws InterruptedException when this thread been interrupted.
     */
    public String waitAndGetSubmit(int milis) {
        resetSubmitText(); // Dummy prevention
        while (Submit_Text == null) {
            try {
                Thread.sleep(milis);
            } catch (Exception e) {
            }
        }

        String tmp = Submit_Text;
        Submit_Text = null;
        return tmp;
    }

    /**
     * Sets the new submit key.
     * 
     * @param o the new submission key
     */
    public void setSubmitKey(int o) {
        int old = Submit_Key;
        Submit_Key = o;
        firePropertyChange("submitKey", Submit_Key, old);
    }

    /**
     * Sets the new enable text.
     * 
     * @param o the new enable text
     */
    public void setEnableText(String o) {
        String old = Enabled_Text;
        Enabled_Text = o;
        firePropertyChange("enableText", Enabled_Text, old);
    }

    /**
     * Sets the new disable text.
     * 
     * @param o the new disable text
     */
    public void setDisableText(String o) {
        String old = Disabled_Text;
        Disabled_Text = o;
        firePropertyChange("disableText", Disabled_Text, old);
    }

    /**
     * Checks is there any text in this, equivalent to
     * {@code Has_Text = !getText().equals(NO_STR);} .
     */
    private void checkHasText() {
        Has_Text = !getText().equals(NO_STR);
    }

}
