package game.scene;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map extends GameObject {
    public  ArrayList<Vector2D> map ;
    public static Map instance = new Map();
    BufferedImage image;
    public Map(){
        map = new ArrayList();
        map.add(new Vector2D(4,0));
        map.add(new Vector2D(5,1));
        map.add(new Vector2D(6,2));
        map.add(new Vector2D(7,3));
        map.add(new Vector2D(8,4));
        map.add(new Vector2D(7,5));
        map.add(new Vector2D(6,6));
        map.add(new Vector2D(5,7));
        map.add(new Vector2D(4,8));
        map.add(new Vector2D(3,7));
        map.add(new Vector2D(2,6));
        map.add(new Vector2D(1,5));
        map.add(new Vector2D(0,4));
        map.add(new Vector2D(1,3));
        map.add(new Vector2D(2,2));
        map.add(new Vector2D(3,1));

        image = SpriteUtils.loadImage("assets/small-title.png");

        for (Vector2D x : map) {
            x.x *= 188/2;
            x.y *= 99/2f;
        }

    }

    @Override
    public void render(Graphics g) {
        for (Vector2D x: map) {
            double newPX = x.x + image.getWidth();
            double newPY = x.y + (2.5f)*image.getHeight();

            g.drawImage(this.image,(int) newPX - this.image.getWidth()/2, (int)newPY - this.image.getHeight()/2 ,null);

//            g.drawImage(this.image,(int) x.x + image.getWidth(), (int)x.y + 2*image.getHeight() + image.getHeight()/2 ,null);
        }
    }
}
