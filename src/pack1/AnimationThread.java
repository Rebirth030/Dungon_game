package pack1;

import java.util.TimerTask;

public class AnimationThread extends TimerTask {
	@Override
	public void run() {
		for (int i = 0; i < Entity.entities.size(); i++) {
			Entity.entities.get(i).updateAnimation();
		}
	}
}
