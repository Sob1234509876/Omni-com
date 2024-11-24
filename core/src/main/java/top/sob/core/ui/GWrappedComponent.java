package top.sob.core.ui;

import org.apiguardian.api.API;
import top.sob.core.annotations.Immutable;
import top.sob.core.annotations.Unsupported;

import java.awt.Component;
import java.awt.BorderLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

@API(status = API.Status.STABLE, since = "1.2.8a")
public abstract class GWrappedComponent extends JPanel {

    public final static int DEF_PAGE_AMOUNT = 0;
    public final static String DEF_PAGE_FORMAT = "%d / %d";

    @SuppressWarnings("unused")
    public final static int DEF_BOTTOM_HEIGHT = 50;
    @SuppressWarnings("unused")
    public final static int DEF_BUTTON_WIDTH = 50;
    public final static int DEF_WIDTH = 300;
    public final static int DEF_HEIGHT = 350;

    private final JPanel buttonPanel = new JPanel();
    private final JPanel contentPanel = new JPanel();

    private final JTextField pageText = new JTextField();
    private final JButton rightPageButton = new JButton(">");
    private final JButton leftPageButton = new JButton("<");

    private final String pageFormat;
    private final int pageAmount;
    private int currentPage;

    public GWrappedComponent() {
        this(DEF_PAGE_AMOUNT);
    }

    public GWrappedComponent(int pageAmount) {
        this(pageAmount, pageAmount);
    }

    public GWrappedComponent(int pageAmount, int defPage) {
        this(pageAmount, defPage, DEF_PAGE_FORMAT);
    }

    @SuppressWarnings("unused")
    public GWrappedComponent(int pageAmount, String pageFormat) {
        this(pageAmount, pageAmount, pageFormat);
    }

    public GWrappedComponent(int pageAmount, int defPage, String pageFormat) {
        this.pageAmount = pageAmount;
        this.currentPage = defPage;
        this.pageFormat = pageFormat;

        // Some layout stuff
        this.setLayout(new BorderLayout());
        buttonPanel.setLayout(new BorderLayout());

        this.setSize(DEF_WIDTH, DEF_HEIGHT);

        checkArgs();
        init();

    }

    // Make sure argument are all legal.
    private void checkArgs() {
        if (pageAmount < 0) {
            throw new IllegalArgumentException("Illegal argument \"pageAmount \" : " + pageAmount);
        } else if (currentPage < 0) {
            throw new IllegalArgumentException("Illegal argument \"currentPage\" : " + currentPage);
        }

        Objects.requireNonNull(pageFormat, "Page format is null");
    }

    // Initializes stuff.
    private void init() {

        addAtInit(contentPanel, BorderLayout.CENTER);
        addAtInit(buttonPanel, BorderLayout.SOUTH);

        leftPageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentPage = Math.min(pageAmount, currentPage + e.getClickCount());
            }
        });

        rightPageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentPage = Math.max(0, currentPage - e.getClickCount());
            }
        });

        buttonPanel.add(leftPageButton, BorderLayout.WEST);
        buttonPanel.add(pageText, BorderLayout.CENTER);
        buttonPanel.add(rightPageButton, BorderLayout.EAST);
        /* Component adding */

        buttonPanel.setBorder(Graphic.DEF_BORDER);
        contentPanel.setBorder(Graphic.DEF_BORDER);
        setBorder(Graphic.DEF_BORDER);

        pageText.setText(String.format(pageFormat, currentPage, pageAmount));
        pageText.setHorizontalAlignment(JTextField.CENTER);
        pageText.setEditable(false);

    }

    @Immutable
    @Unsupported
    @Override
    protected final void addImpl(Component comp, Object constraints, int index) {
        throw new UnsupportedOperationException(
                "Illegal operation, use  GWrappedComponent.getContentLabel().add(...).");
    }

    // Use for initialize
    private void addAtInit(Component component, Object constrains) {
        super.addImpl(component, constrains, -1);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JButton getLeftPageButton() {
        return leftPageButton;
    }

    public JTextField getPageText() {
        return pageText;
    }

    public JButton getRightPageButton() {
        return rightPageButton;
    }

}
