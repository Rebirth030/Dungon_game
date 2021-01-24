package pack1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The KeyHandler class listens to the Key input.
 * It extends the KeyListener class.
 *
 * @author Julian Martens
 * @version 1.2
 */
public class KeyHandler implements KeyListener {
    /**
     * The variable has to be set true to use cheats in the game.
     */
    public boolean activatedCheats = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Overrides the keyPressed method from Key Listener.
     * <p>
     * First if the Key W is pressed and the player is alive the variable moveUp will be set true.
     * else if the Key S is pressed and the player is alive the variable moveDown will be set true.
     * else if the Key D is pressed and the player is alive the variable moveRight will be set true.
     * else if the Key A is pressed and the player is alive the variable moveLeft will be set true.
     * <p>
     * If the Key P is pressed the activatedCheats variable is set true.
     * If the Key ESCAPE is pressed the Game will be ended.
     * If the Key E is pressed and the activatedCheats variable is true, the livePoints of the player are set to six.
     *
     * @param e gets the Key event.
     */
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

        if (e.getKeyCode() == KeyEvent.VK_P) EnemyUpdate.waveCounter = 4;
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        if (e.getKeyCode() == KeyEvent.VK_E ) Game.player.livePoints = 6;


    }

    /**
     * Overrides the keyReleased method from Key Listener.
     * <p>
     * First if the Key W is released the variable moveUp will be set false.
     * else if the Key S is released the variable moveDown will be set false.
     * else if the Key D is released the variable moveRight will be set false.
     * else if the Key A is released the variable moveLeft will be set false.
     *
     * @param e gets the Key event.
     */
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
