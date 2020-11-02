package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Bullets {
	public double x, y, velX, velY;
	public int width = 40, height = 40;

	public static final double VELOCITY = 8D;

	public Bullets(double x, double y, double velX, double velY) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}

	public void draw(Graphics2D g) {
		try {
			g.drawImage(ImageIO.read(new File("rsc/schuss_player.png")), (int) x, (int) y, width, height, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		x += velX;
		y += velY;

		if (x < 0 || x > LevelOne.mapWidth || y < 0 || y > LevelOne.mapHeight) PlayerOne.bullets.remove(this);

	}
}
