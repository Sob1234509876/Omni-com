package top.sob.core.ui;

import java.awt.Component;
import java.awt.BorderLayout;

import java.util.Objects;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * A component that could be multi-paged.
 */
public abstract class GWrappedComponent extends JPanel {

    public final static int DEF_PAGE_AMOUNT = 0;
    public final static String DEF_PAGE_FORMAT = "%d / %d";

    public final static int DEF_BOTTOM_HEIGHT = 50;
    public final static int DEF_BUTTON_WIDTH = 50;
    public final static int DEF_WIDTH = 300;
    public final static int DEF_HEIGHT = 350;

    /**
     * Label to put stuff
     */
    protected final JPanel buttonPanel = new JPanel();
    /**
     * Label to put information
     */
    protected final JPanel contentPanel = new JPanel();

    /**
     * The text to the page currently on
     */
    protected final JTextField pageText = new JTextField();
    /**
     * The button to turn to the last page
     */
    protected final JButton rightPageButton = new JButton(">");
    /**
     * The button to turn to the next page
     */
    protected final JButton leftPageButton = new JButton("<");

    // Some layout stuff
    protected final BorderLayout wholeLayout = new BorderLayout();
    protected final BorderLayout panelLayout = new BorderLayout();

    /**
     * The format of telling the current page. The default value is
     * {@link #DEF_PAGE_FORMAT}
     */
    protected String pageFormat;
    /**
     * The amount of pages
     */
    protected int pageAmount;
    /**
     * The current page on
     */
    protected int currentPage;

    /**
     * Creates a wrapped component with {@link #DEF_PAGE_AMOUNT} amount of pages.
     *
     * @see #GWrappedComponent(int)
     */
    public GWrappedComponent() {
        this(DEF_PAGE_AMOUNT);
    }

    /**
     * Creates a wrapped component with the given amount of pages. The current page
     * will be set to the last page.
     *
     * @param pageAmount The amount of pages in this component
     * @see #GWrappedComponent(int, int)
     */
    public GWrappedComponent(int pageAmount) {
        this(pageAmount, pageAmount);
    }

    /**
     * Creates a wrapped component with the given amount of pages. The current page
     * will be set to the given page.
     *
     * @param pageAmount The amount of pages in this component
     * @param defPage    The default page currently on
     * @see #GWrappedComponent(int, int, String)
     */
    public GWrappedComponent(int pageAmount, int defPage) {
        this(pageAmount, defPage, DEF_PAGE_FORMAT);
    }

    /**
     * Creates a wrapped component with the given amount of pages. Sets the format
     * of the text representing the current page on to the given argument. The
     * current page will be set to the last page.
     *
     * @param pageAmount The amount of pages
     * @param pageFormat The format of the text representing the current page on
     */
    public GWrappedComponent(int pageAmount, String pageFormat) {
        this(pageAmount, pageAmount, pageFormat);
    }

    /**
     * Creates a wrapped component with the given amount of pages. Sets the format
     * of the text representing the current page on to the given argument. The
     * current page will be set to the given page.
     *
     * @param pageAmount The amount of pages
     * @param defPage    The default page currently on
     * @param pageFormat The format of the text representing the current page on
     */
    public GWrappedComponent(int pageAmount, int defPage, String pageFormat) {
        this.pageAmount = pageAmount;
        this.currentPage = defPage;
        this.pageFormat = pageFormat;

        this.setLayout(wholeLayout);
        buttonPanel.setLayout(panelLayout);

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

    /**
     * This is not supported, if you wish to add components in this, please use
     *
     * <pre>{@code
     * GWrappedComponent.getContentLabel().add(...);
     * }</pre>
     */
    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        throw new UnsupportedOperationException(
                "Illegal operation, use  GWrappedComponent.getContentLabel().add(...).");
    }

    // Use for initialize
    private Component addAtInit(Component component, Object constrains) {
        super.addImpl(component, constrains, -1);
        return component;
    }

    /**
     * Returns the content label for adding contents and information. This thing
     * isn`t the buttons at the bottom of a default wrapped component.
     *
     * @return The content label
     */
    public JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     * Returns the button for turning the current page to the last page.
     *
     * @return The button
     */
    public JButton getLeftPageButton() {
        return leftPageButton;
    }

    /**
     * Returns the text field that shows the current page on.
     *
     * @return The text field
     */
    public JTextField getPageText() {
        return pageText;
    }

    /**
     * Returns the button for turning the current page to the next page.
     *
     * @return The button
     */
    public JButton getRightPageButton() {
        return rightPageButton;
    }

}
