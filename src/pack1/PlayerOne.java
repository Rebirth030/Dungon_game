package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerOne {

    private static double x, y, velX, velY, accX, accY;
    static double speed = 3;
    static BufferedImage Hunter;
    static int playerWidth = 100;
    static int playerHeight = 175;

    public PlayerOne() {
        this(200, 200);
    }

    public PlayerOne(double x, double y) {
        this.x = x;
        this.y = y;
        velX = 0;
        velY = 0;
        accX = 0;
        accY = 0;
    }
//movement mit acc also rundere bewegungen nicht sofort stehen
    public static void update() {
        if(KeyHandler.moveDown) SpriteAnimation.setCurrent(SpriteAnimation.movingForward);
        if(KeyHandler.moveLeft) SpriteAnimation.setCurrent(SpriteAnimation.movingLeft);
        if(KeyHandler.moveRight) SpriteAnimation.setCurrent(SpriteAnimation.movingRight);
        if(KeyHandler.moveUp) SpriteAnimation.setCurrent(SpriteAnimation.movingBack);

        accX = (KeyHandler.moveLeft ? -speed : (KeyHandler.moveRight ? speed : 0)) / 5f;
        accY = (KeyHandler.moveUp ? -speed : (KeyHandler.moveDown ? speed : 0)) / 5f;
        velX += accX;
        velY += accY;
        velX *= 0.9;
        velY *= 0.9;
        if (Math.abs(velX) <= 0.1) {
            velX = 0;
        }
        if (Math.abs(velY) <= 0.005) {
            velY = 0;
        }
        x = Game.constrain(x + ((velX != 0 && velY != 0) ? velX / Math.sqrt(2) : velX), 0, LevelOne.mapWidth);
        y = Game.constrain(y + ((velX != 0 && velY != 0) ? velY / Math.sqrt(2) : velY), 0, LevelOne.mapHeight);
        accX = 0;
        accY = 0;

        if(velX == 0 && velY == 0){
             if(SpriteAnimation.current == SpriteAnimation.movingForward) {
                SpriteAnimation.setCurrent(SpriteAnimation.standingForward);
            }
             if(SpriteAnimation.current == SpriteAnimation.movingLeft) {
                 SpriteAnimation.setCurrent(SpriteAnimation.standingLeft);
             }
             if(SpriteAnimation.current == SpriteAnimation.movingRight) {
                 SpriteAnimation.setCurrent(SpriteAnimation.standingRight);
             }
             if(SpriteAnimation.current == SpriteAnimation.movingBack) {
                 SpriteAnimation.setCurrent(SpriteAnimation.standingBack);
             }
        }

    }

    public void showPlayer(Graphics g) {
        g.drawImage(SpriteAnimation.getCurrent(), (int) x, (int) y, playerWidth, playerHeight, null);
    }

    public static double getVelX() {
        return velX;
    }


    public static double getVelY() {
        return velY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAccX() {
        return accX;
    }

    public double getAccY() {
        return accY;
    }

    public static void createPlayerOne() {
        SpriteAnimation.init();
        try {
            Hunter = ImageIO.read(new File("rsc/forward1.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Bilder können nicht geladen werden");
        }
    }
}
