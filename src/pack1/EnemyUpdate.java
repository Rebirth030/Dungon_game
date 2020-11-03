package pack1;

public class EnemyUpdate implements Runnable {

    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (Game.running) {
            oldTimestamp = System.currentTimeMillis();
            for (int i = 0; i < EnemyClass_1.enemysClass_1.size(); i++) EnemyClass_1.enemysClass_1.get(i).updateEnemy_1();
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
