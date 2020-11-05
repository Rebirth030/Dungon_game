package pack1;

import java.awt.*;


public class SpriteAnimation {

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

    public Image[] Enemy_1;

    public SpriteAnimation(Image[] movingForward, Image[] movingLeft, Image[] movingRight, Image[] movingBack, Image[] movingBackRight, Image[] movingBackLeft, Image[] standingLeft, Image[] standingForward, Image[] standingRight, Image[] standingBack, Image[] standingBackRight, Image[] standingBackLeft) {
        this.movingForward = movingForward;
        this.movingLeft = movingLeft;
        this.movingRight = movingRight;
        this.movingBack = movingBack;
        this.movingBackRight = movingBackRight;
        this.movingBackLeft = movingBackLeft;
        this.standingLeft = standingLeft;
        this.standingForward = standingForward;
        this.standingRight = standingRight;
        this.standingBack = standingBack;
        this.standingBackRight = standingBackRight;
        this.standingBackLeft = standingBackLeft;
    }

    public void setCurrent(Image[] newCurrent) {
        if (current == newCurrent) return;
        current = newCurrent;
        counter = 0;
    }

    public Image getCurrent() {
        return current[counter];
    }


    public Image getEnemy_1() {
        return Enemy_1[enemy_1Counter];
    }
}


