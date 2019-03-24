package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isAnyKeyPress;
    public static boolean isMouseClicked;
    public static Vector2D mouseClickedPosition = new Vector2D();

    public GameWindow() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress = true;
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress = false;
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    isLeftPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isMouseClicked = true;
                Insets insets = getInsets();
                mouseClickedPosition.set(e.getX() - insets.left, e.getY() - insets.top);
            }
        });
    }
}
