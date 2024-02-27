package Codes.Listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * Not usable for mods (You`re not allowed to do stuffs to the frame).
 */

public class CloseWindow implements WindowListener {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    // Mountain of useless code
    public void windowOpening(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

}