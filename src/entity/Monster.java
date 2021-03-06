/**
 * 
 * Monster.java
 * Description: Controls dinosaur movement and animation. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package src.entity;

import src.main.GamePanel;
import src.main.GamePanel.STATE;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;

public class Monster extends Entity {
    GamePanel gp;

    /**
     * Constructor 
     */
    public Monster( GamePanel gp ){ 
        this.gp = gp; 
         
        setDefaultValues(); 
        getMonsterImage(); 
    } //end Player

    /**
     * Set Default Values.  
     */
    public void setDefaultValues(){ 
        monsterX = 0; 
        monsterY = 450;
    } //end setDefaultValues

    /**
     * Import dinosaur sprites.  
     */
    public void getMonsterImage(){ 
        try{ 
            monster1 = ImageIO.read( getClass().getResourceAsStream( "../monster/Monster_1.png" ) ); 
            monster2 = ImageIO.read( getClass().getResourceAsStream( "../monster/Monster_2.png" ) ); 
            monster3 = ImageIO.read( getClass().getResourceAsStream( "../monster/Monster_3.png" ) ); 
            monster4 = ImageIO.read( getClass().getResourceAsStream( "../monster/Monster_4.png" ) );
            vic1 = ImageIO.read( getClass().getResourceAsStream( "../player/cowboyVic_1.png" ) );
            vic2 = ImageIO.read( getClass().getResourceAsStream( "../player/cowboyVic_2.png" ) );
            vic3 = ImageIO.read( getClass().getResourceAsStream( "../player/cowboyVic_3.png" ) );
            vic4 = ImageIO.read( getClass().getResourceAsStream( "../player/cowboyVic_4.png" ) );
        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    /**
     * Updates position of dinosaur. Also controls victory and gameover animation.  
     */
    public void update(){ 
        if( gp.State == STATE.victory || gp.State == STATE.campaignVictory ){ 
            if (spriteCounter > 20 ){ 
                if( spriteNum == 1 )
                    spriteNum = 2; 
                else if( spriteNum == 2 )
                    spriteNum = 3; 
                else if( spriteNum == 3 )
                    spriteNum = 4; 
                else if( spriteNum == 4 )
                    spriteNum = 1; 

                spriteCounter = 0; 
            } //end if
        }
        else{ 
            if( spriteNum == 3 || spriteNum == 4 )
                spriteNum = 1; 
            if (spriteCounter > 20 ){ 
                if( spriteNum == 1 )
                    spriteNum = 2; 
                else if( spriteNum == 2 )
                    spriteNum = 1; 

                spriteCounter = 0; 
            } //end if
        }
        spriteCounter++; 
    } //end update

    /**
     * Draws dinosaur onto screen.  
     */
    public void draw( Graphics2D graphics2 ){ 
        BufferedImage image = null; 
        
        if( gp.State == STATE.gameOver ){ 
            if( spriteNum == 1 ) 
                image = monster3; 
            if( spriteNum == 2 )
                image = monster4;

            graphics2.drawImage( image, monsterX, monsterY, gp.tileSize*2, gp.tileSize*2, null ); 
        }
        else if( gp.State == STATE.victory || gp.State == STATE.campaignVictory ){ 
            if( spriteNum == 1 ) 
                image = vic1; 
            if( spriteNum == 2 )
                image = vic2;
            if( spriteNum == 3 )
                image = vic3;
            if( spriteNum == 4 )
                image = vic4;

            graphics2.drawImage( image, 550, monsterY, gp.tileSize*2, gp.tileSize*2, null ); 
        }
        else{ 
            if( spriteNum == 1 ) 
                image = monster1; 
            if( spriteNum == 2 )
                image = monster2;

            graphics2.drawImage( image, monsterX, monsterY, gp.tileSize*2, gp.tileSize*2, null ); 
        }
        
    } //end draw
} //end class
