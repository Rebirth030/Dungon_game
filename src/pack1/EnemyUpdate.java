package pack1;

public class EnemyUpdate implements Runnable {
    private static int waveCounter = 0;

    public static void addEnemyClass_1() {
        if (Enemy.enemies.size() == 0 && waveCounter <=3) {
            for (int i = 0; i <= 6; i++) {
                Enemy.enemies.add(new Enemy(Game.getRandomNumber() * 3840, Game.getRandomNumber() * 2160));
            }
            waveCounter++;
        }
    }

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
}
