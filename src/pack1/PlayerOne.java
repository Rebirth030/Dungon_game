package pack1;

public class PlayerOne extends Entity {
    int invincible = 0;

    public PlayerOne() {
        this(564, 782);
    }

    public PlayerOne(double x, double y) {
        super(SpriteAnimation.playerAnimation, x, y);
        livePoints = 6;

        spriteAnimation.setCurrent(spriteAnimation.standingRight);
    }

    @Override
    public void addBullet(int x, int y) {
        double entityX = this.x + width - width / 8d;
        double entityY = this.y + height / 2d;


        double offX = (x - Bullets.width / 2d - Panel.getOffX()) - entityX;
        double offY = (y - Bullets.height / 2d - Panel.getOffY()) - entityY;

        double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

        offX /= distance;
        offY /= distance;

        offX *= Bullets.VELOCITY;
        offY *= Bullets.VELOCITY;

        bullets.add(new Bullets(this, entityX, entityY, offX, offY));
    }

    @Override
    public void update() {
        SpriteAnimation s = spriteAnimation;

        super.update();

        if (wallAbove) {
            moveUp = false;
        } else if (wallUnder) {
            moveDown = false;
        } else if (wallLeft) {
            moveLeft = false;
        } else if (wallRight) {
            moveRight = false;
        }


        if (moveRight && moveUp) s.setCurrent(s.movingBackRight);
        else if (moveLeft && moveUp) s.setCurrent(s.movingBackLeft);
        else if (moveRight && moveDown) s.setCurrent(s.movingRight);
        else if (moveLeft && moveDown) s.setCurrent(s.movingLeft);
        else if (moveDown) s.setCurrent(s.movingForward);
        else if (moveUp) s.setCurrent(s.movingBack);
        else if (moveRight) s.setCurrent(s.movingRight);
        else if (moveLeft) s.setCurrent(s.movingLeft);

        if (velX == 0 && velY == 0) {
            if (s.current == s.movingBackRight)
                s.setCurrent(s.standingBackRight);
            else if (s.current == s.movingBackLeft)
                s.setCurrent(s.standingBackLeft);
            else if (moveRight && moveDown)
                s.setCurrent(s.standingRight);
            else if (moveLeft && moveDown)
                s.setCurrent(s.standingLeft);
            else if (s.current == s.movingForward)
                s.setCurrent(s.standingForward);
            else if (s.current == s.movingLeft)
                s.setCurrent(s.standingLeft);
            else if (s.current == s.movingRight)
                s.setCurrent(s.standingRight);
            else if (s.current == s.movingBack)
                s.setCurrent(s.standingBack);

        }
        collide();
        if (getCollider().intersects(exit) && Enemy.enemies.size() == 0 && Map.levelCounter == 0) {
            wallAbove = true;
            wallUnder = true;
            wallLeft = true;
            moveRight = true;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map.levelCounter++;
            x = 35;
            y = 966;

            EnemyUpdate.addEnemyClass_1();
        }
        if (invincible > 0) invincible--;
        System.out.println(livePoints);

        if (livePoints <= 0) alive = false;

        System.out.println(x+","+y);

    }

    public void damage(int damage) {
        if (invincible == 0 && alive) {
            livePoints -= damage;
            invincible = 100;
            Game.shake = 4;
        }
    }
}
