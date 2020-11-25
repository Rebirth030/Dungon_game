package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Bullet class that updates and creates the Bullets.
 *
 * @author Julian Martens
 * @version 1.2
 */
public class Bullets {
    /**
     * x coordinate of the Bullet.
     */
    private double x;
    /**
     * y coordinate of the Bullet
     */
    private double y;
    /**
     * The movement into the x and y directions of the map.
     */
    private final double velX, velY;
    /**
     * Width and height from the Bullet.
     */
    public static int width = 40, height = 40;
    /**
     * The Entity that shot the bullet.
     */
    public Entity parent;
    /**
     * The speed of the Bullet.
     */
    public static final double VELOCITY = 10D;
    /**
     * The variable for the Image of the Bullet.
     */
    public static Image bullet;

    static {
        try {
            bullet = ImageIO.read(new File("rsc/player/schuss_player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The constructor of the Bullet class.
     * Sets the parameters to the variables of the bullet.
     *
     * @param parent ist the entity that its coming from either the player or the enemies (later on, not now).
     * @param x      the x coordinate of the parent.
     * @param y      the y coordinate of the parent.
     * @param velX   the x coordinate of the target.
     * @param velY   the y coordinate of the target.
     */
    public Bullets(Entity parent, double x, double y, double velX, double velY) {
        this.parent = parent;
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
    }

    /**
     * Draws the Image of the Bullet by its x and y coordination with their width and height.
     *
     * @param g gets the object that draws the Image.
     */
    public void draw(Graphics2D g) {
        g.drawImage(bullet, (int) x, (int) y, width, height, null);
    }

    /**
     * Updates the Bullet.
     * <p>
     * Adds the velX and VelY values to the x and y coordinates.
     * <p>
     * If the Bullets x or y value gets higher or lower than the approximate coordinates of the wall, the Bullet will disappear.
     * <p>
     * Next it sets the hitbox for the Bullet with a rectangle having the x,y,width and height vaues.
     * <p>
     * At last the method looks for every existing Bullet if its intersecting the hitbox from another entity that is not the parent, calls the hit method, if its true and removes the Bullet after that.
     */
    public void update() {
        x += velX;
        y += velY;

        if (x < 35 || x > Map.mapWidth - 155 || y < 100 || y > Map.mapHeight - 80) {
            parent.bullets.remove(this);
        }
        Rectangle bullet = new Rectangle((int) x, (int) y, width, height);
        for (int i = 0; i < Entity.entities.size(); i++) {
            if (Entity.entities.get(i) == this.parent) continue;
            if (bullet.intersects(Entity.entities.get(i).getCollider())) {
                Entity.entities.get(i).hit();
                parent.bullets.remove(this);
            }
        }

    }
}
