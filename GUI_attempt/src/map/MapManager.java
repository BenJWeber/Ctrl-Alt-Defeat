/*
* MapManager.java
* Reads in map tiles and generates map based off of text file. 
*/

package GUI_attempt.src.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import GUI_attempt.src.main.GamePanel;
import java.awt.Graphics2D;

public class MapManager {
    GamePanel gp; 
    Map[] map; 
    int mapTileNum[][]; 

    public MapManager( GamePanel gp ){ 
        this.gp = gp; 

        map = new Map[20]; 
        mapTileNum = new int[ gp.maxScreenCol ][ gp.maxScreenRow ]; 
        getMapImage(); 
        loadMap(); 
    }

    public void getMapImage(){ 
        try{ 
            map[0] = new Map(); 
            map[0].image = ImageIO.read( getClass().getResourceAsStream( "../../res/map/road.png" ) ); 
            map[1] = new Map(); 
            map[1].image = ImageIO.read( getClass().getResourceAsStream( "../../res/map/sand.png" ) ); 
            map[2] = new Map(); 
            map[2].image = ImageIO.read( getClass().getResourceAsStream( "../../res/map/sky.png" ) ); 
        } //end try
        catch( IOException e ){ 
            e.printStackTrace();
        } //end catch
    } //end getMapImage

    public void loadMap(){ 
        try{ 
            InputStream is = getClass().getResourceAsStream( "../../res/map/map_1.txt" ); //input text file
            BufferedReader br = new BufferedReader( new InputStreamReader( is ) ); //Read text file

            int col = 0; 
            int row = 0; 

            while( col < gp.maxScreenCol && row < gp.maxScreenRow ){ 
                String line = br.readLine(); //readLine - reads a single line of text

                while( col < gp.maxScreenCol ){ 
                    String numbers[] = line.split( " " ); //Seperate line at each space

                    int num = Integer.parseInt( numbers[col] ); //Change from String to int
                    mapTileNum[ col ][ row ] = num; 
                    col++; 
                } //end while

                if( col == gp.maxScreenCol ){ //Parse one row at a time
                    col = 0; 
                    row++; 
                } //end if
            } //end while

            br.close(); 
        } //end try
        catch( Exception e ){ 
        } //end catch
    } //end loadMap

    public void draw( Graphics2D graphics2 ){ 
        int col = 0; 
        int row = 0; 
        int x = 0; 
        int y = 0; 

        while( col < gp.maxScreenCol && row < gp.maxScreenRow ){ 
            int tileNum = mapTileNum[ col ][ row ]; 

            graphics2.drawImage( map[ tileNum ].image, x, y, gp.tileSize, gp.tileSize, null ); 
            col++; 
            x += gp.tileSize; 

            if( col == gp.maxScreenCol ){ 
                col = 0; 
                x = 0; 
                row++; 
                y += gp.tileSize; 
            } //end if
        } //end while
    } //end draw
} //end class
