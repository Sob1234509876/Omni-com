package src.gui.listeners;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/*
 * Use KeyDetect.PressedKey for getting current pressed key
 */

public class keyDetect implements KeyListener {

    public volatile static int PressedKey = 0;

    public void keyPressed(KeyEvent k) {

        keyDetect.PressedKey = k.getKeyCode();

    }

    public void keyTyped(KeyEvent k) {
    }

    public void keyReleased(KeyEvent k) {
    }

}