package pack1;

/**
 * The PlayerOne class is the class where the player gets instantiated from.
 * It extends entity.
 *
 * @author Julian Martens
 * @version 1.5
 */
public class PlayerOne extends Entity {
    /**
     * The variable invincible is set to zero.
     */
    int invincible = 0;
    //public static EnemyBoss boss;

    /**
     * Creates a PlayerOne object with the parameters you see there.
     */
    public PlayerOne() {
        this(564, 782);
    }

    /**
     * The constructor for the PlayerOne class.
     * <p>
     * First calls the super constructor.
     * Next it sets the livePoints to 6.
     * And sets the current spriteAnimation to standing right.
     *
     * @param x gets the x spawn point.
     * @param y gets the y spawn point.
     */
    public PlayerOne(double x, double y) {
        super(SpriteAnimation.playerAnimation, x, y);
        livePoints = 6;

        spriteAnimation.setCurrent(spriteAnimation.standingRight);
    }

    /**
     * Overrides the addBullet method.
     * <p>
     * Initialises entityX and entityY with the x and y variables from the object that called the method plus the x added with width - width divided by 8 and y added with height divided by 2.
     * And also offX with x- the Bullet width divided by 2 and minus the return value off getOffX from the Panel class, - the entityX value.
     * Then offY with y- the Bullet height divided by 2 and minus the return value off getOffY from the Panel class, - the entityY value.
     * <p>
     * Next the distance variable gets instantiated using the Pythagoras theorem with offX and offY.
     * <p>
     * The offX and offY gets divided with th distance and next multiplied with the variable VELOCITY from Bullets each one.
     * <p>
     * At least the bullets gets added the the bullets ArrayList with the shooter stored as parent, with entityX, entityY, offX and offY.
     *
     * @param x gets the x coordinate of the click.
     * @param y gets the y coordinate of the click.
     */
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

    /**
     * Overrides the super update method.
     * <p>
     * Sets spriteAnimation s to spriteAnimation.
     * Next calls the super update method.
     * Also sets the belonging move variable false, if there is a wall.
     * <p>
     * At next the animation gets set for the moving direction.
     * And also if the velX and velY is zero the belonging standing animation gets called.
     * <p>
     * Next the collide method gets called.
     * Then if the enemies are dead and all waves are cleared the intersecting with the exit rectangle it will set the next Map, resets the spawn point and resets the waveCounter.
     * <p>
     * Also subtracts one from the invincible counter if its greater than zero.
     * And sets the alive variable false if the lifePoints get zero.
     */
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
        if (getCollider().intersects(exit) && Enemy.enemies.size() == 0 && Map.levelCounter <= 1) {
            wallAbove = true;
            wallUnder = true;
            wallLeft = true;
            moveRight = true;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EnemyUpdate.resetWaveCounter();
            //boss = new EnemyBoss(Game.getRandomNumber() * 3840, Game.getRandomNumber() * 2160);

        }
        if (invincible > 0) invincible--;

        if (livePoints <= 0) alive = false;

        //System.out.println(Enemy.enemies.size()+","+EnemyUpdate.waveCounter);

    }

    /**
     * Deals damage to the player if invincible is zero and activates the shake.
     *
     * @param damage gets how much damage gets dealt to the player.
     */
    public void damage(int damage) {
        if (invincible == 0 && alive) {
            livePoints -= damage;
            invincible = 100;
            Game.shake = 4;
        }
    }
}
