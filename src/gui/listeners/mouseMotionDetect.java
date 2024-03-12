package src.gui.listeners;

import java.awt.event.*;
import src.main.Main;

public class mouseMotionDetect extends MouseAdapter {

    @Override
    public void mouseDragged(MouseEvent e) {
        if (clickDetect.leftClicked) {
            Main.gui.setLocation(e.getXOnScreen(),
                    e.getYOnScreen());
        }
    }

}
