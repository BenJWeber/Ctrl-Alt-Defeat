package GUI_attempt.src.main;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import GUI_attempt.src.main.GamePanel; 
import GUI_attempt.src.entity.Menu; 

public class MouseInput implements MouseInputListener {

    GamePanel gp;
   // Menu menu = new Menu(); 

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
                    GamePanel.State = GamePanel.STATE.game;
                } // end if

            // Quit button
            if (mx >= 550 && mx <= 550 + 100)
                if (my >= 400 && my <= 450) {
                    System.exit(1);
                } // end if
        }
        /*
        if( GamePanel.State == GamePanel.STATE.victory){ 
            if (mx >= 550 && mx <= 550 + 100)
                if (my >= 300 && my <= 350) {
                        //System.out.println( "This is when the game would be reset");     
                    menu.resetGame(); 
                    GamePanel.State = GamePanel.STATE.game;
                    System.out.println( "i MADE IT MA!"); 
                } // end if
        }
        */
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
