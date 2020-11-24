package pack1;

import java.util.TimerTask;

/**
 * The AnimationThread class just has the run method to update the animation.
 * It extends the TimerTask class.
 *
 * @author Julian Martens
 * @version 1.0
 */
public class AnimationThread extends TimerTask {
    /**
     * The run Method from the class TimerTask, can be executed by an Timer.
     * It will be executed, again in a certain period.
     * <p>
     * Every 300 milliseconds every entity in the entity list gets his updateAnimation method called.
     */

    @Override
    public void run() {
        for (int i = 0; i < Entity.entities.size(); i++) {
            Entity.entities.get(i).updateAnimation();
        }
    }
}
