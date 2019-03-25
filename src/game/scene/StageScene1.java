package game.scene;

import game.*;
import game.multi_player.Camel;
import game.multi_player.MultiPlayer;

public class StageScene1 extends  Scene {
    @Override
    public void init(){
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Map.class);
        GameObject.recycle(MultiPlayer.class);
        Camel camel1 = new Camel("Blue", new Vector2D(8*188/2,4*99/2));
        Camel camel2 = new Camel("Orange", new Vector2D(6*188/2,99));
        Camel camel3 = new Camel("White", new Vector2D(6*188/2,99));
        camel3.tail = camel2;
        Camel camel4 = new Camel("Yellow", new Vector2D(1*188/2f,5*99/2f));
        //camel2.tail = camel1;
        Camel came15 = new Camel("Green", new Vector2D(7*188/2f, 3*99/2f));


    }

    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
