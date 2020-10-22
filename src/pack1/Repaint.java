package pack1;

import java.util.TimerTask;

public class Repaint extends TimerTask {
	@Override
	public void run() {
		Gui.pnl1.repaint();
		//System.out.println("REPAINT");
	}
}

