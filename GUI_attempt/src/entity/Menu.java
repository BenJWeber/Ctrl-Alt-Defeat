package GUI_attempt.src.entity;
import java.awt.Graphics2D;

import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;

import GUI_attempt.src.main.GamePanel;

public class Menu extends Entity{
    GamePanel gp;

    public Menu( GamePanel gp ){ 
        this.gp = gp; 
    } //end Player
    
    
    public void draw(Graphics2D g2d) {
        Font font1 = new Font("arial", Font.BOLD, 50);
        g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("TYPOPOCALYPSE", 400, 250);
        
        Rectangle playButton = new Rectangle(550, 300, 100, 50 );
        Rectangle quitButton = new Rectangle(550, 400, 100, 50 );

        Font font2 = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font2);
        g2d.drawString("Play", playButton.x + 20, playButton.y + 35);
        g2d.draw(playButton);
        g2d.drawString("Quit", quitButton.x + 20, quitButton.y + 35);
        g2d.draw(quitButton);
    }//end draw


    public void drawDifficulty(Graphics2D g2d){ 

        g2d.setColor(Color.white);
        Font font1 = new Font("arial", Font.BOLD, 50);
        g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("TYPOPOCALYPSE", 400, 250);
        
        Rectangle backButton = new Rectangle(550, 400, 100, 50 );
        Rectangle easyButton = new Rectangle(400, 300, 100, 50 );
        Rectangle mediumButton = new Rectangle(540, 300, 125, 50 );
        Rectangle hardButton = new Rectangle(700, 300, 100, 50 );

        Font font2 = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font2);

        g2d.drawString("Back", backButton.x + 20, backButton.y + 35);
        g2d.draw(backButton);

        g2d.drawString("Easy", easyButton.x + 15, easyButton.y + 35);
        g2d.draw(easyButton);

        g2d.drawString("Medium", mediumButton.x + 5, mediumButton.y + 35);
        g2d.draw(mediumButton);

        g2d.drawString("Hard", hardButton.x + 15, hardButton.y + 35);
        g2d.draw(hardButton);
    }

    public void drawGameOver(Graphics2D g2d) {
        Rectangle resetButton = new Rectangle(570, 350, 115, 30 );

        Font font1 = new Font("arial", Font.BOLD, 50);
        Font restartButtonFont = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font1);
        g2d.setColor(Color.red);
        g2d.drawString("GAME OVER", 500, 250);

        Rectangle restartButton = new Rectangle(540, 300, 125, 50);
        g2d.setFont(restartButtonFont);
        g2d.setColor(Color.white);
        g2d.drawString("Restart", restartButton.x + 5, restartButton.y + 35);
        g2d.draw(restartButton);

    }

    public void drawVictory(Graphics2D g2d) { 
        Rectangle resetButton = new Rectangle(570, 350, 115, 30 );

        Font font1 = new Font("arial", Font.BOLD, 50);
        Font restartButtonFont = new Font("arial", Font.BOLD, 30);
        g2d.setFont(font1);
        g2d.setColor(Color.white);
        g2d.drawString("You Win!", 400, 250);
        g2d.drawString("WordsPerMinute = " + gp.calculate.wordsPerMinute, 400, 300);

        Rectangle restartButton = new Rectangle(540, 300, 125, 50);
        g2d.setFont(restartButtonFont);
        g2d.setColor(Color.white);
        g2d.drawString("Restart", restartButton.x + 5, restartButton.y + 35);
        g2d.draw(restartButton);
    }

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
