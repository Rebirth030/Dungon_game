package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The class that creates the Map and has its sizes.
 * @author Julian Martens
 *
 * @version 1.3
 */
public class Map {
    static int levelCounter = 0;

    static int mapWidth = 3840, mapHeight = 2160;
    private static Image[] level;

    /**
     * Initialises an image Array with three Background images.
     * It tries to initialise an Array with the Maps.
     */
    static void createMap() {
        try {
            level = new Image[]{
                    ImageIO.read(new File("rsc/dungonBackground.png")),
                    ImageIO.read(new File("rsc/Dungon background2.png")),
                    ImageIO.read(new File("rsc/Dungon background3.png"))
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Gets the Image of the current Map.
     * @return the background Image.
     */
    static Image getMap() {
        return level[levelCounter];
    }
}


