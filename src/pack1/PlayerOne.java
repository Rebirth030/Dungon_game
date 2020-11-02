package pack1;

import java.awt.*;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class PlayerOne {

	private static double velX, velY, accX, accY;
	private static double x, y;
	static double speed = 3;
	static int playerWidth = 100;
	static int playerHeight = 175;
	static boolean alive;
	static int livePoints;

	public static ArrayList<Bullets> bullets = new ArrayList<>();

	public PlayerOne() {
		this(3000, 1800);
	}

	public PlayerOne(double x, double y) {
		PlayerOne.x = x;
		PlayerOne.y = y;
		velX = 0;
		velY = 0;
		accX = 0;
		accY = 0;
		alive = true;
		livePoints = 4;
	}

	public static void addBullet(int x, int y) {
		double playerX = PlayerOne.x + PlayerOne.playerWidth;
		double playerY = PlayerOne.y + PlayerOne.playerHeight / 2D;


		double offX = (x - Panel.offX) - playerX;
		double offY = (y - Panel.offY) - playerY;

		//System.out.println(offX + " : " + offY);

		double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

		offX /= distance;
		offY /= distance;

		offX *= Bullets.VELOCITY;
		offY *= Bullets.VELOCITY;

		PlayerOne.bullets.add(new Bullets(playerX, playerY, offX, offY));
	}

	//movement mit acc also rundere bewegungen nicht sofort stehen
	public static void update() {
		for (Bullets b : bullets) b.update();

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

		accX = (KeyHandler.moveLeft ? -speed : (KeyHandler.moveRight ? speed : 0)) / 5f;
		accY = (KeyHandler.moveUp ? -speed : (KeyHandler.moveDown ? speed : 0)) / 5f;
		velX += accX;
		velY += accY;
		velX *= 0.9;
		velY *= 0.9;
		if (Math.abs(velX) <= 0.1) {
			velX = 0;
		}
		if (Math.abs(velY) <= 0.1) {
			velY = 0;
		}
		x = Game.constrain(x + ((velX != 0 && velY != 0) ? velX / Math.sqrt(2) : velX), 0, LevelOne.mapWidth);
		y = Game.constrain(y + ((velX != 0 && velY != 0) ? velY / Math.sqrt(2) : velY), 0, LevelOne.mapHeight);
		accX = 0;
		accY = 0;

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

	public void showPlayer(Graphics g) {
		g.drawImage(SpriteAnimation.getCurrent(), (int) x, (int) y, playerWidth, playerHeight, null);
		for (Bullets b : bullets) b.draw((Graphics2D) g);
	}

	public static double getVelX() {
		return velX;
	}


	public static double getVelY() {
		return velY;
	}

	public static double getX() {
		return x;
	}

	public static double getY() {
		return y;
	}

	public double getAccX() {
		return accX;
	}

	public double getAccY() {
		return accY;
	}

	public static void createPlayerOne() {
		SpriteAnimation.init();
	}
}
