package pack1;

import javax.swing.*;
import java.awt.*;


public class Gui {

    static Panel pnl1;
    static JFrame jf;


    public static void createGui() {

        jf = new JFrame();
        //jf.setExtendedState(JFrame.);
        jf.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jf.setUndecorated(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setTitle("Dungon Game");
        jf.setResizable(true);
        jf.addKeyListener(new KeyHandler());
        jf.requestFocus();
        jf.setVisible(true);

        pnl1 = new Panel();
        pnl1.setBounds(0, 0, jf.getWidth(), jf.getHeight());
        pnl1.setVisible(true);
        jf.add(pnl1);

    }
}
