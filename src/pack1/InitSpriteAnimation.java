package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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
     *
     * @throws IOException
     */
    private static void initEnemyAnimation() throws IOException {
        Image[] imageArrays = new Image[21];

        for (int i = 1; i <= imageArrays.length; i++) {
            imageArrays[i - 1] = ImageIO.read(new File("rsc/enemy1/Enemy_first" + i + ".png"));
        }
        Image[] imageBoss = {ImageIO.read(new File("rsc/Enemy_Boss1.png"))};

        SpriteAnimation.enemyAnimation = new SpriteAnimation(
                imageArrays,
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

    private static void initHealthAnimation() throws IOException {
        int k = 0;
        for (int i = 7; i >= 1; i--) {
            healthImages[k] = ImageIO.read(new File("rsc/player/lifePoints" + i + ".png"));
            k++;
        }

    }

    public static Image getIcon() {
        return icon;
    }
}
