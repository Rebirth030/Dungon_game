package pack1;

import java.util.TimerTask;

public class UpdatePlayer extends TimerTask {
	@Override
	public void run() {
		PlayerOne.update();
	}
}