package game.multi_player;

import game.GameObject;
import game.Vector2D;
import game.scene.Map;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Camel extends GameObject {
    public Camel tail;
    public Camel head;
    BufferedImage image0;
    BufferedImage image1;
    public String color;
    public int type ;
    public Camel(String color, Vector2D position){
        this.head = null;
        this.tail = null;
        this.position = position;
        System.out.println(this.position.x + " " + this.position.y);
        //this.renderer = new SingleImageRenderer(image);
        this.anchor.set(0,0);
        for (int i = 0; i < Map.instance.map.size(); i++) {
            Vector2D tileMap = Map.instance.map.get(i);
            System.out.println(i);
            if (i < 4) {
                if (tileMap.x == this.position.x && tileMap.y == this.position.y) {
                    type = 1;
                    break;
                }
            } else if (i >= 4 && i < 8) {
                if (tileMap.x == this.position.x && tileMap.y == this.position.y) {
                    type = 2;
                    break;
                }
            } else if (i >= 8 && i < 12) {
                if (tileMap.x == this.position.x && tileMap.y == this.position.y) {
                    type = 3;
                    break;
                }
            } else {
                if (tileMap.x == this.position.x && tileMap.y == this.position.y) {
                    type = 4;
                    break;
                }
            }
//            System.out.println(tileMap.x+" "+tileMap.y);
//            if (tileMap.x == this.position.x && tileMap.y == this.position.y) {
//                System.out.println(i);
//                break;
//            }
        }




        image0 = SpriteUtils.loadImage("assets/images/camels/Camel-"+color+"-"+type+"-0.png");
        image1 = SpriteUtils.loadImage("assets/images/camels/Camel-"+color+"-"+type+"-1.png");
        System.out.println("assets/images/camels/Camel-"+color+"-"+type+"-0.png");
    }


    @Override
    public void render(Graphics g) {
        int positiony = 0;
        Camel template = this;
        double newPX = this.position.x + 188;
        double newPY = this.position.y + (2.5f)*99;

        if (tail == null) {
            g.drawImage(image0,(int)newPX - this.image0.getWidth()/2 , (int)(newPY - this.image0.getHeight()*2/3f) , null);
        }
        else {
            while (template.tail != null) {
                positiony += image0.getHeight()/2;
                template = tail;
            }
            System.out.println(positiony);
            g.drawImage(image1,(int)newPX - this.image1.getWidth()/2, (int)(newPY - positiony - (this.image1.getHeight() *2/3f)), null);
        }
        g.drawOval((int)newPX,(int)newPY,3,3);

    }

    public static void main(String[] args) {
        for (Vector2D x: Map.instance.map) {
            System.out.println(x.x +" " + x.y);
        }
    }
}