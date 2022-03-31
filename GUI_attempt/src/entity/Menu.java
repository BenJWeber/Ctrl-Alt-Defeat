package GUI_attempt.src.entity;
import java.awt.Graphics2D;

import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;

public class Menu {

    public Rectangle playButton = new Rectangle(550, 300, 100, 50 );
    public Rectangle quitButton = new Rectangle(550, 400, 100, 50 );

    public void draw(Graphics2D g2d) {
        Font font1 = new Font("arial", Font.BOLD, 50);
        g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("TYPOPOCALYPSE", 400, 250);
        
        Font font2 = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font2);
        g2d.drawString("Play", playButton.x + 20, playButton.y + 35);
        g2d.draw(playButton);
        g2d.drawString("Quit", quitButton.x + 20, quitButton.y + 35);
        g2d.draw(quitButton);
    }//end draw

    public void drawGameOver(Graphics2D g2d) {
        Font font1 = new Font("arial", Font.BOLD, 50);
        g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("GAME OVER", 400, 250);
    }

    public void pauseButton(Graphics2D g2d) {
        Rectangle pauseButton = new Rectangle(1176, 3, 100, 50 );
        
        Font font1 = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font1);
        g2d.drawString("pause", pauseButton.x + 9, pauseButton.y + 35);
        g2d.draw(pauseButton);
    }//end

    public void pause(Graphics2D g2d) {
        Font font1 = new Font("arial", Font.BOLD, 120);
        Font font2 = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("PAUSED", 400, 250);
        g2d.setFont(font2);
        g2d.drawString("Press esc to un-pause", 480, 300);
    }//end


}//end menu
