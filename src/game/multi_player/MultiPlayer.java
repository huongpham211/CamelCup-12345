package game.multi_player;

import game.GameObject;
import game.GameWindow;
import game.Player;
import tklibs.SpriteUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MultiPlayer extends GameObject {
    ArrayList<Player> players  = new ArrayList<Player>();
    Button diceButton;
    Button betButton;
    int currentPlayerIndex;
    int diceValue;
    boolean switchingPlayer;
    int switchPlayerCount;
    int switchingPlayerDelay;
    boolean gameEnd;

    public MultiPlayer(){
        this.players.add(new Player("Player 1"));
        this.players.add(new Player("Player 2"));
        this.players.add(new Player("Player 3"));
        this.diceButton = new Button(SpriteUtils.loadImage("assets/images/keys/Key-A-1.png"), 68, 68);
        this.diceButton.position.set(500, 200);
        this.betButton = new Button(SpriteUtils.loadImage("assets/images/keys/Key-B-1.png"), 68, 68);
        this.betButton.position.set(1000, 200);
        currentPlayerIndex = 0;
        switchingPlayer = false;
        switchPlayerCount = 0;
        switchingPlayerDelay = 60;
        gameEnd = false;
    }

    @Override
    public void run(){
        super.run();
        gameRun();
        switchPlayer();
    }


    private void gameRun() {
        if (!gameEnd) {
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0;
            } else {
                // dice or bet
                // detech by click on screen
                if(GameWindow.isMouseClicked && !switchingPlayer) {
                    if(diceButton.isClickOn(GameWindow.mouseClickedPosition)) {
                        doDice();
                    } else if(betButton.isClickOn(GameWindow.mouseClickedPosition)) {
                        doBet();
                    }
                    GameWindow.isMouseClicked = false;
                }
            }
        }
    }

    private void doDice() {
        System.out.println("do dice");

        switchingPlayer = true; // switch player after 60 frame - .switchPlayer()
    }

    private void doBet() {
        System.out.println("bet");

        switchingPlayer = true; // switch player after 60 frame - .switchPlayer()
    }

    private void switchPlayer() {
        if(switchingPlayer) {
            switchPlayerCount++;
            if(switchPlayerCount > switchingPlayerDelay) {
                diceValue = 0;
                switchPlayerCount = 0;
                switchingPlayer = false;
                currentPlayerIndex++;
            }
        }
    }


    @Override
    public void render(Graphics g) {
        super.render(g);
        renderPlayers(g);
    }

    private void renderPlayers(Graphics g) {
        int x = 50;
        int y = 50;
        int offsetY = 50;
        for (int i = 0; i < players.size(); i++) {
            if(i == currentPlayerIndex) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            Player player = players.get(i);
            g.drawString(player.name, x, y + (i * offsetY));
            g.drawString("Point: " + player.point, x, y + (i * offsetY) + 20);
        }
    }
}
