package pack1;

import java.awt.*;
import java.util.ArrayList;

/**
 * The abstract Entity class is the superclass for all enemies and players.
 *
 * @author Julian Martens
 * *
 * * @version 1.5
 */
public abstract class Entity {
    /**
     * variables for the movement in x and y direction, acceleration for the x and y direction and the x and y coordinates.
     */
    protected double velX, velY, accX, accY, x, y;
    /**
     * The variable for the speed of the Entity
     */
    protected int speed = 3;
    /**
     * The standard width of the entities.
     */
    protected int width = 100;
    /**
     * The standard height of the entities.
     */
    protected int height = 175;
    /**
     * Variables for moving and walls for the player and the other entities.
     */
    protected boolean moveUp = false, moveDown = false, moveRight = false, moveLeft = false, wallAbove = false, wallUnder = false, wallLeft = false, wallRight = false, moveToPlayer = false, moveBothAwayFromPlayer = false, moveYAwayFromPlayer = false, moveXAwayFromPlayer = false;
    /**
     * The variable if the entity is alive.
     */
    protected boolean alive;
    /**
     * The variable for the life points the entities have.
     */
    protected int livePoints;
    /**
     * The spriteAnimation object that animates the entity.
     */
    protected SpriteAnimation spriteAnimation;

    /**
     * The rectangle for the first wall to add a hitbox.
     */
    protected static final Rectangle wall1 = new Rectangle(0, 0, Map.mapWidth, 100);
    /**
     * The rectangle for the second wall to add a hitbox.
     */
    protected static final Rectangle wall2 = new Rectangle(0, Map.mapHeight - 80, Map.mapWidth, 100);
    /**
     * The rectangle for the third wall to add a hitbox.
     */
    protected static final Rectangle wall3 = new Rectangle(0, 0, 35, Map.mapHeight);
    /**
     * The rectangle for the forth wall to add a hitbox.
     */
    protected static final Rectangle wall4 = new Rectangle(Map.mapWidth - 155, 0, Map.mapWidth, Map.mapHeight / 2 - 200);
    /**
     * The rectangle for the fifth wall to add a hitbox.
     */
    protected static final Rectangle wall5 = new Rectangle(Map.mapWidth - 155, Map.mapHeight / 2 + 180, Map.mapWidth, Map.mapHeight / 2 - 200);
    /**
     * The rectangle for the exit to add a hitbox.
     */
    protected static final Rectangle exit = new Rectangle(Map.mapWidth - 155, Map.mapHeight / 2 - 200, 500, 380);

    /**
     * The ArrayList stores the entities that are alive.
     */
    protected static ArrayList<Entity> entities = new ArrayList<>();
    /**
     * The ArrayList stores the Bullets that are in the game.
     */
    protected ArrayList<Bullets> bullets = new ArrayList<>();

    /**
     * The constructor from the Entity class as the super method for players and enemies.
     * <p>
     * Initialises the spriteAnimation of the object with the parameter spriteAnimation.
     * Initialises the x of the object with the parameter x.
     * Initialises the y of the object with the parameter y.
     * <p>
     * Also initialises velX, velY, accX and accY with 0.
     * The variable alive is set true and the livePoints are initialised with 8.
     * <p>
     * At least the object gets added to the entities ArrayList.
     *
     * @param spriteAnimation gets the spriteAnimation Array.
     * @param x               gets the x spawn coordinate.
     * @param y               gets the y spawn coordinate.
     */
    public Entity(SpriteAnimation spriteAnimation, double x, double y) {
        this.spriteAnimation = spriteAnimation;
        this.x = x;
        this.y = y;
        velX = 0;
        velY = 0;
        accX = 0;
        accY = 0;
        alive = true;
        livePoints = 8;

        entities.add(this);
    }

    /**
     * The hit method removes one livePoint from the the object that called the method.
     */
    public void hit() {
        livePoints--;
    }

