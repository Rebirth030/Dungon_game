package pack1;


import java.util.Timer;

public class Game implements Runnable {

    public static final int FPS = 60;
    public static final long maxLoopTime = 1000 / FPS;
    public static PlayerOne player;
    public static boolean running = true;
    public static EnemyClass_1 enemy_1;

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
            if (timestamp - oldTimestamp <= maxLoopTime) {
                try {
                    Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void addEnemyClass_1() {
        EnemyClass_1.enemysClass_1.add(new EnemyClass_1(2000,300));
        EnemyClass_1.enemysClass_1.add(new EnemyClass_1(2000,500));
    }

    public static double constrain(double val, double min, double max) {
        return Math.min(Math.max(val, min), max);
    }

    public static void main(String[] args) {

        Game game = new Game();
        new Thread(game).start();

        player = new PlayerOne();
        PlayerOne.createPlayerOne();
        addEnemyClass_1();

        SpriteAnimation.setCurrent(SpriteAnimation.standingRight);

        Gui.createGui();
        Repaint render = new Repaint();
        new Thread(render).start();
        LevelOne.createLevelOne();
        new KeyHandler();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new AnimationThread(), 0, 1);
    }

}




/*TODO:
    -Ki / pattern zur Steuerung der Enemys
    -Kugeln/schuüße
    -Ausgang nicht mehr links laufen können
    -Maps

 */