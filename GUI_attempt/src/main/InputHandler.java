/**
 * 
 * InputHandler.java
 * Description: Detects keyboard input and processes expected action. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package GUI_attempt.src.main; 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

public class InputHandler implements KeyListener{
    public boolean jumpPressed; 
    public boolean increaseSpeed; 
    public boolean decreaseSpeed;  
    public boolean aPressed, bPressed, cPressed, dPressed, ePressed, fPressed, gPressed, hPressed, 
                    iPressed, jPressed, kPressed, lPressed, mPressed, nPressed, oPressed, pPressed, 
                    qPressed, rPressed, sPressed, tPressed, uPressed, vPressed, wPressed, xPressed, 
                    yPressed, zPressed, spacePressed, backSpacePressed, escapePressed, enterPressed; 
    int counter = 0; 

    @Override
    public void keyTyped(KeyEvent e) {
    } //end keyTyped

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); 

        if( code == KeyEvent.VK_A ){ 
            if( counter == 0 ){ 
                aPressed = true; 
                counter++; 
            } //end if
            else
                aPressed = false;
        } //end if
        if( code == KeyEvent.VK_B ){ 
            bPressed = true; 
        } //end if
        if( code == KeyEvent.VK_C ){ 
            cPressed = true; 
        } //end if
        if( code == KeyEvent.VK_D ){ 
            dPressed = true; 
        } //end if
        if( code == KeyEvent.VK_E ){ 
            ePressed = true; 
        } //end if
        if( code == KeyEvent.VK_F ){ 
            fPressed = true; 
        } //end if
        if( code == KeyEvent.VK_G ){ 
            gPressed = true; 
        } //end if
        if( code == KeyEvent.VK_H ){ 
            hPressed = true; 
        } //end if
        if( code == KeyEvent.VK_I){ 
            iPressed = true; 
        } //end if
        if( code == KeyEvent.VK_J ){ 
            jPressed = true; 
        } //end if
        if( code == KeyEvent.VK_K ){ 
            kPressed = true; 
        } //end if
        if( code == KeyEvent.VK_L ){ 
            lPressed = true; 
        } //end if
        if( code == KeyEvent.VK_M ){ 
            mPressed = true; 
        } //end if
        if( code == KeyEvent.VK_N ){ 
            nPressed = true; 
        } //end if
        if( code == KeyEvent.VK_O ){ 
            oPressed = true; 
        } //end if
        if( code == KeyEvent.VK_P ){ 
            pPressed = true; 
        } //end if
        if( code == KeyEvent.VK_Q ){ 
            qPressed = true; 
        } //end if
        if( code == KeyEvent.VK_R ){ 
            rPressed = true; 
        } //end if
        if( code == KeyEvent.VK_S ){ 
            sPressed = true; 
        } //end if
        if( code == KeyEvent.VK_T ){ 
            tPressed = true; 
        } //end if
        if( code == KeyEvent.VK_U ){ 
            uPressed = true; 
        } //end if
        if( code == KeyEvent.VK_V ){ 
            vPressed = true; 
        } //end if
        if( code == KeyEvent.VK_W ){ 
            wPressed = true; 
        } //end if
        if( code == KeyEvent.VK_X ){ 
            xPressed = true; 
        } //end if
        if( code == KeyEvent.VK_Y ){ 
            yPressed = true; 
        } //end if
        if( code == KeyEvent.VK_Z ){ 
            zPressed = true; 
        } //end if
        if( code == KeyEvent.VK_SPACE ){ 
            if( counter == 0 ){ 
                spacePressed = true; 
                counter++; 
            } //end if
            else
                spacePressed = false; 
        } 

        if( code == KeyEvent.VK_BACK_SPACE ){ 
            backSpacePressed = true; 
        }

        if( code == KeyEvent.VK_ESCAPE ){
            escapePressed = true;
            if(GamePanel.State == GamePanel.STATE.game)
               GamePanel.State = GamePanel.STATE.pause;

            else if(GamePanel.State == GamePanel.STATE.pause)
                    GamePanel.State = GamePanel.STATE.game;
        } //end escape

        //press enter to restart
        if(code == KeyEvent.VK_ENTER)
            if(GamePanel.State == GamePanel.STATE.gameOver)
               GamePanel.State = GamePanel.STATE.reset;
    } //end keyPressed

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); 

        if( code == KeyEvent.VK_A ){ 
            aPressed = false; 
            counter = 0; 
        } //end if
        if( code == KeyEvent.VK_B ){ 
            bPressed = false; 
        } //end if
        if( code == KeyEvent.VK_C ){ 
            cPressed = false; 
        } //end if
        if( code == KeyEvent.VK_D ){ 
            dPressed = false; 
        } //end if
        if( code == KeyEvent.VK_E ){ 
            ePressed = false; 
        } //end if
        if( code == KeyEvent.VK_F ){ 
            fPressed = false; 
        } //end if
        if( code == KeyEvent.VK_G ){ 
            gPressed = false; 
        } //end if
        if( code == KeyEvent.VK_H ){ 
            hPressed = false; 
        } //end if
        if( code == KeyEvent.VK_I){ 
            iPressed = false; 
        } //end if
        if( code == KeyEvent.VK_J ){ 
            jPressed = false; 
        } //end if
        if( code == KeyEvent.VK_K ){ 
            kPressed = false; 
        } //end if
        if( code == KeyEvent.VK_L ){ 
            lPressed = false; 
        } //end if
        if( code == KeyEvent.VK_M ){ 
            mPressed = false; 
        } //end if
        if( code == KeyEvent.VK_N ){ 
            nPressed = false; 
        } //end if
        if( code == KeyEvent.VK_O ){ 
            oPressed = false; 
        } //end if
        if( code == KeyEvent.VK_P ){ 
            pPressed = false; 
        } //end if
        if( code == KeyEvent.VK_Q ){ 
            qPressed = false; 
        } //end if
        if( code == KeyEvent.VK_R ){ 
            rPressed = false; 
        } //end if
        if( code == KeyEvent.VK_S ){ 
            sPressed = false; 
        } //end if
        if( code == KeyEvent.VK_T ){ 
            tPressed = false; 
        } //end if
        if( code == KeyEvent.VK_U ){ 
            uPressed = false; 
        } //end if
        if( code == KeyEvent.VK_V ){ 
            vPressed = false; 
        } //end if
        if( code == KeyEvent.VK_W ){ 
            wPressed = false; 
        } //end if
        if( code == KeyEvent.VK_X ){ 
            xPressed = false; 
        } //end if
        if( code == KeyEvent.VK_Y ){ 
            yPressed = false; 
        } //end if
        if( code == KeyEvent.VK_Z ){ 
            zPressed = false; 
        } //end if
        if( code == KeyEvent.VK_SPACE ){ 
            spacePressed = false; 
            counter = 0; 
        } //end if
        if( code == KeyEvent.VK_BACK_SPACE ){ 
            backSpacePressed = false; 
        }
        if( code == KeyEvent.VK_ESCAPE ){ 
            escapePressed = false; 
        }
        if( code == KeyEvent.VK_ENTER ){ 
            enterPressed = false; 
        }
    } //end keyReleased
}//end class
