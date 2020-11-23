package pack1;

import java.util.ArrayList;

public class Enemy extends Entity {
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(double x, double y,int speed) {
        super(SpriteAnimation.enemyAnimation, x, y);
        width = 175;
        livePoints = 8;
        this.speed = speed;
        spriteAnimation.setCurrent(spriteAnimation.movingForward);
    }

    @Override
    public void update() {
        super.update();

        if (moveToPlayer) moveToPlayer();
        else if (moveBothAwayFromPlayer) moveAwayRelativeToPlayer();
        else if (moveYAwayFromPlayer) moveYAwayRelativeToPlayer();
        else if (moveXAwayFromPlayer) moveXAwayRelativeToPlayer();

        if (getDistanceToPlayer() < 100) Game.player.damage(1);

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
        wallRight = wallRight || getCollider().intersects(exit);
    }

    public void movement() {
        double i = Game.getRandomNumber() * 100;
        double a = Game.getRandomNumber() * 100;

        if (i < 2) {
            if (a < 20) {
                moveBothAwayFromPlayer = true;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 20 && a < 40) {
                moveXAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
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
                moveYAwayFromPlayer = false;
            }
        }

    }
}
