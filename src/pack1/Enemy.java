package pack1;

import java.util.ArrayList;

/**
 * The Enemy class where the enemies gets instantiated from.
 * It extends the Entity class.
 *
 * @author Julian Martens
 * @version 2.3
 */
public class Enemy extends Entity {
    /**
     * An ArrayList that stores all entities in the game.
     */
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    /**
     * The constructor of the Enemy class which the enemies are build from.
     * <p>
     * The method extends the superclass method and gives them the parameters enemyAnimation form SpriteAnimation, x and y.
     * Also they get another width from 175, 8 livePoints, the speed from the parameters of the method and sets the current SpriteAnimation to movingForward{@link InitSpriteAnimation #initEnemyAnimation}.
     *
     * @param x     the x coordinate of the spawn point of the enemy.
     * @param y     the y coordinate of the spawn point of the enemy.
     * @param speed the speed the enemy has.
     */
    public Enemy(double x, double y, int speed) {
        super(SpriteAnimation.enemyAnimation, x, y);
        width = 175;
        livePoints = 8;
        this.speed = speed;
        spriteAnimation.setCurrent(spriteAnimation.movingForward);
    }

    /**
     * The update method for the enemies.
     * <p>
     * At first the update method of the super class gets called.
     * <p>
     * Next the method moveToPlayer gets called if the variable moveToPlayer is true.
     * Else if the variable moveBothAwayFromPlayer is true the method moveAwayRelativeToPlayer gets called.
     * Else if the variable moveYAwayFromPlayer is true the method moveYAwayRelativeToPlayer gets called.
     * Else if the variable moveXAwayFromPlayer is true the method moveXAwayRelativeToPlayer gets called.
     * <p>
     * At next the damage method from the player object gets called with the parameter 1 {@link PlayerOne #damage}.
     * <p>
     * If the livePoints of the enemy are 0, this enemy gets removed, the alive variable is set false and the x and y coordinate are set to the lower right corner, so the "hitbox" rectangle gets removed.
     */
    @Override
    public void update() {
        super.update();

        if (moveToPlayer) moveToPlayer();
        else if (moveBothAwayFromPlayer) moveAwayRelativeToPlayer();
        else if (moveYAwayFromPlayer) moveYAwayRelativeToPlayer();
        else if (moveXAwayFromPlayer) moveXAwayRelativeToPlayer();

        if (getDistanceToPlayer() < 100) Game.player.damage(1);

        if (livePoints == 0) {
            enemies.remove(this);
            alive = false;
            x = Map.mapWidth;
            y = -Map.mapHeight;
        }

    }

    /**
     * Overrides the collide method of the entity class{@link Entity #collide}.
     * <p>
     * First it calls the super method from the entity class.
     * Then the variable wallRight will be set true, if wallRight from the super method is true or if the collider of the enemy, that we get with the getCollider method, intersects with the exit rectangle.
     */
    @Override
    public void collide() {
        super.collide();
        wallRight = wallRight || getCollider().intersects(exit);
    }

    /**
     * The movement method that gets where the enemy goes randomly.
     * <p>
     * At first the double variables a and i gets instanced with random numbers multiplied with 100, so the numbers are between 0 and 100.
     * <p>
     * Then if i is lower than 2 (that's a 2% chance) the code goes on.
     * <p>
     * If the variable a is lower than 20 (20% chance) the variable moveBothAwayFromPlayer is set true and the other 3 move variables are set false.
     * If the variable a is lower than 40 but higher than 20 (20% chance) the variable moveXAwayFromPlayer is set true and the other 3 move variables are set false.
     * If the variable a is lower than 60 but higher than 40 (20% chance) the variable moveYAwayFromPlayer is set true and the other 3 move variables are set false.
     * If the variable a higher than 60 (40% chance) the variable moveToPlayer is set true and the other 3 move variables are set false.
     */
    public void movement() {
        double i = Game.getRandomNumber() * 100;
        double a = Game.getRandomNumber() * 100;

        if (i < 2) {
            if (a < 20) {
                moveBothAwayFromPlayer = true;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 20 && a < 40) {
                moveXAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 40 && a < 60) {
                moveYAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveXAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 60) {
                moveToPlayer = true;
                moveBothAwayFromPlayer = false;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
            }
        }

    }
}
