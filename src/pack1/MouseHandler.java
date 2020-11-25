package pack1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The KeyHandler class listens to the Key input.
 * It extends the KeyListener class.
 *
 * @author Julian Martens
 * @version 1.2
 */
public class MouseHandler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Shoots if the mouseKey is pressed.
     * <p>
     * If the left mouse Button is pressed the position will be given to a added Bullet.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Game.player.addBullet(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
