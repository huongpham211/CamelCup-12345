package game.scene;

import game.Background;
import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundWelcome extends GameObject {

    public BackgroundWelcome(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/Main-Background.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.GAME_WIDTH , Settings.GAME_HEIGHT);
        this.position.set(0, 0);
        this.anchor.set(0,0);
    }

    @Override
    public void run(){
        super.run();
        if(GameWindow.isAnyKeyPress){
            SceneManager.signNewScene(new StageScene1());
        }
    }
}
