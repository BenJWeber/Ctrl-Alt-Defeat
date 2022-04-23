package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;
import GUI_attempt.src.main.InputHandler;
import GUI_attempt.src.main.GamePanel.STATE;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;

import java.util.Random;

public class Campaign extends Entity{
    GamePanel gp; 
    InputHandler keyH; 
    int slowDown;
    int throwSlowDown;
    public int roundCount; 
    double jumpFactor;  
    int count; 
    boolean cutScene; 

    public Campaign( GamePanel gp, InputHandler keyH ){ 
        this.gp = gp; 
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    } //end Player

    public void setDefaultValues(){ 
        monsterCampaignX = 800; 
        monsterCampaignY = 300;

        healthY = 650; 
        
        playerCampaignX = 50; 
        playerCampaignY = 450;

        slowDown = 0; 
        throwSlowDown = 0; 

        roundCount = 0; 

        playerHealthCount = 3; 

        jumpFactor = 0; 

        count = 0; 
        cutScene = false; 
        cutSceneCounter = 0; 
        cutScenePlayerCounter = 0; 
        cutSceneNum = 1;
        cutSceneNumPlayer = 1;  
    } //end setDefaultValues

    public void getPlayerImage(){ 
        try{ 
            //Monster Images: 
            monsterC1 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaign_1.png" ) ); 
            monsterC2 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaign_2.png" ) ); 
            redMonster1 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaign_Red_1.png" ) ); 
            redMonster2 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaign_Red_1.png" ) ); 
            monsterThrow1 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaignThrow_1.png" ) ); 
            monsterThrow2 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaignThrow_2.png" ) ); 
            monsterThrow3 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/monsterCampaignThrow_3.png" ) ); 
            sleep1 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/sleep1.png" ) ); 
            sleep2 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/sleep2.png" ) ); 
            awake1 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/awake1.png" ) ); 
            awake2 = ImageIO.read( getClass().getResourceAsStream( "../monsterCampaign/awake2.png" ) ); 



            //Player Images: 
            cowboy1 = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboy1.png" ) ); 
            cowboy2 = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboy2.png" ) ); 
            cowboy3 = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboy3.png" ) ); 
            redCowboy1 = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboyRed1.png" ) ); 
            redCowboy2 = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboyRed2.png" ) ); 
            redCowboy3 = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboyRed3.png" ) ); 
            cowboyHit = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboyHit.png" ) ); 
            cowboyAlarmed = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/cowboyAlarmed.png" ) ); 

            //Health: 
            heart = ImageIO.read( getClass().getResourceAsStream( "../playerCampaign/heart.png" ) ); 
        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } 

    public void drawCutScene( Graphics2D graphics2 ){ 
        BufferedImage monsterImage = null;
        BufferedImage playerImage = null; 
 
        cutScene = true; 
        cutSceneCounter++; 
        cutScenePlayerCounter++; 

        if( count < 4 ){ 
            if (cutSceneCounter > 30 ){ 
                if( cutSceneNum == 1 ) 
                    cutSceneNum = 2; 
                else if( cutSceneNum == 2 ) 
                    cutSceneNum = 1; 
                cutSceneCounter = 0; 
                count++; 
            }

            if( cutScenePlayerCounter > 10 ){ 
                if( cutSceneNumPlayer == 1 )
                    cutSceneNumPlayer = 2; 
                else if( cutSceneNumPlayer == 2 )
                    cutSceneNumPlayer = 3; 
                else if( cutSceneNumPlayer == 3 )
                    cutSceneNumPlayer = 1; 
                cutScenePlayerCounter = 0; 
            }
     

            if( cutSceneNum == 1 )
                monsterImage = sleep1;   
            else if( cutSceneNum == 2 )
                monsterImage = sleep2; 
            
            if( cutSceneNumPlayer == 1 )
                playerImage = cowboy1; 
            else if( cutSceneNumPlayer == 2 )
                playerImage = cowboy2; 
            else if( cutSceneNumPlayer == 3 )
                playerImage = cowboy3; 

            graphics2.drawImage( monsterImage, monsterCampaignX, monsterCampaignY + 75, gp.tileSize*4, gp.tileSize*4, null ); 
            graphics2.drawImage( playerImage, playerCampaignX, playerCampaignY, gp.tileSize*2, gp.tileSize*2, null ); 

        } 

        if( count >= 4 && count < 6 ){ 
            if (cutSceneCounter > 20 ){  
                cutSceneCounter = 0; 
                count++; 
            }

            monsterImage = awake1; 
            playerImage = cowboyAlarmed;

            graphics2.drawImage( monsterImage, monsterCampaignX, monsterCampaignY + 75, gp.tileSize*4, gp.tileSize*4, null ); 
            graphics2.drawImage( playerImage, playerCampaignX, playerCampaignY, gp.tileSize*2, gp.tileSize*2, null ); 
        }

        if( count >= 6 && count < 8 ){ 
            if (cutSceneCounter > 20 ){  
                cutSceneCounter = 0; 
                count++; 
            }

            monsterImage = awake2; 
            playerImage = cowboyAlarmed;

            graphics2.drawImage( monsterImage, monsterCampaignX, monsterCampaignY + 75, gp.tileSize*4, gp.tileSize*4, null ); 
            graphics2.drawImage( playerImage, playerCampaignX, playerCampaignY, gp.tileSize*2, gp.tileSize*2, null ); 
        }
        if( count >= 8 ){ 
            count = 0; 
            cutScene = false; 
            cutSceneCounter = 0; 
            cutScenePlayerCounter = 0; 
            cutSceneNum = 1;
            cutSceneNumPlayer = 1;  
            GamePanel.State = GamePanel.STATE.campaignReset;
        }  

    }

    public void update(){
        if( gp.campaignWords.resetFlag )
            gp.campaignWords.getWords(); 

        if( roundCount == 0 ){
            if( Entity.difficulty == "easyWords.txt" ){
                monsterHealthCount = 5; 
                playerHealthCount = 3; 
            } 
            if( Entity.difficulty == "mediumWords.txt" ){ 
                monsterHealthCount = 8; 
                playerHealthCount = 3; 
            } 
            if( Entity.difficulty == "hardWords.txt" ){ 
                monsterHealthCount = 12; 
                playerHealthCount = 3; 
            } 
        } 
        roundCount++; 

        if( gp.jumpFlag ){ 
            gp.jumpFlag = false; 
            direction = "up"; 

            playerCampaignY += ( speed - 10 ); 
            jumpFactor = 10;    
        } //end if
        else{ 
            if( jumpFactor == 0 )
                    direction = "forward";
            else if( jumpFactor > 0 ){            
                playerCampaignY -= jumpFactor; 
                jumpFactor = jumpFactor - .25; 
                if( jumpFactor == 0 ) {
                    jumpFactor = -10; 
                }
                    //playerY = 515; 
            } //end else if
            else if( jumpFactor < 0 ){ 
                playerCampaignY -= jumpFactor; 
                jumpFactor -= .25; 
                if( playerCampaignY >= 450 ){ 
                    jumpFactor = 0; 
                    playerCampaignY = 450; 
                } 
            }
        } 

        if (monsterSpriteCounter > 10 ){ 
            if( monsterSpriteNum == 1 )
                monsterSpriteNum = 2; 
            else if( monsterSpriteNum == 2 )
                monsterSpriteNum = 1; 
            monsterSpriteCounter = 0; 
        } //end if

        if (playerSpriteCounter > 10 ){ 
            if( playerSpriteNum == 1 )
                playerSpriteNum = 2; 
            else if( playerSpriteNum == 2 )
                playerSpriteNum = 3; 
            else if( playerSpriteNum == 3 )
                playerSpriteNum = 1;
            playerSpriteCounter = 0; 
        } //end if

        monsterSpriteCounter++; 
        playerSpriteCounter++;

        if( gp.cTumble.tumbleX <= 0 ){ 
            int[] randomNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 

            int hold = new Random().nextInt( randomNum.length); 

            if( Entity.extremeFlag ){ 
                gp.cAction.setDefaultValues();
                gp.cTumble.setDefaultValues();
            }
            else if( randomNum[ hold ] < 2 ){ 
                Entity.throwFlag = true; 
            } //end if
        } 
    } 

    public void draw( Graphics2D graphics2 ){ 
        BufferedImage monsterImage = null; 
        BufferedImage playerImage = null; 
        
        if( !Entity.throwFlag ){ 
            if( monsterSpriteNum == 1 ) 
                monsterImage = monsterThrow1; 
            if( monsterSpriteNum == 2 )
                monsterImage = monsterThrow2;
        } 
        else{ 
            monsterImage = monsterThrow3; 
            throwSlowDown = 5; 
            Entity.throwFlag = false; 
        } 
            
        if( playerSpriteNum == 1 ){ 
            if( ( gp.cTumble.tumbleX <= playerCampaignX + 20 && gp.cTumble.tumbleX >= playerCampaignX - 10 ) && ( playerCampaignY >= 450 ) ){ 
                playerImage = redCowboy1; 
                if( !Entity.hurtBlock )
                    playerHealthCount--; 
                hurtBlock = true;
            } 
            else{
                playerImage = cowboy1;
                hurtBlock = false; 
            } 
        } 
        if( playerSpriteNum == 2 ){ 
            if( ( gp.cTumble.tumbleX <= playerCampaignX + 20 && gp.cTumble.tumbleX >= playerCampaignX - 10 ) && ( playerCampaignY >= 450 ) ){ 
                playerImage = redCowboy2;
                if( !Entity.hurtBlock ) 
                    playerHealthCount--; 
                hurtBlock = true; 
            } 
            else{ 
                playerImage = cowboy2;
                hurtBlock = false; 
            } 
        }
        if( playerSpriteNum == 3 ){ 
            if( ( gp.cTumble.tumbleX <= playerCampaignX + 20 && gp.cTumble.tumbleX >= playerCampaignX - 10 ) && ( playerCampaignY >= 450 ) ){ 
                playerImage = redCowboy3; 
                if( !Entity.hurtBlock )
                    playerHealthCount--;
                hurtBlock = true;  
            } 
            else{ 
                playerImage = cowboy3;
                hurtBlock = false; 
            } 
        }

        if( Entity.correctCounter >= 3 ){ 
            Entity.correctCounter = 0; 
            slowDown = 5; 
            playerImage = cowboyHit; 
            monsterHealthCount--; 
            monsterImage = redMonster1; 
        }
        else if( slowDown > 0 ){ 
            slowDown--; 
            playerImage = cowboyHit; 
            monsterImage = redMonster1; 
        } 
        else if( throwSlowDown > 0 ) { 
            throwSlowDown--; 
            monsterImage = monsterThrow3; 
        }

        if( direction == "up" ){ 
            playerImage = gp.player.jump; 
        }
             

        holdHealthPlayer = playerHealthCount; 

        if( holdHealthPlayer >= 1 )
            graphics2.drawImage( heart, playerCampaignX, healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHealthPlayer >= 2 )
            graphics2.drawImage( heart, playerCampaignX + gp.tileSize*1/2, healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHealthPlayer >= 3 )
            graphics2.drawImage( heart, playerCampaignX + 2 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 

        holdHeathMonster = monsterHealthCount; 

        if( holdHeathMonster >= 1 )
            graphics2.drawImage( heart, monsterCampaignX, healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 2 )
            graphics2.drawImage( heart, monsterCampaignX + gp.tileSize*1/2, healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 3 )
            graphics2.drawImage( heart, monsterCampaignX + 2 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 4 )
            graphics2.drawImage( heart, monsterCampaignX + 3 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 5 )
            graphics2.drawImage( heart, monsterCampaignX + 4 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 6 )
            graphics2.drawImage( heart, monsterCampaignX + 5 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 7 )
            graphics2.drawImage( heart, monsterCampaignX + 6 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 8 )
            graphics2.drawImage( heart, monsterCampaignX + 7 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 9 )
            graphics2.drawImage( heart, monsterCampaignX + 8 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 
        if( holdHeathMonster >= 10 )
            graphics2.drawImage( heart, monsterCampaignX + 9 * ( gp.tileSize*1/2), healthY, gp.tileSize*1/2, gp.tileSize*1/2, null ); 

        graphics2.drawImage( monsterImage, monsterCampaignX, monsterCampaignY, gp.tileSize*4, gp.tileSize*4, null ); 
        graphics2.drawImage( playerImage, playerCampaignX, playerCampaignY, gp.tileSize*2, gp.tileSize*2, null ); 

        if( monsterHealthCount == 0 ){ 
            System.out.println( gp.level ); 
            if( gp.level >= 3 ){ 
                Entity.campaignFlag = false; 
                GamePanel.State = STATE.victory; 
            } 
            else{
                gp.level++; 
                GamePanel.State = GamePanel.STATE.cutScene; 
            } 
        } 
        if( playerHealthCount == 0 ){ 
            gp.level = 0; 
            GamePanel.State = GamePanel.STATE.gameOver;
        } 

    } //end draw
}
