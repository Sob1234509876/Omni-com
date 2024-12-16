package top.sob.vanilla.ui;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;

import top.sob.core.exceptions.MissingResourceException;
import top.sob.vanilla.Meta;

public final class GImg extends GWrappedComponent {

    private final JLabel label = new JLabel();
    @SuppressWarnings("unused")
    private static final String UnknownPicURL = "https://static.wikia.nocookie.net/omni-com-official/images/2/24/UnknownGt.png";

    public GImg() {

        var UPL = "assets/img/UnknownGt.png";
        var urlOfUP = Meta.THIS_CLASS_LOADER.getResource(UPL);

        if (urlOfUP == null) throw new MissingResourceException(UPL);

        initLabel(new ImageIcon(urlOfUP));
    }

    @SuppressWarnings("unused")
    public GImg(ImageIcon icon) {
        initLabel(icon);
    }

    private void initLabel(ImageIcon icon) {

        label.setIcon(icon);
        label.setBackground(Graphic.DEF_BG_COLOR);
        getContentPanel().setLayout(new BorderLayout());
        getContentPanel().add(label, BorderLayout.CENTER);

        getContentPanel().setBackground(Color.GRAY);
        getContentPanel().setForeground(Graphic.DEF_FG_COLOR);
        getLeftPageButton().setBackground(Graphic.DEF_BG_COLOR);
        getLeftPageButton().setForeground(Graphic.DEF_FG_COLOR);
        getPageText().setBackground(Graphic.DEF_BG_COLOR);
        getPageText().setForeground(Graphic.DEF_FG_COLOR);
        getRightPageButton().setBackground(Graphic.DEF_BG_COLOR);
        getRightPageButton().setForeground(Graphic.DEF_FG_COLOR);

    }

    public void setImage(ImageIcon img) {
        label.setIcon(img);
    }

}
