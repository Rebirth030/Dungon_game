package pack1;


import java.util.Timer;
import java.util.TimerTask;

public class Game {

	public static final int FPS = 60;
	public static final long maxLoopTime = 1000 / FPS;
	public static PlayerOne player;
	//public static Panel paint = new Panel();

   /* public static void Timer() {
        Timer myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new Repaint(),0,1000 / FPS);
    }
*/


	public static double constrain(double val, double min, double max) {
		return Math.min(Math.max(val, min), max);
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new UpdatePlayer(), 0, 1000 / 60);

		player = new PlayerOne();

		Gui.createGui();
		timer.scheduleAtFixedRate(new Repaint(), 0, 1000 / 60);
		LevelOne.createLevelOne();
		PlayerOne.createPlayerOne();
		new KeyHandler();


	}

}




/*TODO:
    -rectangle für collision detection
    -acceleration (siehe update funktion)
 */