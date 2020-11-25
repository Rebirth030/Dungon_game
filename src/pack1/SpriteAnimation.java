package pack1;

import java.awt.*;

/**
 * The SpriteAnimation class stores the animation.
 *
 * @author Julian Martens
 * @version 1.2
 */
public class SpriteAnimation {
    /**
     * creates an SpriteAnimation object called playerAnimation.
     */
    public static SpriteAnimation playerAnimation;
    /**
     * creates an SpriteAnimation object called enemyAnimation.
     */
    public static SpriteAnimation enemyAnimation;
    /**
     * A counter for the Animations.
     */
    private int counter = 0;
    /**
     * An Array with the current Animations.
     */
    public Image[] current;

    /**
     * An Array for the Animation movingForward.
     */
    public Image[] movingForward;
    /**
     * An Array for the Animation movingLeft.
     */
    public Image[] movingLeft;
    /**
     * An Array for the Animation movingRight.
     */
    public Image[] movingRight;
    /**
     * An Array for the Animation movingBack.
     */
    public Image[] movingBack;
    /**
     * An Array for the Animation movingBackRight.
     */
    public Image[] movingBackRight;
    /**
     * An Array for the Animation movingBackLeft.
     */
    public Image[] movingBackLeft;
    /**
     * An Array for the Animation standingLeft.
     */
    public Image[] standingLeft;
    /**
     * An Array for the Animation standingForward.
     */
    public Image[] standingForward;
    /**
     * An Array for the Animation standingRight.
     */
    public Image[] standingRight;
    /**
     * An Array for the Animation standingBack.
     */
    public Image[] standingBack;
    /**
     * An Array for the Animation standingBackRight.
     */
    public Image[] standingBackRight;
    /**
     * An Array for the Animation standingBackLeft.
     */
    public Image[] standingBackLeft;


    /**
     * The constructor for the SpriteAnimation objects
     *
     * @param movingForward     gets Animation Arrays.
     * @param movingLeft        gets Animation Arrays.
     * @param movingRight       gets Animation Arrays.
     * @param movingBack        gets Animation Arrays.
     * @param movingBackLeft    gets Animation Arrays.
     * @param movingBackRight   gets Animation Arrays.
     * @param standingForward   gets Animation Arrays.
     * @param standingLeft      gets Animation Arrays.
     * @param standingRight     gets Animation Arrays.
     * @param standingBack      gets Animation Arrays.
     * @param standingBackLeft  gets Animation Arrays.
     * @param standingBackRight gets Animation Arrays.
     */
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

    /**
     * Sets the current animation.
     * <p>
     * If the newCurrent animation Array is the current it will return,
     * the same if newCurrent is null.
     * Else current will be set newCurrent and the counter to zero.
     *
     * @param newCurrent gets the current animation Array.
     */
    public void setCurrent(Image[] newCurrent) {
        if (current == newCurrent) return;
        if (newCurrent == null) return;
        current = newCurrent;
        counter = 0;
    }

    /**
     * Gets the current image out of the current Array with the counter method.
     * with counter %= current.length the counter cant be greater than four more explicit than the length of the current Array.
     *
     * @return the current animation image.
     */
    public Image getCurrent() {
        counter %= current.length;
        return current[counter];
    }

    /**
     * Updates the counter by setting it +1.
     * with counter %= current.length the counter cant be greater than four more explicit than the length of the current Array.
     */
    public void update() {
        counter++;
        counter %= current.length;
    }
}


