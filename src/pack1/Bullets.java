package pack1;

import java.awt.*;

public class Bullets {
	public double x, y, velX, velY;
	public int width = 10, height = 10;

	public static final double VELOCITY = 5D;

	public Bullets(double x, double y, double velX, double velY) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawRect((int) x, (int) y, width, height);
	}

	public void update() {
		x += velX;
		y += velY;
	}
}
