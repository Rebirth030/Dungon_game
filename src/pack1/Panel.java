package pack1;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

	public static double offX = 0D;
	public static double offY = 0D;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		offX = -PlayerOne.getX();
		offY = -PlayerOne.getY();

		offX = Game.constrain(offX, -LevelOne.mapWidth + Gui.jf.getWidth() / 2d, -(Gui.jf.getWidth() / 2d));
		offY = Game.constrain(offY, -LevelOne.mapHeight + Gui.jf.getHeight() / 2d, -(Gui.jf.getHeight() / 2d));

		offX += Gui.jf.getWidth() / 2d;
		offY += Gui.jf.getHeight() / 2d;

		g2d.translate(offX, offY);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		g.drawImage(LevelOne.back1, 0, 0, LevelOne.mapWidth, LevelOne.mapHeight, null);
		Game.player.showPlayer(g);
		for (int i = 0; i < EnemyClass_1.enemysClass_1.size(); i++) EnemyClass_1.enemysClass_1.get(i).showEnemy_1(g);

		//g.fillRect(Collider.exit.x, Collider.exit.y, Collider.exit.width, Collider.exit.height);


	}
}






