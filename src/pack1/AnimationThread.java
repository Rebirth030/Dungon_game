package pack1;

import java.util.TimerTask;

public class AnimationThread extends TimerTask {
    @Override
    public void run() {
        SpriteAnimation.counter++;
        SpriteAnimation.counter %= SpriteAnimation.current.length;
    }
}
