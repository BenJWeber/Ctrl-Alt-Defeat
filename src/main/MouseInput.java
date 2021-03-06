/**
 * 
 * MouseInput.java
 * Description: Listens for mouse input by user and proccess corresponding action. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package src.main;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import src.main.GamePanel;
import src.entity.Entity;
import src.entity.Menu; 

public class MouseInput implements MouseInputListener {

    GamePanel gp; // = new GamePanel();

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if (GamePanel.State == GamePanel.STATE.game || GamePanel.State == GamePanel.STATE.pause) {
            // pause button
            if (mx >= 1176 && mx <= 1176 + 100)
                if (my >= 3 && my <= 53) {
                    if (GamePanel.State == GamePanel.STATE.game)
                        GamePanel.State = GamePanel.STATE.pause;
                    else
                        GamePanel.State = GamePanel.STATE.game;
                } // end if
        }

        if (GamePanel.State == GamePanel.STATE.menu) {
            // campaign button
            if (mx >= 350 && mx <= 350 + 175)
                if (my >= 300 && my <= 350) {
                    mx = 0;
                    my = 0;  
                    Entity.campaignFlag = true; 
                    Entity.difficulty = "res/wordBanks/easyWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            // regular button
            if (mx >= 560 && mx <= 560 + 150)
                if (my >= 300 && my <= 350) {
                    mx = 0;
                    my = 0;  
                    GamePanel.State = GamePanel.STATE.difficulty;
                } // end if

            // infinite button
            if (mx >= 750 && mx <= 750 + 125)
                if (my >= 300 && my <= 350) {
                    mx = 0;
                    my = 0;  
                    GamePanel.State = GamePanel.STATE.infinite;
                } // end if

            // Quit button
            if (mx >= 585 && mx <= 585 + 100)
                if (my >= 380 && my <= 430) {
                    System.exit(1);
                } // end if
        }

        if (GamePanel.State == GamePanel.STATE.difficulty) {
            // EASY
            if (mx >= 400 && mx <= 400 + 100)
                if (my >= 300 && my <= 350) {
                    Entity.difficulty = "res/wordBanks/easyWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            // MEDIUM
            if (mx >= 540 && mx <= 540 + 100)
                if (my >= 300 && my <= 350) {
                    Entity.difficulty = "res/wordBanks/mediumWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            // HARD
            if (mx >= 700 && mx <= 700 + 100)
                if (my >= 300 && my <= 350) {
                    Entity.difficulty = "res/wordBanks/hardWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            //Extreme
            if (mx >= 550 && mx <= 650)
                if (my >= 360 && my <= 390) {
                    Entity.difficulty = "res/wordBanks/hardWords.txt";
                    Entity.extremeFlag = true;  
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            if (mx >= 550 && mx <= 550 + 100)
                if (my >= 400 && my <= 450) {
                    GamePanel.State = GamePanel.STATE.menu; 
                } // end if
        }
        
        if( GamePanel.State == GamePanel.STATE.victory){ 
            if (mx >= 570 && mx <= 570 + 100)
                if (my >= 350 && my <= 400) {
                    GamePanel.State = GamePanel.STATE.reset;
                } // end if
        }

        if( GamePanel.State == GamePanel.STATE.campaignVictory ){ 
            if (mx >= 570 && mx <= 570 + 100)
                if (my >= 350 && my <= 400) {
                    GamePanel.State = GamePanel.STATE.campaignReset;
                } // end if
        }

        if (GamePanel.State == GamePanel.STATE.gameOver ) {
            if (mx >= 540 && mx <= 540 + 100) {
                if (my >= 350 && my <= 400) {
                    GamePanel.State = GamePanel.STATE.reset;
                } // end if 
            }
        }
    }// end mousePressed

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
