package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InitSpriteAnimation {
    static Image[] healthImages = new Image[7];
    static Image GameOver;
    private static Image icon;

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
        try {
            GameOver = ImageIO.read(new File("rsc/GameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("GameOver could not be drawn");
        }
    }

    private static void initEnemyAnimation() throws IOException {
        Image[] imageArrays = new Image[21];

        for (int i = 1; i <= imageArrays.length; i++) {
            imageArrays[i - 1] = ImageIO.read(new File("rsc/enemy1/Enemy_first" + i + ".png"));
        }
        Image[] imageBoss = { ImageIO.read(new File("rsc/Enemy_Boss1.png"))};

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
