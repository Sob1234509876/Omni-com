package top.sob.core.ui;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;

import javax.swing.JTextField;

import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class GInput extends JTextField {

    private int submitKey = '\n';
    private String enabledText;
    private String disabledText;
    private boolean Has_Text = false;
    private volatile String submitText;

    private static final String NO_STR = ""; // LOL

    @Immutable
    private final class SubmitListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {

            if (event.getKeyCode() == submitKey) {

                checkHasText(); // Checks is there text.

                if (GInput.this.Has_Text) {
                    GInput.this.submitText = getText();
                } else {
                    GInput.this.submitText = NO_STR;
                }

                setText(NO_STR);

                notifyAll();

            }

        }

    }

    @Immutable
    private final class LeaveListener extends FocusAdapter {

        @Override
        public void focusLost(FocusEvent event) {
            checkHasText(); // Checks does this has a string
            if (!Has_Text) {
                setText(enabledText);
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
        super.setText((enabled) ? (enabledText) : (disabledText));
    }

    public GInput() {
        this("");
    }

    public GInput(String enableText) {
        this(enableText, "~~~");
    }

    public GInput(String enableText, String disableText) {
        enabledText = enableText;
        disabledText = disableText;
        setText(enableText);
        addKeyListener(new SubmitListener());
        addFocusListener(new LeaveListener());
    }

    @SuppressWarnings("unused")
    public String getSubmitText() {
        return submitText;
    }

    public synchronized void resetSubmitText() {
        submitText = null;
    }

    public synchronized String waitAndGetSubmit() {
        resetSubmitText(); // Dummy prevention

        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String tmp = submitText;
        resetSubmitText();
        return tmp;
    }

    @SuppressWarnings("unused")
    public void setSubmitKey(int o) {
        int old = submitKey;
        submitKey = o;
        firePropertyChange("submitKey", submitKey, old);
    }

    @SuppressWarnings("unused")
    public void setEnableText(String o) {
        String old = enabledText;
        enabledText = o;
        firePropertyChange("enableText", enabledText, old);
    }

    @SuppressWarnings("unused")
    public void setDisableText(String o) {
        String old = disabledText;
        disabledText = o;
        firePropertyChange("disableText", disabledText, old);
    }

    private void checkHasText() {
        Has_Text = !getText().equals(NO_STR);
    }

}
