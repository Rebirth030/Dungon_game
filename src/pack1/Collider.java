package pack1;

import java.awt.*;

public class Collider {
    static Rectangle wall1 = new Rectangle(0, 0, Map.mapWidth, 100);
    static Rectangle wall2 = new Rectangle(0, Map.mapHeight - 80, Map.mapWidth, 100);
    static Rectangle wall3 = new Rectangle(0, 0, 35, Map.mapHeight);
    static Rectangle wall4 = new Rectangle(Map.mapWidth - 155, 0, Map.mapWidth, Map.mapHeight / 2 - 200);
    static Rectangle wall5 = new Rectangle(Map.mapWidth - 155, Map.mapHeight / 2 + 180, Map.mapWidth, Map.mapHeight / 2 - 200);
    static Rectangle exit = new Rectangle(Map.mapWidth - 155, Map.mapHeight / 2 - 200, 500, 380);


    public static void PlayerWallCollider() {
        Rectangle player = new Rectangle((int) Game.player.x, (int) Game.player.y, Game.player.width, Game.player.height);
        if (player.intersects(wall1)) {
            Game.player.wallAbove = true;
        } else {
            Game.player.wallAbove = false;
            if (player.intersects(wall2)) {
                Game.player.wallUnder = true;
            } else {
                Game.player.wallUnder = false;
                if (player.intersects(wall3)) {
                    Game.player.wallLeft = true;
                } else {
                    Game.player.wallLeft = false;
                    if (player.intersects(wall4)) {
                        Game.player.wallRight = true;
                    } else {
                        if (player.intersects(wall5)) {
                            Game.player.wallRight = true;
                        } else {
                            Game.player.wallRight = false;
                            if (player.intersects(exit) && Map.enemyCounter == 0 && Map.levelCounter == 0) {
                                Game.player.wallAbove = true;
                                Game.player.wallUnder = true;
                                Game.player.wallLeft = true;
                                Game.player.moveRight = true;
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    Map.levelCounter = 1;
                                    //Game.player.PlayerOne(0,0); // 0,0 nur testweise
                                }
                                /* TODO:
                                    -Hier Hilfe Matheo
                                 */
                            }
                        }
                    }
                }
            }
        }
    }

    public static void enemyOneWallCollider(int i) {
        Rectangle enemy = Enemy.enemies.get(i).getCollider();
        if (enemy.intersects(wall1)) {
            Enemy.enemies.get(i).wallAbove = true;
        } else {
            Enemy.enemies.get(i).wallAbove = false;
            if (enemy.intersects(wall2)) {
                Enemy.enemies.get(i).wallUnder = true;
            } else {
                Enemy.enemies.get(i).wallUnder = false;
                if (enemy.intersects(wall3)) {
                    Enemy.enemies.get(i).wallLeft = true;
                } else {
                    Enemy.enemies.get(i).wallLeft = false;
                    if (enemy.intersects(wall4)) {
                        Enemy.enemies.get(i).wallRight = true;
                    } else {
                        if (enemy.intersects(wall5)) {
                            Enemy.enemies.get(i).wallRight = true;
                        } else {
                            Enemy.enemies.get(i).wallRight = false;
                            if (enemy.intersects(exit) && Map.enemyCounter == 0 && Map.levelCounter == 0) {
                                Enemy.enemies.get(i).wallAbove = true;
                                Enemy.enemies.get(i).wallUnder = true;
                                Enemy.enemies.get(i).wallLeft = true;
                                Enemy.enemies.get(i).moveRight = true;
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    Map.levelCounter = 1;
                                    //Game.player.PlayerOne(0,0); // 0,0 nur testweise
                                }
                                /* TODO:
                                    -Hier Hilfe Matheo
                                 */
                            }
                        }
                    }
                }
            }
        }
    }
}
