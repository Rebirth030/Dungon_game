package pack1;

public class Repaint implements Runnable {
    @Override
    public void run() {
        long timestamp_render;
        long oldTimestamp_render;
        while (Game.isRunning()) {
            oldTimestamp_render = System.currentTimeMillis();
            Gui.pnl1.repaint();
            timestamp_render = System.currentTimeMillis();
            if (timestamp_render - oldTimestamp_render <= Game.getMaxLoopTime()) {
                try {
                    Thread.sleep(Game.getMaxLoopTime() - (timestamp_render - oldTimestamp_render));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

