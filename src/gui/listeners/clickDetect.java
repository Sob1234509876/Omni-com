package src.gui.listeners;

import java.awt.event.*;

public class clickDetect extends MouseAdapter {

    public volatile static boolean leftClicked = false;

    @Override
    public void mousePressed(MouseEvent e) {
        leftClicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        leftClicked = false;
    }
}
