package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelOne extends Rectangle {


    static int mapWidth = 3840, mapHeight = 2160;
    static BufferedImage back1;

    public static void createLevelOne() {
        try {
            //background
            back1 = ImageIO.read(new File("rsc/dungonBackground.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Background Error");
        }
    }
}


