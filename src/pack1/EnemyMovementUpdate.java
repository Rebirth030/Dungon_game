package pack1;
/**
 * The EnemyMovementUpdate class just has the run method to update the movement of the enemies.
 * It implements the interface Runnable.
 *
 * @author Julian Martens
 * *
 * * @version 1.0
 */
public class EnemyMovementUpdate implements Runnable{
    /**
     * The run Method from the interface Runnable, can be executed by an Thread .
     * It will be executed, while the variable running from the class Game is true.
     *
     * The variable timestamp stores the start time from the execution of the run method.
     * The variable oldTimestamp stores the time after the execution of the run method.
     * If the difference between the two time stamps is higher than the maxLoopTime, the following code will also be executed.
     * If this is the case, the Thread tries to run the sleep method for the rest of the time until maxLoopTime is reached.
     *
     * Between the timestamp and oldTimestamp the movement method of every single enemy is called.
     */
    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (Game.isRunning()) {
            oldTimestamp = System.currentTimeMillis();
            for (int i = 0; i < Enemy.enemies.size(); i++) {
                Enemy.enemies.get(i).movement();
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
}
