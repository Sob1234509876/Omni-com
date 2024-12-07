package top.sob.core.ui;

import org.apiguardian.api.API;
import top.sob.core.annotations.proof.Unsupported;

import javax.swing.JTextArea;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class GOutput extends JTextArea {

    @Unsupported
    @Override
    public final void setEditable(boolean b) {
    }

    @Unsupported
    @Override
    public final void setLineWrap(boolean wrap) {
    }

    public GOutput() {
        this("");
    }

    public GOutput(String defText) {
        super(defText);

        super.setEditable(false);
        super.setLineWrap(true);
    }
}
