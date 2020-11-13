package pack1;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends Entity {
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(double x, double y) {
        super(SpriteAnimation.enemyAnimation, x, y);
        livePoints = 8;
        spriteAnimation.setCurrent(spriteAnimation.movingForward);
    }

    @Override
    public void update() {
        super.update();
        if (livePoints == 0) {
            enemies.remove(this);
            alive = false;
            x = Map.mapWidth;
            y = -Map.mapHeight;
        }
    }

    @Override
    public void collide() {
        super.collide();
        wallRight = wallRight || getCollider().intersects(Collider.exit);
    }

    public void movement() {
        double i = Math.random() * 10;
        double a = Math.random() * 1000;

        /*switch ((int) i) {
            case 0:
            case 1:
                moveAwayPlayer();
                break;
            case 2:
            case 3:
                moveXAwayPlayer();
                break;
            case 4:
            case 5:
                moveYAwayPlayer();
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                moveToPlayer();
            default:

        }*/
    }
    public void moveToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * 5;
        y += offY * 5;
    }
    public void moveAwayPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;

        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * -5;
        y += offY * -5;
    }
    public void moveXAwayPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * -5;
        y += offY * 5;
    }
    public void moveYAwayPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * 5;
        y += offY * -5;
    }
}
