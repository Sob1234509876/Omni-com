package src.gui.listeners;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Use {@code KeyDetect.PressedKey} for getting current pressed key, do not to
 * set it back to {@code '\0'} to prevent LOD (loop of death)
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