    /**
     * Adds a bullet and moves it to the targeted position.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method.
     * And also offX with x- the return value off getOffX from the Panel class, - the entityX value.
     * Then offY with y- the return value off getOffY from the Panel class, - the entityY value.
     * <p>
     * Next the distance variable gets instantiated using the Pythagoras theorem with offX and offY.
     * <p>
     * The offX and offY gets divided with th distance and next multiplied with the variable VELOCITY from Bullets each one.
     * <p>
     * At least the bullets gets added the the bullets ArrayList with the shooter stored as parent, with entityX, entityY, offX and offY.
     *
     * @param x gets the x coordinate of the click.
     * @param y gets the y coordinate of the click.
     */
    public void addBullet(int x, int y) {
        double entityX = this.x;
        double entityY = this.y;


        double offX = (x - Panel.getOffX()) - entityX;
        double offY = (y - Panel.getOffX()) - entityY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        offX *= Bullets.VELOCITY;
        offY *= Bullets.VELOCITY;

        bullets.add(new Bullets(this, entityX, entityY, offX, offY));
    }

    /**
     * The update method which the enemies and teh Player has as super method.
     * <p>
     * At first every bullet gets updated.
     * <p>
     * Next accX is instantiated either -speed if moveLeft is true or +speed if moveRight is true if non of this is true its set to 0, next divided by 5.
     * Next accY is instantiated either -speed if moveUp is true or +speed if moveDown is true if non of this is true its set to 0, next divided by 5.
     * VelX gets added with accX and VelY with accY and both multiplied with 0.9.
     * After accX and accY are set 0.
     * <p>
     * If velX and velY is lower than 0.1 its set to 0.
     * <p>
     * All this is to make the movement smover.
     * <p>
     * Next the collide is called.
     * <p>
     * At least with the constrain method from class Game gets called that x and y don't get out of the range of the ground from the background (to be sure they cant cross the walls).
     */
    public void update() {
        for (int i = 0; i < bullets.size(); i++) bullets.get(i).update();


        accX = (moveLeft ? -speed : (moveRight ? speed : 0)) / 5f;
        accY = (moveUp ? -speed : (moveDown ? speed : 0)) / 5f;
        velX += accX;
        velY += accY;
        velX *= 0.9;
        velY *= 0.9;

        accX = 0;
        accY = 0;
        if (Math.abs(velX) <= 0.1) {
            velX = 0;
        }
        if (Math.abs(velY) <= 0.1) {
            velY = 0;
        }

        collide();

        x = Game.constrain(x + ((velX != 0 && velY != 0) ? velX / Math.sqrt(2) : velX), 35, Map.mapWidth - 155);
        y = Game.constrain(y + ((velX != 0 && velY != 0) ? velY / Math.sqrt(2) : velY), 100, Map.mapHeight - 80);

    }

    /**
     * Creates the rectangle for an hitbox.
     *
     * @return the rectangle for the hitbox with x, y, width and height values.
     */
    public Rectangle getCollider() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    /**
     * The method draws the current spriteAnimation Image if its not null, else its drawing a white rectangle.
     * After it draws all the bullets.
     *
     * @param g gets the drawing object that draws the Images.
     */
    public void show(Graphics g) {
        if (spriteAnimation != null)
            g.drawImage(spriteAnimation.getCurrent(), (int) x, (int) y, width, height, null);
        else {
            g.setColor(Color.WHITE);
            g.fillRect((int) x, (int) y, width, height);
        }
        for (int i = 0; i < bullets.size(); i++) bullets.get(i).draw((Graphics2D) g);
    }

    /**
     * Updates the spriteAnimation if its not null.
     */
    public void updateAnimation() {
        if (spriteAnimation != null)
            spriteAnimation.update();
    }

    /**
     * Passes the x value.
     *
     * @return the x value.
     */
    public double getX() {
        return x;
    }

    /**
     * Passes the y value.
     *
     * @return the y value.
     */
    public double getY() {
        return y;
    }

