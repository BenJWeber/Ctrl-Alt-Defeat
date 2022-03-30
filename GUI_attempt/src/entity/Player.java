/*
* Player.java
* Loads player image, handles player animation based on user input.
*/

package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;
import GUI_attempt.src.main.InputHandler;
import GUI_attempt.src.entity.TestWords; 

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp; 
    InputHandler keyH; 

    int defaultPlayerY = 675; 
    int defaultPlayerX = 700; 
    double increaseFactor; 
    double decreaseFactor; 

    public int screenX; 
    public int screenY;

    public boolean jumpFlag = false; 

    public Player( GamePanel gp, InputHandler keyH ){ 
        this.gp = gp; 
        this.keyH = keyH;
        screenX = 200; 
        screenY = 675; 
        setDefaultValues();
        getPlayerImage(); 
    } //end Player

    public void setDefaultValues(){ 
        worldX = 400; 
        worldY = 675; 

        playerX = defaultPlayerX; 
        playerY = defaultPlayerY; 
        
        increaseFactor = 0; 
        decreaseFactor = 0; 

        speed = 4; 
        direction = "forward"; 
    } //end setDefaultValues

    public void getPlayerImage(){ 
        try{ 
            forward1 = ImageIO.read( getClass().getResourceAsStream( "../../res/player/Cowboy_1.png" ) ); 
            forward2 = ImageIO.read( getClass().getResourceAsStream( "../../res/player/Cowboy_2.png" ) ); 
            jump = ImageIO.read( getClass().getResourceAsStream( "../../res/player/Cowboy_Jump.png" ) ); 
        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    public void update(){ 
        if( keyH.jumpPressed == true ){ 
            direction = "up"; 

            playerY -= speed;  
            worldX += speed;
            
            jumpFlag = true; 
        } //end if
        else if( gp.increaseSpeed ){            
            gp.increaseSpeed = false; 
            direction = "forward"; 

            playerX += (speed + 10 ); 
            worldX += speed;
            increaseFactor = 10; 

            if( jumpFlag == true ){ 
                playerY = defaultPlayerY; 
                jumpFlag = false; 
            } //end if

            if (spriteCounter > 5 ){ 
                if( spriteNum == 1 )
                    spriteNum = 2; 
                else if( spriteNum == 2 )
                    spriteNum = 1; 
                spriteCounter = 0; 
            } //end if
        } //end else if
        else if( gp.decreaseSpeed ){ 
            gp.decreaseSpeed = false; 
            direction = "forward"; 

            playerX -= ( speed + 4 ); 
            worldX += speed;
            decreaseFactor = 10; 

            if( jumpFlag == true ){ 
                playerY = defaultPlayerY; 
                jumpFlag = false; 
            } //end if

            if (spriteCounter > 15 ){ 
                if( spriteNum == 1 )
                    spriteNum = 2; 
                else if( spriteNum == 2 )
                    spriteNum = 1; 
                spriteCounter = 0; 
            } //end if
        } //end else if
        else{ 
            direction = "forward";

            worldX += speed;
            if( increaseFactor > 0 ){ 
                
                playerX += increaseFactor; 
                increaseFactor = increaseFactor - .5; 

                if( playerX > 700 )
                    increaseFactor = 0; 
            } //end if 
            else if( decreaseFactor > 0 ){ 
                playerX -= decreaseFactor; 
                decreaseFactor = decreaseFactor -.25; 
            } //end else if
            else
                playerX -= .1; 

            if( jumpFlag == true ){ 
                playerY = defaultPlayerY; 
                jumpFlag = false; 
            } //end if
            
            if (spriteCounter > 10 ){ 
                if( spriteNum == 1 )
                    spriteNum = 2; 
                else if( spriteNum == 2 )
                    spriteNum = 1; 
                spriteCounter = 0; 
            } //end if
        } //end else

        if (playerX <= monsterX) {
            GamePanel.State = GamePanel.STATE.gameOver;
            
        }
        spriteCounter++; 
    } //end update

    public void draw( Graphics2D graphics2 ){ 
        BufferedImage image = null; 
        
        switch( direction ){ 
            case "up":
                image = jump; 
                break; 
            case "forward": 
                if( spriteNum == 1 ) 
                    image = forward1; 
                if( spriteNum == 2 )
                    image = forward2;
                break; 
        } //end switch

        graphics2.drawImage( image, playerX, playerY, gp.tileSize, gp.tileSize, null ); 
    } //end draw
} //end class
