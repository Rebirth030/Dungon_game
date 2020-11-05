package pack1;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends Entity {
	public static ArrayList<Enemy> enemies = new ArrayList<>();

	public Enemy(double x, double y) {
		super(SpriteAnimation.enemyAnimation, x, y);
		livePoints = 8;

		spriteAnimation.setCurrent(spriteAnimation.movingForward);
	}
}
