package pack1;
/**
 * The EnemyUpdate class has the run method to update the enemies.
 * It implements the interface Runnable.
 *
 * @author Julian Martens
 * *
 * * @version 1.5
 */
public class EnemyUpdate implements Runnable {
    static int waveCounter = 0;

    /**
     * The addEnemyClass_1 method creates enemies of the Enemy class.
     *
     * The method creates 4 times, seven enemies.
     */
    public static void addEnemyClass_1() {
        if (Enemy.enemies.size() == 0 && waveCounter < 4) {
            for (int i = 0; i < 7; i++) {
                Enemy.enemies.add(new Enemy(Game.getRandomNumber() * 3840, Game.getRandomNumber() * 2160, 5 * (Map.levelCounter + 1)));
            }
            waveCounter++;
        }
    }
    /**
     * The run Method from the interface Runnable, can be executed by an Thread .
     * It will be executed, while the variable running from the class Game is true.
     *
     * The variable timestamp stores the start time from the execution of the run method.
     * The variable oldTimestamp stores the time after the execution of the run method.
     * If the difference between the two time stamps is higher than the maxLoopTime, the following code will also be executed.
     * If this is the case, the Thread tries to run the sleep method for the rest of the time until maxLoopTime is reached.
     *
     * Between the timestamp and oldTimestamp the addEnemyClass_1 method gets called and also the update method of every single enemy.
     */
    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (Game.isRunning()) {
            oldTimestamp = System.currentTimeMillis();
            addEnemyClass_1();
            for (int i = 0; i < Enemy.enemies.size(); i++) {
                Enemy.enemies.get(i).update();
            }
            timestamp = System.currentTimeMillis();
            if (timestamp - oldTimestamp > Game.getMaxLoopTime()) {
                continue;
            }
            if (timestamp - oldTimestamp <= Game.getMaxLoopTime()) {
                try {
                    Thread.sleep(Game.getMaxLoopTime() - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Resets the waveCounter to zero.
     */
    public static void resetWaveCounter() {
        waveCounter = 0;
    }
}
