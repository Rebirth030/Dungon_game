package pack1;

import java.awt.*;

public class Collider {
    static final Rectangle wall1 = new Rectangle(0, 0, Map.mapWidth, 100);
    static final Rectangle wall2 = new Rectangle(0, Map.mapHeight - 80, Map.mapWidth, 100);
    static final Rectangle wall3 = new Rectangle(0, 0, 35, Map.mapHeight);
    static final Rectangle wall4 = new Rectangle(Map.mapWidth - 155, 0, Map.mapWidth, Map.mapHeight / 2 - 200);
    static final Rectangle wall5 = new Rectangle(Map.mapWidth - 155, Map.mapHeight / 2 + 180, Map.mapWidth, Map.mapHeight / 2 - 200);
    static final Rectangle exit = new Rectangle(Map.mapWidth - 155, Map.mapHeight / 2 - 200, 500, 380);
}
