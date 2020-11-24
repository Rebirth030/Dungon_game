package pack1;

public class Repaint implements Runnable {
    /**
     * The run Method from the interface Runnable, can be executed by an Thread .
     * It will be executed, while the variable running from the class Game is true.
     * <p>
     * The variable timestamp stores the start time from the execution of the run method.
     * The variable oldTimestamp stores the time after the execution of the run method.
     * If the difference between the two time stamps is higher than the maxLoopTime, the following code will also be executed.
     * If this is the case, the Thread tries to run the sleep method for the rest of the time until maxLoopTime is reached.
     * <p>
     * Between the timestamp and oldTimestamp the repaint method of pnl1 from the Gui class gets executed.
     */
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

