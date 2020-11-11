package pack1;

import java.util.ArrayList;

public class Enemy extends Entity {
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(double x, double y) {
        super(SpriteAnimation.enemyAnimation, x, y);
        livePoints = 8;
        spriteAnimation.setCurrent(spriteAnimation.movingForward);
    }


    public void update(int i) {
        super.update();
        if (livePoints == 0) {
            enemies.remove(this);
            alive = false;
            x = Map.mapWidth;
            y = -Map.mapHeight;
            Collider.enemyOneWallCollider(i);
        }

    }
    public void movement() {
        double i = Math.random() * 10;
        double a = Math.random() * 1000;

        double enemyX = this.x;
        double enemyY = this.y;


        double offX = (Game.player.x - Panel.getOffX()) - enemyX;
        double offY = (Game.player.y - Panel.getOffY()) - enemyY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        offX *= 5;
        offY *= 5;

        /*switch ((int) i) {
            case 0:
            case 1:
                moveUp = true;
                try {
                    Thread.sleep((int)a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveUp = false;
                System.out.println("hoch");
                break;
            case 2:
            case 3:
                moveLeft = true;
                try {
                    Thread.sleep((int)a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveLeft = false;
                System.out.println("links");
                break;
            case 4:
            case 5:
                moveRight = true;
                try {
                    Thread.sleep((int)a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveRight = false;
                System.out.println("rechts");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                moveDown = true;
                try {
                    Thread.sleep((int)a*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveDown = false;
                System.out.println("player");
            default:

        }*/
    }
}
