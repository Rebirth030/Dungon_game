package pack1;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity {

	protected double velX, velY, accX, accY, x, y;
	private static final double speed = 3;
	protected int width = 100;
	protected int height = 175;
	protected boolean moveUp = false, moveDown = false, moveRight = false, moveLeft = false, wallAbove = false, wallUnder = false, wallLeft = false, wallRight = false;
	protected boolean alive;
	protected int livePoints;
	protected SpriteAnimation spriteAnimation;

	protected static ArrayList<Entity> entities = new ArrayList<>();
	protected ArrayList<Bullets> bullets = new ArrayList<>();


	public Entity(SpriteAnimation spriteAnimation, double x, double y) {
		this.spriteAnimation = spriteAnimation;
		this.x = x;
		this.y = y;
		velX = 0;
		velY = 0;
		accX = 0;
		accY = 0;
		alive = true;
		livePoints = 8;

		entities.add(this);
	}

	public void hit() {
		livePoints--;
		/*Panel.setOffX(Panel.getOffX() +2000);
		Panel.setOffY(Panel.getOffX() -2000);*/
	}

	public void addBullet(int x, int y) {
		double entityX = this.x;
		double entityY = this.y;


		double offX = (x - Panel.getOffX()) - entityX;
		double offY = (y - Panel.getOffX()) - entityY;

		double distance = Math.sqrt(Math.pow(Math.abs(offX), 2D) + Math.pow(Math.abs(offY), 2D));

		offX /= distance;
		offY /= distance;

		offX *= Bullets.VELOCITY;
		offY *= Bullets.VELOCITY;

		bullets.add(new Bullets(this, entityX, entityY, offX, offY));
	}

	public void update() {
		for (int i = 0; i < bullets.size(); i++) bullets.get(i).update();


		accX = (moveLeft ? -speed : (moveRight ? speed : 0)) / 5f;
		accY = (moveUp ? -speed : (moveDown ? speed : 0)) / 5f;
		velX += accX;
		velY += accY;
		velX *= 0.9;
		velY *= 0.9;

		accX = 0;
		accY = 0;
		if (Math.abs(velX) <= 0.1) {
			velX = 0;
		}
		if (Math.abs(velY) <= 0.1) {
			velY = 0;
		}

		collide();

		x = Game.constrain(x + ((velX != 0 && velY != 0) ? velX / Math.sqrt(2) : velX), 0, Map.mapWidth);
		y = Game.constrain(y + ((velX != 0 && velY != 0) ? velY / Math.sqrt(2) : velY), 0, Map.mapHeight);

	}

	public Rectangle getCollider() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public void show(Graphics g) {
		if (spriteAnimation != null)
			g.drawImage(spriteAnimation.getCurrent(), (int) x, (int) y, width, height, null);
		else {
			g.setColor(Color.WHITE);
			g.fillRect((int) x, (int) y, width, height);
		}
		for (int i = 0; i < bullets.size(); i++) bullets.get(i).draw((Graphics2D) g);
	}

	public void updateAnimation() {
		if (spriteAnimation != null)
			spriteAnimation.update();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void collide() {
		Rectangle entityCollider = getCollider();
		wallAbove = entityCollider.intersects(Collider.wall1);
		wallUnder = entityCollider.intersects(Collider.wall2);
		wallLeft = entityCollider.intersects(Collider.wall3);
		wallRight = entityCollider.intersects(Collider.wall4) || entityCollider.intersects(Collider.wall5);

		if (wallAbove) {
			if (velY < 0) velY = 0;
		} else if (wallUnder) {
			if (velY > 0) velY = 0;
		} else if (wallLeft) {
			if (velX < 0) velX = 0;
		} else if (wallRight) {
			if (velX > 0) velX = 0;
		}
	}
}



