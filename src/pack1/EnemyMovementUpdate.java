package pack1;

public class EnemyMovementUpdate implements Runnable{
    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (Game.running) {
            oldTimestamp = System.currentTimeMillis();
            for (int i = 0; i < Enemy.enemies.size(); i++) {
                Enemy.enemies.get(i).movement();
            }
            timestamp = System.currentTimeMillis();
            if (timestamp - oldTimestamp > Game.maxLoopTime) {
                continue;
            }
            if (timestamp - oldTimestamp <= Game.maxLoopTime) {
                try {
                    Thread.sleep(Game.maxLoopTime - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
