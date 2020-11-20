package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map {
    static int levelCounter = 0;

    static int mapWidth = 3840, mapHeight = 2160;
    private static Image[] level;

    static void createMap() {

        try {
            level = new Image[]{
                    ImageIO.read(new File("rsc/dungonBackground.png")),
                    ImageIO.read(new File("rsc/Dungon background2.png"))
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static Image getMap() {
        return level[levelCounter];
    }
}


