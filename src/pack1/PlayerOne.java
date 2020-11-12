package pack1;

public class PlayerOne extends Entity {

	public PlayerOne() {
		this(564, 782);
	}

	public PlayerOne(double x, double y) {
		super(SpriteAnimation.playerAnimation, x, y);
		livePoints = 5;

		spriteAnimation.setCurrent(spriteAnimation.standingRight);
	}

	@Override
	public void addBullet(int x, int y) {
		double entityX = this.x;
		double entityY = this.y;


		double offX = (x - Panel.getOffX()) - entityX;
		double offY = (y - Panel.getOffY()) - entityY;

		double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

		offX /= distance;
		offY /= distance;

		offX *= Bullets.VELOCITY;
		offY *= Bullets.VELOCITY;

		bullets.add(new Bullets(this, entityX, entityY, offX, offY));
	}

	//movement mit acc also rundere bewegungen nicht sofort stehen
	@Override
	public void update() {
		super.update();

		if (wallAbove) {
			moveUp = false;
			if (velY < 0) velY = 0;
		} else if (wallUnder) {
			moveDown = false;
			if (velY > 0) velY = 0;
		} else if (wallLeft) {
			moveLeft = false;
			if (velX < 0) velX = 0;
		} else if (wallRight) {
			moveRight = false;
			if (velX > 0) velX = 0;
		}


		if (moveRight && moveUp) spriteAnimation.setCurrent(spriteAnimation.movingBackRight);
		else if (moveLeft && moveUp) spriteAnimation.setCurrent(spriteAnimation.movingBackLeft);
		else if (moveDown) spriteAnimation.setCurrent(spriteAnimation.movingForward);
		else if (moveUp) spriteAnimation.setCurrent(spriteAnimation.movingBack);
		else if (moveRight) spriteAnimation.setCurrent(spriteAnimation.movingRight);
		else if (moveLeft) spriteAnimation.setCurrent(spriteAnimation.movingLeft);


		if (velX == 0 && velY == 0) {
			if (spriteAnimation.current == spriteAnimation.movingBackRight) {
				spriteAnimation.setCurrent(spriteAnimation.standingBackRight);
			} else if (spriteAnimation.current == spriteAnimation.movingBackLeft) {
				spriteAnimation.setCurrent(spriteAnimation.standingBackLeft);
			} else if (spriteAnimation.current == spriteAnimation.movingForward) {
				spriteAnimation.setCurrent(spriteAnimation.standingForward);
			} else if (spriteAnimation.current == spriteAnimation.movingLeft) {
				spriteAnimation.setCurrent(spriteAnimation.standingLeft);
			} else if (spriteAnimation.current == spriteAnimation.movingRight) {
				spriteAnimation.setCurrent(spriteAnimation.standingRight);
			} else if (spriteAnimation.current == spriteAnimation.movingBack) {
				spriteAnimation.setCurrent(spriteAnimation.standingBack);
			}
		}
		collide();
		if (getCollider().intersects(Collider.exit) && Map.enemyCounter == 0 && Map.levelCounter == 0) {
			wallAbove = true;
			wallUnder = true;
			wallLeft = true;
			moveRight = true;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Map.levelCounter = 1;
				//Game.player.PlayerOne(0,0); // 0,0 nur testweise
			}

		}

	}
}
