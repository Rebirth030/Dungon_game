package pack1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {


    private static double offX = 0D;
    private static double offY = 0D;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setBackground(Color.BLACK);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        offX = -Game.player.x;
        offY = -Game.player.y;

        offX = Game.constrain(offX, -Map.mapWidth + Gui.jf.getWidth() / 2d, -(Gui.jf.getWidth() / 2d));
        offY = Game.constrain(offY, -Map.mapHeight + Gui.jf.getHeight() / 2d, -(Gui.jf.getHeight() / 2d));

        offX += Gui.jf.getWidth() / 2d;
        offY += Gui.jf.getHeight() / 2d;

        g2d.translate(offX + Game.currentShake * 20, offY);

        g.drawImage(Map.getMap(), 0, 0, Map.mapWidth, Map.mapHeight, null);
        Game.player.show(g);
        for (int i = 0; i < Enemy.enemies.size(); i++) Enemy.enemies.get(i).show(g);
        if(Game.player.livePoints >= 0) g.drawImage(InitSpriteAnimation.healthImages[(int) Game.constrain(Game.player.livePoints,0,6)],-(int)offX,-(int)offY,null);
        if(!Game.player.alive) {
            try {
                g.drawImage(ImageIO.read(new File("rsc/GameOver.png")),-(int)offX,-(int)offY, getWidth(), getHeight(), null );
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("GameOver could not be drawn");
            }
        }

        //g.fillRect(Collider.wall5.x, Collider.wall5.y, Collider.wall5.width, Collider.wall5.height);
        if (Game.shake == Game.currentShake) Game.shake = 0;
        if (Game.shake > Game.currentShake) Game.currentShake++;
        else if (Game.shake < Game.currentShake) Game.currentShake--;
    }

    public static double getOffX() {
        return offX;
    }

    public static double getOffY() {
        return offY;
    }

    public static void setOffX(double offX) {
        Panel.offX = offX;
    }

    public static void setOffY(double offY) {
        Panel.offY = offY;
    }
}






