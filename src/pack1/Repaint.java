package pack1;

public class Repaint implements Runnable{
    @Override
    public void run() {
        long timestamp_render;
        long oldTimestamp_render;
        while (Game.running) {
            oldTimestamp_render = System.currentTimeMillis();
            Gui.pnl1.repaint();
            timestamp_render = System.currentTimeMillis();
            if (timestamp_render - oldTimestamp_render <= Game.maxLoopTime) {
                try {
                    Thread.sleep(Game.maxLoopTime - (timestamp_render - oldTimestamp_render));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

