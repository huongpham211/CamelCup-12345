package game.multi_player;

import game.GameObject;
import game.Vector2D;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Button extends GameObject {
    int width;
    int height;

    public Button(BufferedImage image, int width, int height) { // can be replace by image
        renderer = new SingleImageRenderer(image);
        this.width = width;
        this.height = height;
    }

    public Button(String imagesFolderPath, int width, int height) {
        renderer = new AnimationRenderer(imagesFolderPath, 10);
        this.width = width;
        this.height = height;
    }

    public boolean isClickOn(Vector2D mousePosition) {
        double top = this.position.y - this.anchor.y * this.height;
        double left = this.position.x - this.anchor.x * this.width;
        return top <= mousePosition.y && top + this.height >= mousePosition.y
                && left <= mousePosition.x && left + this.width >= mousePosition.x;
    }
}
