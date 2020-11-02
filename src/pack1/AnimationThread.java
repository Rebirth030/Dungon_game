package pack1;

import java.util.TimerTask;

public class AnimationThread extends TimerTask {
    @Override
    public void run() {
        SpriteAnimation.counter++;
        SpriteAnimation.enemy_1Counter++;
        SpriteAnimation.enemy_1Counter %= 14;
        // da es nur beim teilen durch 4 einen rest gibt (modulo)
        SpriteAnimation.counter %= SpriteAnimation.current.length;
    }
}
