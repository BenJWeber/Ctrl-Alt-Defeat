package GUI_attempt.src.main;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class MouseInput implements MouseInputListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

       int mx = e.getX();
       int my = e.getY();
       //play button
       if(mx >= 550 && mx <= 550 + 100)
          if(my >= 300 && my <= 350){
              GamePanel.State = GamePanel.STATE.game;
          }//end if

       
       //Quit button
       if(mx >= 550 && mx <= 550 + 100)
          if(my >= 400 && my <= 450){
              System.exit(1);
          }//end if
    }//end mousePressed

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
