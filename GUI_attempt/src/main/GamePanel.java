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

import GUI_attempt.src.entity.Player;
import GUI_attempt.src.map.MapManager;


public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; //16x16 tile
    final int scale = 5;    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16; 
    public final int maxScreenRow = 12; 
    final int screenWidth = tileSize * maxScreenCol; //768 Pixels
    final int screenHeight = tileSize * maxScreenRow; //576 Pixels

    MapManager map = new MapManager( this ); 
    InputHandler keyH = new InputHandler(); 
    Thread gameThread; 
    Player player = new Player( this, keyH ); 

    public int FPS = 30; 

    public GamePanel(){ 
        this.setPreferredSize( new Dimension( screenWidth, screenHeight ) );
        this.setBackground( Color.blue );
        this.setDoubleBuffered( true ); //Improves rendering performance 
        this.addKeyListener( keyH ); 
        this.setFocusable( true );
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
        player.update(); 
    } //end update

    public void paintComponent( Graphics graphics ){ 
        super.paintComponent( graphics ); 
        Graphics2D graphics2 = ( Graphics2D )graphics; 

        map.draw( graphics2 ); 
        player.draw( graphics2 ); 
    } //end paintComponent 
}
