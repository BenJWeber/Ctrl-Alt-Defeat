package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;
import GUI_attempt.src.main.inputHandler;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;

public class Player extends Entity {
    GamePanel gp; 
    inputHandler keyH; 

    public boolean jumpFlag = false; 

    public Player( GamePanel gp, inputHandler keyH ){ 
        this.gp = gp; 
        this.keyH = keyH; 

        setDefaultValues();
        getPlayerImage(); 
    } //end Player

    public void setDefaultValues(){ 
        x = 100; 
        y = 100; 
        speed = 4; 
        direction = "forward"; 
    } //end setDefaultValues

    public void getPlayerImage(){ 
        try{ 
            forward1 = ImageIO.read( getClass().getResourceAsStream( "Cowboy_1.png" ) ); 
            forward2 = ImageIO.read( getClass().getResourceAsStream( "Cowboy_2.png" ) ); 
            jump = ImageIO.read( getClass().getResourceAsStream( "Cowboy_Jump.png" ) ); 
        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    public void update(){ 
        if( keyH.jumpPressed == true ){ 
            direction = "up"; 
            y -= speed; 
            x += 1; 
            jumpFlag = true; 
        } //end if
        else{ 
            direction = "forward"; 
            if( jumpFlag == true ){ 
                setDefaultValues(); 
                jumpFlag = false; 
            } //end if
        } //end else

        spriteCounter++; 

        //Control speed of walking animation: 
        if (spriteCounter > 10 ){ 
            if( spriteNum == 1 )
                spriteNum = 2; 
            else if( spriteNum == 2 )
                spriteNum = 1; 
            spriteCounter = 0; 
        } //end if

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

        graphics2.drawImage( image, x, y, gp.tileSize, gp.tileSize, null ); 
    } //end draw
} //end class
