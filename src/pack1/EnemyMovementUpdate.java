package pack1;

public class EnemyMovementUpdate extends Thread{
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
