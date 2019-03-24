package game.scene;

import dots_and_boxes.Game;
import game.GameObject;
import game.Settings;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/Button-Local-Image.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(Settings.GAME_WIDTH , Settings.GAME_HEIGHT);
        this.position.set(0, 0);
        this.anchor.set(0,0);
    }
}
