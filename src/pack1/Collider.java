package pack1;

import java.awt.*;

public class Collider {
    static Rectangle wall1 = new Rectangle(0, 0, LevelOne.mapWidth, 100);
    static Rectangle wall2 = new Rectangle(0, LevelOne.mapHeight - 80, LevelOne.mapWidth, 100);
    static Rectangle wall3 = new Rectangle(0, 0, 35, LevelOne.mapHeight);
    static Rectangle wall4 = new Rectangle(LevelOne.mapWidth - 155, 0, LevelOne.mapWidth, LevelOne.mapHeight / 2 - 200);
    static Rectangle wall5 = new Rectangle(LevelOne.mapWidth - 155, LevelOne.mapHeight / 2 + 180, LevelOne.mapWidth, LevelOne.mapHeight / 2 - 200);
    static Rectangle exit = new Rectangle(LevelOne.mapWidth - 155, LevelOne.mapHeight / 2 - 200, 500, 380);


    public static void PlayerWallCollider() {
        Rectangle player = new Rectangle((int) PlayerOne.getX(), (int) PlayerOne.getY(), PlayerOne.playerWidth, PlayerOne.playerHeight);
        if (player.intersects(wall1)) {
            KeyHandler.wallAbove = true;
        } else {
            KeyHandler.wallAbove = false;
            if (player.intersects(wall2)) {
                KeyHandler.wallUnder = true;
            } else {
                KeyHandler.wallUnder = false;
                if (player.intersects(wall3)) {
                    KeyHandler.wallLeft = true;
                } else {
                    KeyHandler.wallLeft = false;
                    if (player.intersects(wall4)) {
                        KeyHandler.wallRight = true;
                    } else {
                        KeyHandler.wallRight = false;
                        if (player.intersects(wall5)) {
                            KeyHandler.wallRight = true;
                        } else {
                            KeyHandler.wallRight = false;
                            if (player.intersects(exit)/* && enemyCounter == 0*/) {
                                KeyHandler.wallAbove = true;
                                KeyHandler.wallUnder = true;
                                KeyHandler.wallLeft = true;
                                KeyHandler.moveRight = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
