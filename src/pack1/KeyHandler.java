package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            Game.player.moveUp = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            Game.player.moveDown = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            Game.player.moveRight = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            Game.player.moveLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W) {
            Game.player.moveUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            Game.player.moveDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            Game.player.moveRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            Game.player.moveLeft = false;
        }
    }


}
