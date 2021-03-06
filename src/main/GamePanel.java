/**
 * 
 * GamePanel.java
 * Description: Creates GUI, controls FPS, containes main run loop, calls methods to update GUI. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package src.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Graphics2D; 

import javax.swing.JPanel;

import src.entity.Menu;
import src.entity.Monster;
import src.entity.Player;
import src.entity.Words;
import src.entity.CampaignWords;
import src.map.InfiniteMapManager;
import src.map.MapManager;
import src.entity.Calculate;
import src.entity.Campaign;
import src.entity.CampaignActionWords;
import src.entity.Entity;
import src.entity.TumbleWeed;
import src.entity.CampaignTumble;
import src.entity.ActionWords;
import src.entity.CampaignActionWords;

public class GamePanel extends JPanel implements Runnable{
    /**
     * Set all parameters: 
     */
    final int originalTileSize = 16; //16x16 tile
    final int scale = 5;    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16; 
    public final int maxScreenRow = 12; 
    final int screenWidth = tileSize * maxScreenCol; //1280 Pixels
    final int screenHeight = tileSize * maxScreenRow; //960 Pixels

    public final int maxWorldCol = 128;
    public final int maxWorldColInfinite = 38;

    public final int maxWorldRow = 12; 
    public final int worldWidth = tileSize * maxWorldCol; 
    public final int worldHeight = tileSize * maxWorldRow;  

    public boolean increaseSpeed = false; 
    public boolean decreaseSpeed = false; 
    public boolean jumpFlag = false; 

    public MapManager mapManager = new MapManager( this ); 
    public InfiniteMapManager infiniteMap = new InfiniteMapManager( this ); 
    InputHandler keyH = new InputHandler(); 
    Thread gameThread; 
    public Player player = new Player( this, keyH ); 
    public Campaign campaignClass = new Campaign(this, keyH); 
    public Monster monster = new Monster( this ); 
    public Words words = new Words( this, keyH ); 
    public CampaignWords campaignWords = new CampaignWords( this, keyH ); 
    public ActionWords action = new ActionWords( this, keyH ); 
    public CampaignActionWords cAction = new CampaignActionWords( this, keyH ); 
    public Menu menu = new Menu( this );
    public Calculate calculate = new Calculate();
    public TumbleWeed tumble = new TumbleWeed( this );  
    public CampaignTumble cTumble = new CampaignTumble( this );  

    public int FPS = 60; 

    int countCycles = 0; 
    int passCount = 0;  
    public int level = 1; 
    
    /**
     * Declare States. 
     */
    public static enum STATE{
        menu,
        difficulty,
        game,
        infinite,
        campaign, 
        pause,
        gameOver,
        victory, 
        campaignVictory,
        cutScene,
        reset, 
        campaignReset
    };

    public static STATE State = STATE.menu;

    public GamePanel(){ 
        this.setPreferredSize( new Dimension( screenWidth, screenHeight ) );
        this.setBackground( Color.blue );
        this.setDoubleBuffered( true ); //Improves rendering performance 
        this.addKeyListener( keyH ); 
        this.setFocusable( true );
        this.addMouseListener(new MouseInput());
    } //End GamePanel

    public void startGameThread(){ 
        gameThread = new Thread( this );
        gameThread.start(); 
    } //End startGameThread

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; 
        double delta = 0; 
        long lastTime = System.nanoTime(); 
        long currentTime; 
        long timer = 0; 
        int drawCount = 0; 
        
        
        while( gameThread != null ){ 
            currentTime = System.nanoTime(); 
            delta += ( currentTime - lastTime ) / drawInterval; 
            timer += currentTime - lastTime; 
            lastTime = currentTime; 
            
            if( delta >= 1 ){ 
                update(); 
                repaint(); //Calls paintComponent  
                delta--; 
                drawCount++; 
            } //end if

            if( timer >= 1000000000 ){ 
                //System.out.println( "FPS: " + drawCount );
                drawCount = 0; 
                timer = 0;  
            } //end if
        } //end while
    } //End run

    public void update(){ 
        if(State == STATE.game){
            if( Entity.campaignFlag ){ 
                if( level == 1 )
                    Entity.difficulty = "res/wordBanks/easyWords.txt"; 
                else if( level == 2 )
                    Entity.difficulty = "res/wordBanks/mediumWords.txt"; 
                else if( level == 3 )
                    Entity.difficulty = "res/wordBanks/hardWords.txt";
            } 

            if( words.correctWords == null ) 
                words.getWords();
                
            mapManager.update(); 
            player.update(); 
            monster.update();
            words.update();
            tumble.update(); 
            action.update();
        }
        if( State == STATE.infinite ){ 
            if( player.worldX >= 1900 ){
                player.worldX = 400;  
            } 
            Entity.difficulty = "res/wordBanks/mediumWords.txt"; 
            if( words.correctWords == null )
                words.getWords();

            infiniteMap.update(); 
            player.update(); 
            monster.update();
            words.update();
            tumble.update(); 
            action.update();

        }
        if( State == STATE.gameOver ){
            monster.update(); 
            Entity.campaignFlag = false; 
        } 
        if( State == STATE.victory )
            monster.update(); 
        if( State == STATE.campaignVictory )
            monster.update();
        if( State == STATE.campaign ){ 
            campaignClass.update();
            if( passCount == 0 )
                campaignWords.getWords();
            passCount++; 
            campaignWords.update();
            cTumble.update(); 
            cAction.update();
        }
    } //end update

    public void paintComponent( Graphics graphics ){ 
        super.paintComponent( graphics ); 
        Graphics2D graphics2 = ( Graphics2D )graphics; 
        
        
        if(State == STATE.game ) {
         mapManager.draw( graphics2 ); 
         player.draw( graphics2 ); 
         words.draw( graphics2 ); 
         tumble.draw( graphics2 ); 
         action.draw( graphics2 ); 
         monster.draw( graphics2 );
        }
        if(State == STATE.infinite) {
            infiniteMap.draw( graphics2 ); 
            player.draw( graphics2 ); 
            words.draw( graphics2 ); 
            tumble.draw( graphics2 ); 
            action.draw( graphics2 ); 
            monster.draw( graphics2 );
        }
        else if(State == STATE.menu) {
            mapManager.draw( graphics2 );
            menu.draw( graphics2 );
        }
        else if( State == STATE.difficulty){
            mapManager.draw(graphics2);
            menu.drawDifficulty(graphics2);
        }
        else if(State == STATE.gameOver) {
            mapManager.draw(graphics2);
            menu.drawGameOver(graphics2);
            monster.draw(graphics2);
            Entity.extremeFlag = false; 
        }
        else if(State == STATE.victory) { 
            calculate.wordsPerMinute(); 
            mapManager.draw(graphics2); 
            menu.drawVictory(graphics2); 
            monster.draw(graphics2);
            Entity.extremeFlag = false;
            Entity.campaignFlag = false; 
        }
        else if( State == STATE.campaignVictory ){ 
            calculate.wordsPerMinute(); 
            mapManager.draw(graphics2); 
            menu.drawCampaignVictory(graphics2); 
            monster.draw(graphics2);
        }
        else if( State == STATE.cutScene ){ 
            mapManager.draw(graphics2);
            campaignClass.drawCutScene(graphics2);
        }
        else if(State == STATE.campaign){ 
            mapManager.draw( graphics2 );
            cAction.draw( graphics2 );
            cTumble.draw( graphics2 ); 
            campaignWords.draw( graphics2 ); 
            campaignClass.draw( graphics2 ); 
        }
        else if(State == STATE.pause) {
            mapManager.draw( graphics2 ); 
            player.draw( graphics2 );
            monster.draw( graphics2 ); 
            words.draw( graphics2 ); 
            menu.pause(graphics2);
        }
        else if( State == STATE.reset ){ 
            mapManager.draw( graphics2 );
            calculate.setDefaultValues();
            player.setDefaultValues(); 
            words.setDefaultValues();
            tumble.setDefaultValues();
            campaignClass.setDefaultValues();
            cTumble.setDefaultValues(); 
            campaignWords.setDefaultValues();
            
            words.resetFlag = true; 
            campaignWords.resetFlag = true; 

            State = STATE.menu; 
        }
        else if( State == STATE.campaignReset ){ 
            mapManager.draw( graphics2 );
            calculate.setDefaultValues();
            player.setDefaultValues(); 
            words.setDefaultValues();
            tumble.setDefaultValues();
            words.resetFlag = true;  
            campaignWords.resetFlag = true; 

            Entity.campaignFlag = true; 
            campaignClass.roundCount = 0;             
            State = STATE.game; 
        }
    } //end paintComponent 
} //end class