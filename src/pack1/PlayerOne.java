package pack1;

public class PlayerOne extends Entity{

	public PlayerOne() {
		this(564, 782);
	}

	public PlayerOne(double x, double y) {
		super(SpriteAnimation.playerAnimation, x, y);
		livePoints = 5;

		spriteAnimation.setCurrent(spriteAnimation.standingRight);
	}

	//movement mit acc also rundere bewegungen nicht sofort stehen
	@Override
	public void update() {
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

		super.update();

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
		Collider.PlayerWallCollider();
	}
}
