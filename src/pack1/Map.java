package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The class that creates the Map and has its sizes.
 *
 * @author Julian Martens
 * @version 1.3
 */
public class Map {
    /**
     * The levelCounter that counts the Maps which are shown.
     */
    static int levelCounter = 0;

    /**
     * mapWidth and mapHeight sores the Height and the width of the Background map.
     */
    static int mapWidth = 3840, mapHeight = 2160;
    /**
     * Saves the pictures of the map in a Array.
     */
    private static Image[] level;

    /**
     * Initialises an image Array with three Background images.
     * It tries to initialise an Array with the Maps.
     */
    static void createMap() {
        try {
            level = new Image[]{
                    ImageIO.read(Map.class.getResource("/dungonBackground.png")),
                    ImageIO.read(Map.class.getResource("/Dungon background2.png")),
                    ImageIO.read(Map.class.getResource("/Dungon background3.png"))
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void nextLevel() {
        Map.levelCounter++;
        Game.player.setX(35);
        Game.player.setY(966);
    }

    /**
     * Gets the Image of the current Map.
     *
     * @return the background Image.
     */
    static Image getMap() {
        return level[levelCounter];
    }
}


