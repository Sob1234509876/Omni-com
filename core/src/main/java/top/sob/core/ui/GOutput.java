package top.sob.core.ui;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;
import top.sob.core.annotations.Unsupported;

import javax.swing.JTextArea;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class GOutput extends JTextArea {

    @Immutable
    @Unsupported
    @Override
    public final void setEditable(boolean b) {
    }

    @Immutable
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