    /**
     * Collide gets the wall colliders.
     * First it gets the rectangle with the getCollider than the method looks if it intersects with any wall rectangle and if true its setting the associated variable.
     * <p>
     * Next the belonging velX, velY value to the wall variable is set zero.
     */
    public void collide() {
        Rectangle entityCollider = getCollider();
        wallAbove = entityCollider.intersects(wall1);
        wallUnder = entityCollider.intersects(wall2);
        wallLeft = entityCollider.intersects(wall3);
        wallRight = entityCollider.intersects(wall4) || entityCollider.intersects(wall5);
        wallRight = entityCollider.intersects(exit) && Enemy.enemies.size() > 0 && EnemyUpdate.waveCounter < 3;

        if (wallAbove) {
            if (velY < 0) velY = 0;
        } else if (wallUnder) {
            if (velY > 0) velY = 0;
        } else if (wallLeft) {
            if (velX < 0) velX = 0;
        } else if (wallRight) {
            if (velX > 0) velX = 0;
        }
    }

    /**
     * Gets the distance to the Player.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method.
     * And also offX with x- the return value off getOffX from the player object, - the entityX value.
     * Then offY with y- the return value off getOffY from the player object, - the entityY value.
     * <p>
     *
     * @return Next the distance gets returned using the Pythagoras theorem with offX and offY.
     */
    public double getDistanceToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        return Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));
    }

    /**
     * Gets the enemy to move to the player.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method.
     * And also offX with x- the return value off getOffX from the player object, - the entityX value.
     * Then offY with y- the return value off getOffY from the player object, - the entityY value.
     * <p>
     * offY and offX gets divided by the return value of the getDistanceToPlayer method.
     * <p>
     * x, y gets added offX and offY multiplied with the speed variable.
     */
    public void moveToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        offX /= getDistanceToPlayer();
        offY /= getDistanceToPlayer();

        x += offX * speed;
        y += offY * speed;
    }

    /**
     * Gets the enemy to away from the player in x and y direction.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method.
     * And also offX with x- the return value off getOffX from the player object, - the entityX value.
     * Then offY with y- the return value off getOffY from the player object, - the entityY value.
     * <p>
     * offY and offX gets divided by the return value of the getDistanceToPlayer method.
     * <p>
     * x, y gets added offX and offY multiplied with the negative speed variable minus 1.5.
     */
    public void moveAwayRelativeToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;

        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        offX /= getDistanceToPlayer();
        offY /= getDistanceToPlayer();

        x += offX * -(speed - 1.5);
        y += offY * -(speed - 1.5);
    }

    /**
     * Gets the enemy to away from the player in x and y direction.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method.
     * And also offX with x- the return value off getOffX from the player object, - the entityX value.
     * Then offY with y- the return value off getOffY from the player object, - the entityY value.
     * <p>
     * offY and offX gets divided by the return value of the getDistanceToPlayer method.
     * <p>
     * x gets added offX multiplied with the negative speed variable minus 1.25.
     * y gets added offY multiplied with the speed variable minus 1.25.
     */
    public void moveXAwayRelativeToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        offX /= getDistanceToPlayer();
        offY /= getDistanceToPlayer();

        x += offX * -(speed - 1.25);
        y += offY * (speed - 1.25);
    }

    /**
     * Gets the enemy to away from the player in x and y direction.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method.
     * And also offX with x- the return value off getOffX from the player object, - the entityX value.
     * Then offY with y- the return value off getOffY from the player object, - the entityY value.
     * <p>
     * offY and offX gets divided by the return value of the getDistanceToPlayer method.
     * <p>
     * x gets added offX multiplied with the speed variable minus 1.25.
     * y gets added offY multiplied with the negative speed variable minus 1.25.
     */
    public void moveYAwayRelativeToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;


        offX /= getDistanceToPlayer();
        offY /= getDistanceToPlayer();

        x += offX * (speed - 1.25);
        y += offY * -(speed - 1.25);
    }
}



