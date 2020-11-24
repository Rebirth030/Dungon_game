package pack1;


import java.util.Timer;

/**
 * The Game class starts the game.
 * It implements the interface Runnable.
 *
 * @author Julian Martens
 * *
 * * @version 2.1
 */


public class Game implements Runnable {
    public static final int FPS = 60;

    static int shake = 0;
    static int currentShake = 0;
    private static final long getMaxLoopTime = 1000 / FPS;
    private static boolean running = true;
    static PlayerOne player;

    /**
     * The run Method from the interface Runnable, can be executed by an Thread .
     * It will be executed, while the variable running is true.
     * <p>
     * The variable timestamp stores the start time from the execution of the run method.
     * The variable oldTimestamp stores the time after the execution of the run method.
     * If the difference between the two time stamps is higher than the maxLoopTime, the following code will also be executed.
     * If this is the case, the Thread tries to run the sleep method for the rest of the time until maxLoopTime is reached.
     * <p>
     * Between the timestamp and oldTimestamp the update method from the PlayerOne player is called.
     */
    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (running) {
            oldTimestamp = System.currentTimeMillis();
            player.update();
            timestamp = System.currentTimeMillis();
            if (timestamp - oldTimestamp > getMaxLoopTime) {
                continue;
            }
            if (timestamp - oldTimestamp <= getMaxLoopTime) {
                try {
                    Thread.sleep(getMaxLoopTime - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * The constrain method gets three parameters an looks if the first value is within the min and max parameter.
     *
     * @param val is the value of something.
     * @param min is the number, the value should at least have.
     * @param max is the number, the value something should have maximal.
     * @return the value if its within the range of max and min else it return either max or min.
     */
    public static double constrain(double val, double min, double max) {
        return Math.min(Math.max(val, min), max);
    }

    /**
     * The main method that starts the whole game.
     * <p>
     * At first it executes the init method in InitSpriteAnimation.
     * At second it calls the createMap method from the class Map.
     * At third the method createGui from Gui is called.
     * <p>
     * At next the method generates an object of the class PlayerOne named player.
     * <p>
     * Then another object gets generated from the Game class.
     * A new Thread gets initialized and calls the run method in Game {@link Game #run()}.
     * <p>
     * Then another object gets generated from the Repaint class.
     * A new Thread gets initialized and calls the run method in Repaint {@link Repaint #run()}.
     * <p>
     * Then another object gets generated from the EnemyUpdate class.
     * A new Thread gets initialized and calls the run method in EnemyUpdate {@link EnemyUpdate #run()}.
     * <p>
     * Then another object gets generated from the EnemyMovementUpdate class.
     * A new Thread gets initialized and calls the run method in EnemyMovementUpdate {@link EnemyMovementUpdate #run()}.
     * <p>
     * The KeyHandler class gets initialized.
     * <p>
     * Then another object gets generated from the Timer class.
     * A new Thread gets initialized and calls the run method in AnimationThread every 300 milliseconds {@link AnimationThread #run()}.
     *
     * @param args
     */

    public static void main(String[] args) {
        InitSpriteAnimation.init();
        Map.createMap();
        Gui.createGui();

        player = new PlayerOne();

        Game game = new Game();
        new Thread(game).start();


        Repaint render = new Repaint();
        new Thread(render).start();

        EnemyUpdate update = new EnemyUpdate();
        new Thread(update).start();

        EnemyMovementUpdate updateMovement = new EnemyMovementUpdate();
        new Thread(updateMovement).start();

        new KeyHandler();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AnimationThread(), 0, 300);
    }

    /**
     * Passes the value of maxLoopTime along.
     *
     * @return the value of maxLoopTime.
     */
    public static long getMaxLoopTime() {
        return getMaxLoopTime;
    }

    /**
     * Passes the value of isRunning along.
     *
     * @return the boolean value of running.
     */
    public static boolean isRunning() {
        return running;
    }

    /**
     * Gets a random number.
     *
     * @return a random number of the Math class.
     */
    public static double getRandomNumber() {
        return Math.random();
    }

}
