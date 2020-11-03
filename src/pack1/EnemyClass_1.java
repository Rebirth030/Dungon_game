package pack1;

import java.awt.*;
import java.util.ArrayList;

public class EnemyClass_1 {
    public double velX, velY, accX, accY, x, y;
    static double speed = 3;
    static int enemyWidth = 100;
    static int enemyHeight = 175;
    static boolean moveUp, moveDown, moveRight, moveLeft, wallAbove, wallUnder, wallLeft, wallRight;
    boolean alive;
    int livePoints;
    private Rectangle enemyClass_1Hitbox;

    public static ArrayList<EnemyClass_1> enemysClass_1 = new ArrayList<>();
    public static ArrayList<EnemyBullets> enemyClass_1bullets = new ArrayList<>();

    public static void addEnemyBullet(double x, double y) {
        double enemyX = x + EnemyClass_1.enemyWidth;
        double enemyY = y + EnemyClass_1.enemyHeight / 2D;

        double offX = (PlayerOne.getX() - Panel.offX) - enemyX;
        double offY = (PlayerOne.getY() - Panel.offY) - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        offX *= EnemyBullets.VELOCITY;
        offY *= EnemyBullets.VELOCITY;

        EnemyClass_1.enemyClass_1bullets.add(new EnemyBullets(enemyX, enemyY, offX, offY));
    }

    public EnemyClass_1(double x, double y) {
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
        //hier hilfe
        addEnemyBullet(x, y);
        //
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

        enemyClass_1Hitbox = new Rectangle((int) x, (int) y, EnemyClass_1.enemyWidth, EnemyClass_1.enemyHeight);
        if (enemyClass_1Hitbox.intersects(Collider.wall1)) moveUp = false;
        else if (enemyClass_1Hitbox.intersects(Collider.wall2)) moveDown = false;
        else if (enemyClass_1Hitbox.intersects(Collider.wall3)) moveLeft = false;
        else if (enemyClass_1Hitbox.intersects(Collider.wall4)) moveRight = false;
        else if (enemyClass_1Hitbox.intersects(Collider.wall5)) moveRight = false;
        else if (enemyClass_1Hitbox.intersects(Collider.exit)) moveRight = false;
    }

    public void showEnemy_1(Graphics g) {
        g.drawImage(SpriteAnimation.getEnemy_1(), (int) x, (int) y, enemyWidth, enemyHeight, null);
        for (int i = 0; i < enemyClass_1bullets.size(); i++) enemyClass_1bullets.get(i).draw((Graphics2D) g);
    }
}
