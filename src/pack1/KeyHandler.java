package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean activatedCheats = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W && Game.player.alive) {
            Game.player.moveUp = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S && Game.player.alive) {
            Game.player.moveDown = true;
        } else if (e.getKeyCode() == KeyEvent.VK_D && Game.player.alive) {
            Game.player.moveRight = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A && Game.player.alive) {
            Game.player.moveLeft = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_P) activatedCheats = true;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        if (e.getKeyCode() == KeyEvent.VK_E && activatedCheats) Game.player.livePoints = 6;


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
