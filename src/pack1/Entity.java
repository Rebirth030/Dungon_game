package pack1;

import java.awt.*;
import java.util.ArrayList;

public class Entity {
    public double velX, velY, accX, accY, x, y;
    static double speed = 3;
    int width = 100;
    int height = 175;
    boolean moveUp, moveDown, moveRight, moveLeft, wallAbove, wallUnder, wallLeft, wallRight;
    boolean alive;
    int livePoints;
    SpriteAnimation spriteAnimation;

    public static ArrayList<Entity> entities = new ArrayList<>();
    public  ArrayList<Bullets> bullets = new ArrayList<>();


    public Entity(SpriteAnimation spriteAnimation,double x, double y) {
        this.spriteAnimation = spriteAnimation;
        this.x = x;
        this.y = y;
        velX = 0;
        velY = 0;
        accX = 0;
        accY = 0;
        alive = true;
        livePoints = 8;
    }

    public void hit(){
        livePoints--;
    }

    public void addBullet(int x, int y) {
        double entityX = x + width;
        double entityY = y + height / 2D;


        double offX = (x - Panel.offX) - entityX;
        double offY = (y - Panel.offY) - entityY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        offX *= Bullets.VELOCITY;
        offY *= Bullets.VELOCITY;

        //System.out.println(offX);

        bullets.add(new Bullets(this, entityX, entityY, offX, offY));
    }

    public void update() {
        for (int i = 0; i < bullets.size(); i++) bullets.get(i).update();


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

    public Rectangle getCollider(){
        return new Rectangle((int)x,(int)y, width, height);
    }

    public void show(Graphics g) {
        g.drawImage(SpriteAnimation.getEnemy_1(), (int) x, (int) y, width, height, null);
        for (int i = 0; i < bullets.size(); i++) bullets.get(i).draw((Graphics2D) g);
    }
}


