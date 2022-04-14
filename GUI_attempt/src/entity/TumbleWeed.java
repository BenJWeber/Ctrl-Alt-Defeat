package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;

import java.io.IOException;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;
public class TumbleWeed extends Entity {
    GamePanel gp;

    public TumbleWeed( GamePanel gp ){ 
        this.gp = gp; 
         
        setDefaultValues(); 
        getImage(); 
    } //end Player

    public void setDefaultValues(){ 
        tumbleX = 1500; 
        tumbleY = 530;
    } //end setDefaultValues

    public void getImage(){ 
        try{ 
            tumble1 = ImageIO.read( getClass().getResourceAsStream( "../tumbleWeed/tumbleWeed_1.png" ) ); 
            tumble2 = ImageIO.read( getClass().getResourceAsStream( "../tumbleWeed/tumbleWeed_2.png" ) ); 
            tumble3 = ImageIO.read( getClass().getResourceAsStream( "../tumbleWeed/tumbleWeed_3.png" ) ); 
            tumble4 = ImageIO.read( getClass().getResourceAsStream( "../tumbleWeed/tumbleWeed_4.png" ) ); 

        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    public void tumbleGenerator(){ 
        int[] randomNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 

        int hold = new Random().nextInt( randomNum.length); 

        if( Entity.extremeFlag ){ 
            gp.action.setDefaultValues();
            setDefaultValues();
        }
        else if( randomNum[ hold ] < 5 ){ 
            gp.action.setDefaultValues();
            setDefaultValues();
        } //end if
            

    } //end tumbleGenerator

    public void update(){ 
       // if( Entity.extremeFlag == true )
           // tumbleGenerator(); 

        if( tumbleX <= 0 )
            tumbleGenerator(); 

        if( Entity.extremeFlag )
            tumbleX -= speed + 5; 
        else
            tumbleX -= speed + 2; 

        if (spriteCounter > 10 ){ 
            if( spriteNum == 1 )
                spriteNum = 2; 
            else if( spriteNum == 2 )
                spriteNum = 3;
            else if( spriteNum == 3 )
                spriteNum = 4; 
            else if( spriteNum == 4)
                spriteNum = 1; 
            spriteCounter = 0; 
        } //end if
       
        spriteCounter++; 
    } //end update

    public void draw( Graphics2D graphics2 ){ 
        BufferedImage image = null; 
        
        if( spriteNum == 1 ) 
            image = tumble1; 
        if( spriteNum == 2 )
            image = tumble2;
        if( spriteNum == 3 )
            image = tumble3; 
        if( spriteNum == 4 )
            image = tumble4; 

        graphics2.drawImage( image, tumbleX, tumbleY, gp.tileSize, gp.tileSize, null ); 
    } //end draw
}
