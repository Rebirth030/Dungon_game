package pack1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InitSpriteAnimation {
    static void init() {
        try {
            movingForward = new Image[]{
                    ImageIO.read(new File("rsc/forward1.png")),
                    ImageIO.read(new File("rsc/forward2.png")),
                    ImageIO.read(new File("rsc/forward3.png")),
                    ImageIO.read(new File("rsc/forward4.png"))

            };
            movingLeft = new Image[]{
                    ImageIO.read(new File("rsc/left1.png")),
                    ImageIO.read(new File("rsc/left2.png")),
                    ImageIO.read(new File("rsc/left3.png")),
                    ImageIO.read(new File("rsc/left4.png"))
            };
            movingRight = new Image[]{
                    ImageIO.read(new File("rsc/right1.png")),
                    ImageIO.read(new File("rsc/right2.png")),
                    ImageIO.read(new File("rsc/right3.png")),
                    ImageIO.read(new File("rsc/right4.png"))
            };
            movingBack = new Image[]{
                    ImageIO.read(new File("rsc/back1.png")),
                    ImageIO.read(new File("rsc/back2.png")),
                    ImageIO.read(new File("rsc/back3.png")),
                    ImageIO.read(new File("rsc/back4.png"))
            };
            movingBackRight = new Image[]{
                    ImageIO.read(new File("rsc/BackRight1.png")),
                    ImageIO.read(new File("rsc/BackRight2.png")),
                    ImageIO.read(new File("rsc/BackRight3.png")),
                    ImageIO.read(new File("rsc/BackRight4.png"))
            };
            movingBackLeft = new Image[]{
                    ImageIO.read(new File("rsc/backLeft1.png")),
                    ImageIO.read(new File("rsc/backLeft2.png")),
                    ImageIO.read(new File("rsc/backLeft3.png")),
                    ImageIO.read(new File("rsc/backLeft4.png"))
            };
            standingLeft = new Image[]{
                    ImageIO.read(new File("rsc/leftStanding1.png")),
                    ImageIO.read(new File("rsc/leftStanding2.png")),
                    ImageIO.read(new File("rsc/leftStanding3.png")),
                    ImageIO.read(new File("rsc/leftStanding4.png"))
            };
            standingForward = new Image[]{
                    ImageIO.read(new File("rsc/forwardStanding1.png")),
                    ImageIO.read(new File("rsc/forwardStanding2.png")),
                    ImageIO.read(new File("rsc/forwardStanding3.png")),
                    ImageIO.read(new File("rsc/forwardStanding4.png"))
            };
            standingRight = new Image[]{
                    ImageIO.read(new File("rsc/rightStanding1.png")),
                    ImageIO.read(new File("rsc/rightStanding2.png")),
                    ImageIO.read(new File("rsc/rightStanding3.png")),
                    ImageIO.read(new File("rsc/rightStanding4.png"))
            };
            standingBack = new Image[]{
                    ImageIO.read(new File("rsc/backStanding1.png")),
                    ImageIO.read(new File("rsc/backStanding2.png")),
                    ImageIO.read(new File("rsc/backStanding3.png")),
                    ImageIO.read(new File("rsc/backStanding4.png"))
            };
            standingBackRight = new Image[]{
                    ImageIO.read(new File("rsc/BackRightStanding1.png")),
                    ImageIO.read(new File("rsc/BackRightStanding2.png")),
                    ImageIO.read(new File("rsc/BackRightStanding3.png")),
                    ImageIO.read(new File("rsc/BackRightStanding4.png"))
            };
            standingBackLeft = new Image[]{
                    ImageIO.read(new File("rsc/backLeftStanding1.png")),
                    ImageIO.read(new File("rsc/backLeftStanding2.png")),
                    ImageIO.read(new File("rsc/backLeftStanding3.png")),
                    ImageIO.read(new File("rsc/backLeftStanding4.png"))
            };
            Enemy_1 = new Image[]{
                    ImageIO.read(new File("rsc/Enemy_first1.png")),
                    ImageIO.read(new File("rsc/Enemy_first2.png")),
                    ImageIO.read(new File("rsc/Enemy_first3.png")),
                    ImageIO.read(new File("rsc/Enemy_first4.png")),
                    ImageIO.read(new File("rsc/Enemy_first5.png")),
                    ImageIO.read(new File("rsc/Enemy_first6.png")),
                    ImageIO.read(new File("rsc/Enemy_first7.png")),
                    ImageIO.read(new File("rsc/Enemy_first8.png")),
                    ImageIO.read(new File("rsc/Enemy_first9.png")),
                    ImageIO.read(new File("rsc/Enemy_first10.png")),
                    ImageIO.read(new File("rsc/Enemy_first11.png")),
                    ImageIO.read(new File("rsc/Enemy_first12.png")),
                    ImageIO.read(new File("rsc/Enemy_first13.png")),
                    ImageIO.read(new File("rsc/Enemy_first14.png"))
            };
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Image Error");
        }


    }
}
