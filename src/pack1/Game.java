package pack1;


import java.util.Timer;
import java.util.TimerTask;

public class Game extends TimerTask implements Runnable {

    public static final int FPS = 60;
    public static final long maxLoopTime = 1000 / FPS;
    public static PlayerOne player;
    public static boolean running = true;
    public static Panel paint = new Panel();

    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (running) {
            oldTimestamp = System.currentTimeMillis();
            PlayerOne.update();
            timestamp = System.currentTimeMillis();
            if (timestamp - oldTimestamp > maxLoopTime) {
                continue;
            }
            System.out.println(maxLoopTime + " : " + (timestamp - oldTimestamp));
            if (timestamp - oldTimestamp <= maxLoopTime) {
                try {
                    Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   /* public static void Timer() {
        Timer myTimer = new Timer();
        myTimer.scheduleAtFixedRate(new Repaint(),0,1000 / FPS);
    }
*/



    public static double constrain(double val, double min, double max) {
        return Math.min(Math.max(val, min), max);
    }

    public static void main(String[] args) {

        Game game = new Game();
        new Thread(game).start();

        Repaint render = new Repaint();
        new Thread(render).start();

        player = new PlayerOne();

        Gui.createGui();
        LevelOne.createLevelOne();
        PlayerOne.createPlayerOne();
        new KeyHandler();


    }

}




/*TODO:
    -rectangle für collision detection
    -acceleration (siehe update funktion)
 */