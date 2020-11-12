package pack1;


import java.util.Timer;

/**
 * Die Game Klasse, die das Spiel startet.
 * Sie implementiert die Klasse Runnable.
 *
 * @author Julian Martens
 *  *
 *  * @version 1.0
 */


public class Game implements Runnable {

    /**
     * Die Variable FPS, legt die Frames Per Second fest, die erreicht werden sollen. Die FPS werden auf {@value} festgelegt.
     */
    public static final int FPS = 60;


    /**
     * Die maximale Zeit für einen durchgang des Threadswird auf {@value} festgelegt in der Variable maxLoopTime.
     */
    private static final long getMaxLoopTime = 1000 / FPS;
    private static boolean running = true;
    static PlayerOne player;

    @Override
    /**
     * Die run Methode aus der Runnable Klasse, die von einem Thread ausgeführt wird, ruft in der PlayerOne Klasse die "update" Funktion aus.
     *
     * Die Variable oldTimestamp speichert die Startzeit des auszuführenden codes in milisekunden.
     * Die Variable timestamp speichert die Zeit, nachdem die "update" Methode der Klasse PlayerOne, ausgeführt wurde.
     *
     * Wenn die Differenz von oldTimestamp und timestamp, also die zeit, die es braucht die "update" Funktion aus zu führen, größer wird als maxLoopTime, wird die ausführung von "update" abgebrochen.
     */
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

    public static void addEnemyClass_1() {
        Enemy.enemies.add(new Enemy(2000, 300));
        Enemy.enemies.add(new Enemy(2000, 500));
    }

    /**
     * Guckt, wenn vel < min gibt min aus, wenn vel> max gitb max aus sonst gibt vel zurück.
     * guckt quasi das ein rückgabe wert nicht größer als die zwei mitgegebenen werte wird.
     *
     * @param val
     * @param min
     * @param max
     * @return
     */
    public static double constrain(double val, double min, double max) {
        return Math.min(Math.max(val, min), max);
    }

    public static void main(String[] args) {
        InitSpriteAnimation.init();
        Map.createMap();

        player = new PlayerOne();

        Game game = new Game();
        new Thread(game).start();

        addEnemyClass_1();

        Gui.createGui();
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
    public static long getMaxLoopTime() {
        return getMaxLoopTime;
    }

    public static boolean isRunning() {
        return running;
    }

}




/*TODO:
    -Ki / pattern zur Steuerung der Enemys
    -Ausgang nicht mehr links laufen können
 */
