/*
* InputHandler.java
* Detects keyboard input and processes expected action. 
*/

package GUI_attempt.src.main; 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class InputHandler implements KeyListener{
    public boolean jumpPressed; 
    public boolean increaseSpeed; 
    public boolean decreaseSpeed; 
    public boolean gPressed, rPressed; 

    @Override
    public void keyTyped(KeyEvent e) {
    } //end keyTyped

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); 

        if( code == KeyEvent.VK_J ){ 
            jumpPressed = true; 
        } //end if
        if( code == KeyEvent.VK_D ){ 
            increaseSpeed = true; 
        } //end if
        if( code == KeyEvent.VK_A ){ 
            decreaseSpeed = true; 
        } //end if
        if( code == KeyEvent.VK_G ){ 
            gPressed = true; 
        } //end if
        if( code == KeyEvent.VK_R ){ 
            rPressed = true; 
        } //end if

    } //end keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); 

        if( code == KeyEvent.VK_J ){ 
            jumpPressed = false; 
        } //end if
        if( code == KeyEvent.VK_D ){ 
            increaseSpeed = false; 
        } //end if
        if( code == KeyEvent.VK_A ){ 
            decreaseSpeed = false; 
        } //end if
        if( code == KeyEvent.VK_G ){ 
            gPressed = false; 
        } //end if
        if( code == KeyEvent.VK_R ){ 
            rPressed = false; 
        } //end if
    } //end keyReleased
    
}//end class