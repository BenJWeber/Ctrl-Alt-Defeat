package GUI_attempt.src;

//import java.awt.Color; 
//import java.awt.Dimension;
//import java.awt.Image;

//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;

import java.awt.*;
import javax.swing.*; 

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;    
    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16; 
    final int maxScreenRow = 12; 
    final int screenWidth = tileSize * maxScreenCol; //768 Pixels
    final int screenHeight = tileSize * maxScreenRow; //576 Pixels

    Thread gameThread; 

    public GamePanel(){ 
        this.setPreferredSize( new Dimension( screenWidth, screenHeight ) );
        this.setBackground( Color.blue );
        this.setDoubleBuffered( true ); //Improves rendering performance 

        //Attempt to make background image: 
        JFrame frame = new JFrame( "Display image in background" ); 
        final ImageIcon icon = new ImageIcon( "background_grass_mountain.png" ); 
        JTextArea text = new JTextArea(){
            Image img = icon.getImage(); 
            {setOpaque( false );}

            public void paintComponent( Graphics graphics ){ 
                graphics.drawImage( img, 0, 0, this ); 
                super.paintComponent( graphics ); 
            }
        };
        JScrollPane pane = new JScrollPane( text ); 
        Container content = frame.getContentPane(); 
        content.add( pane, BorderLayout.CENTER ); 
        frame.setDefaultCloseOperation( 3 );
        frame.setSize( 32, 32 );
        frame.setVisible( true );
        //End of attempt to make image background
    }

    public void startGameThread(){ 
        gameThread = new Thread( this );
        gameThread.start();  
    }

    @Override
    public void run() {
        //Game loop will be here (Core of the game)
    }
}
