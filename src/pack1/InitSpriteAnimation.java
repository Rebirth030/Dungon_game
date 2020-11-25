package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The InitSpriteAnimation class initiates the animation.
 *
 * @author Julian Martens
 * @version 1.2
 */
public class InitSpriteAnimation {
    /**
     * The Array for the health point Images.
     */
    static Image[] healthImages = new Image[7];
    /**
     * The Image for the GameOver screen.
     */
    static Image gameOver;
    /**
     * The Image for The Icon Image of the game (Task menu).
     */
    private static Image icon;

    /**
     * The method that initialises the Array for the player animation.
     * <p>
     * First the String Array directions stores the 12 Strings that are in the names of the Image pngs (see in rec directory the Images).
     * <p>
     * Next a two dimensional Array, named imageArrays, gets instantiated with the lenght of the directions Array in the first dimension and 4 in the second.
     * <p>
     * Then the image Array gets filled. The first dimension is for the direction the player is moving or standing. The second gets filled with the four belonging Images.
     * The Files are created with ImageIO.read, the pathname for every picture is at first the directory, next the direction from the directions Array and then with a number from one two four and at last with .png.
     * <p>
     * Next the spriteAnimation object gets a new spriteAnimation with the 12 image Array from imageArrays.
     * <p>
     * At last the gameOver variable gets the GameOver Image.
     *
     * @throws IOException
     */
    private static void initPlayerAnimation() throws IOException {
        String[] directions = new String[]{"forward", "left", "right", "back", "backLeft", "BackRight",
                "forwardStanding", "leftStanding", "rightStanding", "backStanding", "backLeftStanding", "BackRightStanding"};

        Image[][] imageArrays = new Image[directions.length][4];

        for (int direction = 0; direction < directions.length; direction++) {
            for (int i = 1; i <= imageArrays[0].length; i++) {
                imageArrays[direction][i - 1] = ImageIO.read(new File("rsc/player/" + directions[direction] + i + ".png"));
            }
        }

        SpriteAnimation.playerAnimation = new SpriteAnimation(
                imageArrays[0],
                imageArrays[1],
                imageArrays[2],
                imageArrays[3],
                imageArrays[4],
                imageArrays[5],
                imageArrays[6],
                imageArrays[7],
                imageArrays[8],
                imageArrays[9],
                imageArrays[10],
                imageArrays[11]
        );
        gameOver = ImageIO.read(new File("rsc/GameOver.png"));
    }

    /**
     * The method initiates the enemy animation (a lot easier than the player animation).
     * <p>
     * First am Image Array gets instantiate named imageArray to and next it gets the 21 Enemy_First Images.
     * Next an imageBoss Array gets the boss Image (momentarily just 1 and not in use because there is no boss yet).
     * <p>
     * The spriteAnimation object enemyAnimation gets the two image Array and gets more if there are more enemies.
     *
     * @throws IOException
     */
    private static void initEnemyAnimation() throws IOException {
        Image[] imageArray = new Image[21];

        for (int i = 1; i <= imageArray.length; i++) {
            imageArray[i - 1] = ImageIO.read(new File("rsc/enemy1/Enemy_first" + i + ".png"));
        }
        Image[] imageBoss = {ImageIO.read(new File("rsc/Enemy_Boss1.png"))};

        SpriteAnimation.enemyAnimation = new SpriteAnimation(
                imageArray,
                imageBoss,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * The init method initialises the other init methods.
     * <p>
     * The method is executed by an try catch method.
     * It also initialises the icon image.
     */
    public static void init() {
        try {
            initPlayerAnimation();
            initEnemyAnimation();
            initHealthAnimation();
            icon = ImageIO.read(new File("rsc/Icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image Error");
        }
    }

    /**
     * The method initialises the health point animation.
     * The healthImages Array gets filled with the lifePoints Images.
     *
     * @throws IOException
     */
    private static void initHealthAnimation() throws IOException {
        int k = 0;
        for (int i = 7; i >= 1; i--) {
            healthImages[k] = ImageIO.read(new File("rsc/player/lifePoints" + i + ".png"));
            k++;
        }

    }

    /**
     * Gets the icon variable.
     *
     * @return the icon Image.
     */
    public static Image getIcon() {
        return icon;
    }
}
