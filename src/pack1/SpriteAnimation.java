package pack1;

import java.awt.*;


public class SpriteAnimation {

	public static SpriteAnimation playerAnimation;
	public static SpriteAnimation enemyAnimation;

	public int counter = 0;

	public Image[] current;

	public Image[] movingForward;
	public Image[] movingLeft;
	public Image[] movingRight;
	public Image[] movingBack;
	public Image[] movingBackRight;
	public Image[] movingBackLeft;

	public Image[] standingLeft;
	public Image[] standingForward;
	public Image[] standingRight;
	public Image[] standingBack;
	public Image[] standingBackRight;
	public Image[] standingBackLeft;

	public SpriteAnimation(Image[] movingForward, Image[] movingLeft, Image[] movingRight, Image[] movingBack, Image[] movingBackLeft, Image[] movingBackRight, Image[] standingForward, Image[] standingLeft, Image[] standingRight, Image[] standingBack, Image[] standingBackLeft, Image[] standingBackRight) {
		this.movingForward = movingForward;
		this.movingLeft = movingLeft;
		this.movingRight = movingRight;
		this.movingBack = movingBack;
		this.movingBackLeft = movingBackLeft;
		this.movingBackRight = movingBackRight;
		this.standingForward = standingForward;
		this.standingLeft = standingLeft;
		this.standingRight = standingRight;
		this.standingBack = standingBack;
		this.standingBackLeft = standingBackLeft;
		this.standingBackRight = standingBackRight;
	}

	public void setCurrent(Image[] newCurrent) {
		if (current == newCurrent) return;
		if (newCurrent == null) return;
		current = newCurrent;
		counter = 0;
	}

	public Image getCurrent() {
		return current[counter];
	}

	public void update() {
		counter++;
		counter %= current.length;
	}
}


