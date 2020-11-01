package pack1;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Panel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double offX = -PlayerOne.getX();
        double offY = -PlayerOne.getY();

        offX = Game.constrain(offX, -LevelOne.mapWidth + Gui.jf.getWidth() / 2d, -(Gui.jf.getWidth() / 2d));
        offY = Game.constrain(offY, -LevelOne.mapHeight + Gui.jf.getHeight() / 2d, -(Gui.jf.getHeight() / 2d));

        g2d.translate(offX + Gui.jf.getWidth() / 2d, offY + Gui.jf.getHeight() / 2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g.drawImage(LevelOne.back1, 0, 0, LevelOne.mapWidth, LevelOne.mapHeight, null);
        Game.player.showPlayer(g);

        //g.fillRect(Collider.exit.x, Collider.exit.y, Collider.exit.width, Collider.exit.height);


    }
}






