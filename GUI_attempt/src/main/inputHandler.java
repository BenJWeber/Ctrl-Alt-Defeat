package GUI_attempt.src.main; 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class inputHandler implements KeyListener{
    public boolean jumpPressed; 

    @Override
    public void keyTyped(KeyEvent e) {
    } //end keyTyped

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); 

        if( code == KeyEvent.VK_J ){ 
            jumpPressed = true; 
        } //end if
    } //end keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); 

        if( code == KeyEvent.VK_J ){ 
            jumpPressed = false; 
        } //end if
    } //end keyReleased
    
}//end class