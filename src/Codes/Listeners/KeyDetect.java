package Codes.Listeners;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/*
 * Use KeyDetect.PressedKey for getting current pressed key
 */

public class KeyDetect implements KeyListener {

    public volatile static int PressedKey = 0;

    public void keyPressed(KeyEvent k){
        
        PressedKey = k.getKeyCode();

    }

    public void keyTyped(KeyEvent k){}

    public void keyReleased(KeyEvent k){}

}