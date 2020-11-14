package pack1;

import java.util.ArrayList;

public class Enemy extends Entity {
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(double x, double y) {
        super(SpriteAnimation.enemyAnimation, x, y);
        width = 250;
        livePoints = 8;
        spriteAnimation.setCurrent(spriteAnimation.movingForward);
    }

    @Override
    public void update() {
        super.update();
        while (moveToPlayer) moveToPlayer();
        while (moveBothAwayFromPlayer) moveAwayRelativeToPlayer();
        while (moveYAwayFromPlayer) moveYAwayRelativToPlayer();
        while (moveXAwayFromPlayer) moveXAwayRelativToPlayer();
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
        double i = Math.random() * 100;
        double a = Math.random() * 100;

        if (i < 20) {
            if (a < 20) {
                moveBothAwayFromPlayer = true;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 20 && a < 40) {
                moveXAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveYAwayFromPlayer = true;
                moveToPlayer = false;
            } else if (a > 40 && a < 60) {
                moveYAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveXAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 60) {
                moveToPlayer = true;
                moveBothAwayFromPlayer = false;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = true;
            }
        }

    }

    public void moveToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * (speed - 1);
        y += offY * (speed - 1);
    }

    public void moveAwayRelativeToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;

        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * 1 - (speed - 1.25);
        y += offY * 1 - (speed - 1.25);
    }

    public void moveXAwayRelativToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * -(speed - 1.25);
        y += offY * (speed - 1.25);
    }

    public void moveYAwayRelativToPlayer() {
        double enemyX = this.x;
        double enemyY = this.y;


        double offX = Game.player.getX() - enemyX;
        double offY = Game.player.getY() - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        x += offX * (speed - 1.25);
        y += offY * -(speed - 1.25);
    }
}
