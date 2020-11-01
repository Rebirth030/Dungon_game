package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyHandler implements KeyListener {
    static boolean moveUp = false, moveDown = false, moveRight = false, moveLeft = false;
    static boolean wallAbove = false, wallUnder = false, wallLeft = false, wallRight = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            moveUp = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            moveDown = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            moveRight = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            moveLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            moveUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            moveDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            moveRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            moveLeft = false;
        }
    }


}
