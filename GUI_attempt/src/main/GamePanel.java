/*
* GamePanel.java
* Creates GUI, controls FPS, containes main run loop, calls methods to update GUI. 
*/

package GUI_attempt.src.main;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Graphics2D; 

import javax.swing.JPanel;

import GUI_attempt.src.entity.Menu;
import GUI_attempt.src.entity.Monster;
import GUI_attempt.src.entity.Player;
import GUI_attempt.src.entity.Words;
import GUI_attempt.src.map.MapManager;


public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; //16x16 tile
    final int scale = 5;    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16; 
    public final int maxScreenRow = 12; 
    final int screenWidth = tileSize * maxScreenCol; //1280 Pixels
    final int screenHeight = tileSize * maxScreenRow; //960 Pixels

    public final int maxWorldCol = 128; 
    public final int maxWorldRow = 12; 
    public final int worldWidth = tileSize * maxWorldCol; 
    public final int worldHeight = tileSize * maxWorldRow;  

    public boolean increaseSpeed = false; 
    public boolean decreaseSpeed = false; 

    public MapManager mapManager = new MapManager( this ); 
    InputHandler keyH = new InputHandler(); 
    Thread gameThread; 
    public Player player = new Player( this, keyH ); 
    public Monster monster = new Monster( this ); 
    public Words words = new Words( this, keyH ); 
    public Menu menu = new Menu();

    public int FPS = 60; 
    
    
    public static enum STATE{
        menu,
        game,
        pause,
        gameOver,
        victory
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
                System.out.println( "FPS: " + drawCount );
                drawCount = 0; 
                timer = 0;  
            } //end if
        } //end while
    } //End run

    public void update(){ 
        //System.out.println(GamePanel.State);
        if(State == STATE.game) { //(State != STATE.pause && State != STATE.gameOver) && State != STATE.victory){
           mapManager.update(); 
           player.update(); 
           monster.update();
           words.update();
        }
    } //end update

    public void paintComponent( Graphics graphics ){ 
        super.paintComponent( graphics ); 
        Graphics2D graphics2 = ( Graphics2D )graphics; 
        
        
        if(State == STATE.game) {
         mapManager.draw( graphics2 ); 
         player.draw( graphics2 );
         monster.draw( graphics2 ); 
         words.draw( graphics2 ); 
        }
        else if(State == STATE.menu) {
            mapManager.draw( graphics2 );
            menu.draw( graphics2 );
        }
        else if(State == STATE.gameOver) {
            mapManager.draw(graphics2);
            menu.drawGameOver(graphics2);
        }
        else if(State == STATE.victory) { 
            mapManager.draw(graphics2); 
            menu.drawVictory(graphics2); 
        }
        else if(State == STATE.pause) {
            mapManager.draw( graphics2 ); 
            player.draw( graphics2 );
            monster.draw( graphics2 ); 
            words.draw( graphics2 ); 
            menu.pause(graphics2);
        }

    } //end paintComponent 
}
