/**
 * 
 * InfiniteMapManager.java
 * Description: Loads infinite map for infinite game state. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package src.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import src.main.GamePanel;
import src.main.GamePanel.STATE;

import java.awt.Graphics2D;

public class InfiniteMapManager extends Map{
    GamePanel gp; 
    Map[] map; 
    int mapTileNum[][];
    
    public int screenX; 
    public int screenY;
    int worldEditX; 
    int worldEditY; 

    /**
     * Constructor
     */
    public InfiniteMapManager( GamePanel gp ){ 
        this.gp = gp;

        setDefaultValues();
        getMapImage(); 
        loadMap(); 
    }

    /**
     * Set Default Values. 
     */
    public void setDefaultValues(){ 
        map = new Map[30]; 
        mapTileNum = new int[ gp.maxWorldCol ][ gp.maxWorldRow ];  
        
        screenX = 200; 
        screenY = 675; 
        worldSpeed = 4;
        
    } //end setDefaultValues

    /**
     * Import map tiles. 
     */
    public void getMapImage(){ 
        try{ 
            map[0] = new Map(); 
            map[0].image = ImageIO.read( getClass().getResourceAsStream( "../map/road_1.png" ) ); 
            map[1] = new Map(); 
            map[1].image = ImageIO.read( getClass().getResourceAsStream( "../map/road_2.png" ) ); 
            map[2] = new Map(); 
            map[2].image = ImageIO.read( getClass().getResourceAsStream( "../map/road_3.png" ) ); 
            map[3] = new Map(); 
            map[3].image = ImageIO.read( getClass().getResourceAsStream( "../map/road_4.png" ) ); 
            //map[4] = new Map(); 
            //map[4].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky.png" ) ); 
            map[5] = new Map(); 
            map[5].image = ImageIO.read( getClass().getResourceAsStream( "../map/sand_1.png" ) ); 
            map[6] = new Map(); 
            map[6].image = ImageIO.read( getClass().getResourceAsStream( "../map/sand_2.png" ) ); 
            map[7] = new Map(); 
            map[7].image = ImageIO.read( getClass().getResourceAsStream( "../map/sand_3.png" ) ); 
            map[8] = new Map(); 
            map[8].image = ImageIO.read( getClass().getResourceAsStream( "../map/sand_4.png" ) ); 
            map[9] = new Map(); 
            map[9].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_1.png" ) ); 
            map[10] = new Map(); 
            map[10].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_2.png" ) ); 
            map[11] = new Map(); 
            map[11].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_3.png" ) ); 
            map[12] = new Map(); 
            map[12].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_4.png" ) ); 
            map[13] = new Map(); 
            map[13].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_5.png" ) ); 
            map[14] = new Map(); 
            map[14].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_6.png" ) ); 
            map[15] = new Map(); 
            map[15].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_7.png" ) ); 
            map[16] = new Map(); 
            map[16].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_8.png" ) ); 
            map[17] = new Map(); 
            map[17].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_9.png" ) ); 
            map[18] = new Map(); 
            map[18].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_10.png" ) ); 
            map[19] = new Map(); 
            map[19].image = ImageIO.read( getClass().getResourceAsStream( "../map/sky_11.png" ) ); 
            map[20] = new Map(); 
            map[20].image = ImageIO.read( getClass().getResourceAsStream( "../map/sun_1.png" ) ); 
        } //end try
        catch( IOException e ){ 
            e.printStackTrace();
        } //end catch
    } //end getMapImage

    /**
     * Load map onto screen. 
     */
    public void loadMap(){ 
        try{ 
            InputStream is = getClass().getResourceAsStream( "../map/mapInfinite.txt" ); //input text file
            BufferedReader br = new BufferedReader( new InputStreamReader( is ) ); //Read text file

            int col = 0; 
            int row = 0; 

            while( col < gp.maxWorldColInfinite && row < gp.maxWorldRow ){ 
                String line = br.readLine(); //readLine - reads a single line of text

                while( col < gp.maxWorldColInfinite ){ 
                    String numbers[] = line.split( " " ); //Seperate line at each space

                    int num = Integer.parseInt( numbers[col] ); //Change from String to int
                    mapTileNum[ col ][ row ] = num; 
                    col++; 
                } //end while

                if( col == gp.maxWorldColInfinite ){ //Parse one row at a time
                    col = 0; 
                    row++; 
                } //end if
            } //end while

            br.close(); 
        } //end try
        catch( Exception e ){ 
        } //end catch
    } //end loadMap

    /**
     * Update camera position on map. 
     */
    public void update(){ 
       worldEditX += worldSpeed;
    } //end update

    /**
     * Draw map onto screen. 
     */
    public void draw( Graphics2D graphics2 ){ 
        int worldCol = 0; 
        int worldRow = 0; 
        

        while( worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow ){ 
            int tileNum = mapTileNum[ worldCol ][ worldRow ]; 

            int worldX = worldCol * gp.tileSize; 
            int worldY = worldRow * gp.tileSize; 
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY; 

            //if( tileNum == 3 )
               // GamePanel.State = GamePanel.STATE.victory;

            graphics2.drawImage( map[ tileNum ].image, screenX, screenY, gp.tileSize, gp.tileSize, null ); 
            worldCol++; 
    
            if( worldCol == gp.maxWorldCol ){ 
                worldCol = 0;
                worldRow++; 
            } //end if
        } //end while
    } //end draw
} //end class
