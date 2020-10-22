package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelOne extends Rectangle {


    static int mapWidth = 3840, mapHeight = 2160;
    static BufferedImage back1;
    static int playerX = (int) PlayerOne.getVelX();
    static int playerY = (int) PlayerOne.getVelY();
    static int playerX2 = (int) PlayerOne.getVelX() - PlayerOne.playerWidth;
    static int playerY2 = (int) PlayerOne.getVelX() - PlayerOne.playerHeight;
    static Rectangle r1 = new Rectangle(0, 0, 500, 10);
    static Rectangle r2 = new Rectangle(playerX, playerY, playerX2, playerY2);

    public static void createLevelOne() {
        try {
            //background
            back1 = ImageIO.read(new File("rsc/Back1.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Background Error");
        }
    }

    public static void collisionDetection() {
        if (r1.intersects(r2)) {
            System.out.println("Collision");
        }
    }


}


