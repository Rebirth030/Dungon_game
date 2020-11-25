/*
// That's just an test for a boss
package pack1;

import java.awt.*;

public class EnemyBoss extends Enemy {

    public EnemyBoss(double x, double y,int speed) {
        super(SpriteAnimation.enemyAnimation, x, y);
        width = 300;
        height = 500;
        livePoints = 8;
        speed = 5;
        spriteAnimation.setCurrent(spriteAnimation.movingLeft);
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
            x = Map.mapWidth;
            y = -Map.mapHeight;

            movement();
        }

    }

    public void movement() {
        double i = Game.getRandomNumber() * 100;
        double a = Game.getRandomNumber() * 100;

        if (i < 2) {
            if (a < 25) {
                moveBothAwayFromPlayer = true;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 25 && a < 50) {
                moveXAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 50 && a < 75) {
                moveYAwayFromPlayer = true;
                moveBothAwayFromPlayer = false;
                moveXAwayFromPlayer = false;
                moveToPlayer = false;
            } else if (a > 75) {
                moveToPlayer = true;
                moveBothAwayFromPlayer = false;
                moveXAwayFromPlayer = false;
                moveYAwayFromPlayer = false;
            }
        }


    }
        @Override
        public void collide() {
            super.collide();
            wallRight = wallRight || getCollider().intersects(exit);
        }

    @Override
    public void show(Graphics g) {
        super.show(g);
    }
}
*/
