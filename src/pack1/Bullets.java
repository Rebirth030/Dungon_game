package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bullets {
	public double x, y, velX, velY;
	public int width = 40, height = 40;
	public Entity parent;
	public static final double VELOCITY = 10D;

	public static Image bullet;

	static {
		try {
			bullet = ImageIO.read(new File("rsc/player/schuss_player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Bullets(Entity parent, double x, double y, double velX, double velY) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}


	public void draw(Graphics2D g) {
		g.drawImage(bullet, (int) x, (int) y, width, height, null);
	}

	public void update() {
		x += velX;
		y += velY;

		if (x < 35 || x > Map.mapWidth - 155 || y < 100 || y > Map.mapHeight - 80) {
			parent.bullets.remove(this);
		}
		Rectangle bullet = new Rectangle((int) x, (int) y, width, height);
		for (int i = 0; i < Entity.entities.size(); i++) {
			if(Entity.entities.get(i) == this.parent) continue;
			if (bullet.intersects(Entity.entities.get(i).getCollider())) {
				Entity.entities.get(i).hit();
				parent.bullets.remove(this);
			}
		}

	}
}
