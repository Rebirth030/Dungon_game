package pack1;

import java.awt.*;

public class Collider {
    static Rectangle wall1 = new Rectangle(0,0,LevelOne.mapWidth,100);



    public static void wallCollider(){
        Rectangle player = new Rectangle((int)PlayerOne.x,(int)PlayerOne.y, -PlayerOne.playerWidth,-PlayerOne.playerHeight);

        System.out.println((int)PlayerOne.x +","+ (int)PlayerOne.y);
        if(player.intersects(wall1) || wall1.intersects(player)) {System.out.println("collision");}
    }

}
