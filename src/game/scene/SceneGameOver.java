package game.scene;

import dots_and_boxes.Game;
import game.GameObject;

public class SceneGameOver extends Scene {
    @Override
    public void init(){
        GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
