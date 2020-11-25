package pack1;

import javax.swing.*;
import java.awt.*;

/**
 * The Panel paints everything on the JPanel.
 *
 * @author Julian Martens
 * @version 1.5
 */
public class Panel extends JPanel {
    /**
     * offX and offY variable for the position off the camera.
     */
    private static double offX = 0D;
    private static double offY = 0D;

    /**
     * Overwrites the paintComponent method from the JPanel class.
     * <p>
     * First the method calls the method from the super method.
     * Next a object from the Graphics2D gets instantiated named g2d.
     * <p>
     * The background is set to Black and the RenderHint gets called.
     * <p>
     * Next offX and offY gets set to the negative player x and y coordinates.
     * Then the constrain method gets offX and offY as values an looks that the offX or offY don't greater than the map and not the whole map is shown.
     * The offX and offY then gets added the jf width and height, that the jf screen don't gets over the Map.
     * Then the player gets set always in the middle of the screen.
     * <p>
     * Next the map gets drawn, the player show method gets called and also the enemies.
     * Then the healthPoints gets drawn if the health of the player is higher than 0.
     * And the gameOver screen gets drawn if the player variable alive is false.
     * <p>
     * At last the shake gets calculated.
     *
     * @param g Graphic g that draws everything.
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setBackground(Color.BLACK);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        offX = -Game.player.x;
        offY = -Game.player.y;

        offX = Game.constrain(offX, -Map.mapWidth + Gui.jf.getWidth() / 2d, -(Gui.jf.getWidth() / 2d));
        offY = Game.constrain(offY, -Map.mapHeight + Gui.jf.getHeight() / 2d, -(Gui.jf.getHeight() / 2d));

        offX += Gui.jf.getWidth() / 2d;
        offY += Gui.jf.getHeight() / 2d;

        g2d.translate(offX + Game.currentShake * 20, offY);

        g.drawImage(Map.getMap(), 0, 0, Map.mapWidth, Map.mapHeight, null);
        Game.player.show(g);
        //if (Map.levelCounter == 1) PlayerOne.boss.show(g);
        for (int i = 0; i < Enemy.enemies.size(); i++) Enemy.enemies.get(i).show(g);
        if (Game.player.livePoints >= 0)
            g.drawImage(InitSpriteAnimation.healthImages[(int) Game.constrain(Game.player.livePoints, 0, 6)], -(int) offX, -(int) offY, null);
        if (!Game.player.alive) {
            g.drawImage(InitSpriteAnimation.gameOver, -(int) offX, -(int) offY, getWidth(), getHeight(), null);
        }

        //g.fillRect(Entity.wall2.x,Entity.wall2.y, Entity.wall2.width, Entity.wall2.height);
        if (Game.shake == Game.currentShake) Game.shake = 0;
        if (Game.shake > Game.currentShake) Game.currentShake++;
        else if (Game.shake < Game.currentShake) Game.currentShake--;
    }

    /**
     * Gets the offX variable.
     *
     * @return the value of the offX.
     */
    public static double getOffX() {
        return offX;
    }

    /**
     * Gets the offY variable
     *
     * @return the value of the offX.
     */
    public static double getOffY() {
        return offY;
    }
}






