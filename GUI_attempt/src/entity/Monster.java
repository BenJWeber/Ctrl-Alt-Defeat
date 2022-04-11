package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;

public class Monster extends Entity {
    GamePanel gp;

    public Monster( GamePanel gp ){ 
        this.gp = gp; 
         
        setDefaultValues(); 
        getMonsterImage(); 
    } //end Player

    public void setDefaultValues(){ 
        monsterX = 0; 
        monsterY = 450;
    } //end setDefaultValues

    public void getMonsterImage(){ 
        try{ 
            monster1 = ImageIO.read( getClass().getResourceAsStream( "../monster/Monster_1.png" ) ); 
            monster2 = ImageIO.read( getClass().getResourceAsStream( "../monster/Monster_2.png" ) ); 
        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    public void update(){ 
        if (spriteCounter > 20 ){ 
            if( spriteNum == 1 )
                spriteNum = 2; 
            else if( spriteNum == 2 )
                spriteNum = 1; 
            spriteCounter = 0; 
        } //end if
       
        spriteCounter++; 
    } //end update

    public void draw( Graphics2D graphics2 ){ 
        BufferedImage image = null; 
        
        if( spriteNum == 1 ) 
            image = monster1; 
        if( spriteNum == 2 )
            image = monster2;

        graphics2.drawImage( image, monsterX, monsterY, gp.tileSize*2, gp.tileSize*2, null ); 
    } //end draw
} //end class
