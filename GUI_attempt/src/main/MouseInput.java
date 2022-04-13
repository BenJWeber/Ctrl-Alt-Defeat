package GUI_attempt.src.main;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import GUI_attempt.src.main.GamePanel;
import GUI_attempt.src.entity.Entity;
import GUI_attempt.src.entity.Menu; 
import GUI_attempt.src.main.Reset;

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
            // play button
            if (mx >= 550 && mx <= 550 + 100)
                if (my >= 300 && my <= 350) {
                    mx = 0;
                    my = 0;  
                    GamePanel.State = GamePanel.STATE.difficulty;
                } // end if

            // Quit button
            if (mx >= 550 && mx <= 550 + 100)
                if (my >= 400 && my <= 450) {
                    GamePanel.State = GamePanel.STATE.victory; 
                    //System.exit(1);
                } // end if
        }

        if (GamePanel.State == GamePanel.STATE.difficulty) {
            // EASY
            if (mx >= 400 && mx <= 400 + 100)
                if (my >= 300 && my <= 350) {
                    Entity.difficulty = "easyWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            // MEDIUM
            if (mx >= 540 && mx <= 540 + 100)
                if (my >= 300 && my <= 350) {
                    Entity.difficulty = "mediumWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            // HARD
            if (mx >= 700 && mx <= 700 + 100)
                if (my >= 300 && my <= 350) {
                    Entity.difficulty = "hardWords.txt"; 
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            //Extreme
            if (mx >= 550 && mx <= 650)
                if (my >= 360 && my <= 390) {
                    Entity.difficulty = "hardWords.txt";
                    Entity.extremeFlag = true;  
                    System.out.println( "EXTREME" ); 
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
    
        // restart button kills jvm and shell script will restart the game
        if (GamePanel.State == GamePanel.STATE.gameOver || GamePanel.State == GamePanel.STATE.victory) {
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
