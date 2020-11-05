package pack1;

import java.awt.*;
import java.util.ArrayList;

public class Enemy {
    public double velX, velY, accX, accY, x, y;
    static double speed = 3;
    static int enemyWidth = 100;
    static int enemyHeight = 175;
    static boolean moveUp, moveDown, moveRight, moveLeft, wallAbove, wallUnder, wallLeft, wallRight;
    boolean alive;
    int livePoints;

    public static ArrayList<Enemy> enemysClass_1 = new ArrayList<>();


    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        velX = 0;
        velY = 0;
        accX = 0;
        accY = 0;
        alive = true;
        livePoints = 8;
    }

    public void updateEnemy_1() {
        if (KeyHandler.wallAbove) {
            moveUp = false;
            if (velY < 0) velY = 0;
        } else if (KeyHandler.wallUnder) {
            moveDown = false;
            if (velY > 0) velY = 0;
        } else if (KeyHandler.wallLeft) {
            moveLeft = false;
            if (velX < 0) velX = 0;
        } else if (KeyHandler.wallRight) {
            moveRight = false;
            if (velX > 0) velX = 0;
        }
        accX = (moveLeft ? -speed : (moveRight ? speed : 0)) / 5f;
        accY = (moveUp ? -speed : (moveDown ? speed : 0)) / 5f;
        velX += accX;
        velY += accY;
        velX *= 0.9;
        velY *= 0.9;
        if (Math.abs(velX) <= 0.1) {
            velX = 0;
        }
        if (Math.abs(velY) <= 0.1) {
            velY = 0;
        }
        x = Game.constrain(x + ((velX != 0 && velY != 0) ? velX / Math.sqrt(2) : velX), 0, LevelOne.mapWidth);
        y = Game.constrain(y + ((velX != 0 && velY != 0) ? velY / Math.sqrt(2) : velY), 0, LevelOne.mapHeight);
        accX = 0;
        accY = 0;

    }

    public void showEnemy_1(Graphics g) {
        g.drawImage(SpriteAnimation.getEnemy_1(), (int) x, (int) y, enemyWidth, enemyHeight, null);
    }
}
