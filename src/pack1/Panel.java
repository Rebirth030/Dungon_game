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

		offX = -Game.player.x;
		offY = -Game.player.y;

		offX = Game.constrain(offX, -Map.mapWidth + Gui.jf.getWidth() / 2d, -(Gui.jf.getWidth() / 2d));
		offY = Game.constrain(offY, -Map.mapHeight + Gui.jf.getHeight() / 2d, -(Gui.jf.getHeight() / 2d));

		offX += Gui.jf.getWidth() / 2d;
		offY += Gui.jf.getHeight() / 2d;

		g2d.translate(offX, offY);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		g.drawImage(Map.getMap(), 0, 0, Map.mapWidth, Map.mapHeight, null);
		Game.player.show(g);
		for (int i = 0; i < Enemy.enemies.size(); i++) Enemy.enemies.get(i).show(g);

		//g.fillRect(Collider.wall5.x, Collider.wall5.y, Collider.wall5.width, Collider.wall5.height);


	}
}






