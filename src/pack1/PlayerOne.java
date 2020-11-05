package pack1;

public class PlayerOne extends Entity{

	public PlayerOne() {
		this(564, 782);
	}

	public PlayerOne(double x, double y) {
		super(x, y);
		livePoints = 5;
	}

	//movement mit acc also rundere bewegungen nicht sofort stehen
	@Override
	public void update() {
		System.out.println(x+";"+y);
		if (KeyHandler.wallAbove) {
			KeyHandler.moveUp = false;
			if (velY < 0) velY = 0;
		} else if (KeyHandler.wallUnder) {
			KeyHandler.moveDown = false;
			if (velY > 0) velY = 0;
		} else if (KeyHandler.wallLeft) {
			KeyHandler.moveLeft = false;
			if (velX < 0) velX = 0;
		} else if (KeyHandler.wallRight) {
			KeyHandler.moveRight = false;
			if (velX > 0) velX = 0;
		}


		if (KeyHandler.moveRight && KeyHandler.moveUp) SpriteAnimation.setCurrent(SpriteAnimation.movingBackRight);
		else if (KeyHandler.moveLeft && KeyHandler.moveUp) SpriteAnimation.setCurrent(SpriteAnimation.movingBackLeft);
		else if (KeyHandler.moveDown) SpriteAnimation.setCurrent(SpriteAnimation.movingForward);
		else if (KeyHandler.moveUp) SpriteAnimation.setCurrent(SpriteAnimation.movingBack);
		else if (KeyHandler.moveRight) SpriteAnimation.setCurrent(SpriteAnimation.movingRight);
		else if (KeyHandler.moveLeft) SpriteAnimation.setCurrent(SpriteAnimation.movingLeft);

		super.update();

		if (velX == 0 && velY == 0) {
			if (SpriteAnimation.current == SpriteAnimation.movingBackRight) {
				SpriteAnimation.setCurrent(SpriteAnimation.standingBackRight);
			} else if (SpriteAnimation.current == SpriteAnimation.movingBackLeft) {
				SpriteAnimation.setCurrent(SpriteAnimation.standingBackLeft);
			} else if (SpriteAnimation.current == SpriteAnimation.movingForward) {
				SpriteAnimation.setCurrent(SpriteAnimation.standingForward);
			} else if (SpriteAnimation.current == SpriteAnimation.movingLeft) {
				SpriteAnimation.setCurrent(SpriteAnimation.standingLeft);
			} else if (SpriteAnimation.current == SpriteAnimation.movingRight) {
				SpriteAnimation.setCurrent(SpriteAnimation.standingRight);
			} else if (SpriteAnimation.current == SpriteAnimation.movingBack) {
				SpriteAnimation.setCurrent(SpriteAnimation.standingBack);
			}
		}
		Collider.PlayerWallCollider();
	}
	public static void createPlayerOne() {
		SpriteAnimation.init();
	}
}
