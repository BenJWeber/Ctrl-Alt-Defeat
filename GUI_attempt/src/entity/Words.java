package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;

public class Words extends Entity {
    GamePanel gp;

    public Words( GamePanel gp ){ 
        this.gp = gp; 
         
        setDefaultValues(); 
        getWordsImage(); 
    } //end Player

    public void setDefaultValues(){ 
        wordsX_1 = 1000; 
        wordsY = 250;
    } //end setDefaultValues

    public void getWordsImage(){
        try{ 
            letter_a = ImageIO.read( getClass().getResourceAsStream( "../../res/words/A.png" ) ); 
            letter_b = ImageIO.read( getClass().getResourceAsStream( "../../res/words/B.png" ) ); 
            letter_c = ImageIO.read( getClass().getResourceAsStream( "../../res/words/C.png" ) ); 
            letter_d = ImageIO.read( getClass().getResourceAsStream( "../../res/words/D.png" ) ); 
            letter_e = ImageIO.read( getClass().getResourceAsStream( "../../res/words/E.png" ) ); 
            letter_f = ImageIO.read( getClass().getResourceAsStream( "../../res/words/F.png" ) ); 
            letter_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/G.png" ) ); 
            letter_h = ImageIO.read( getClass().getResourceAsStream( "../../res/words/H.png" ) ); 
            letter_i = ImageIO.read( getClass().getResourceAsStream( "../../res/words/I.png" ) ); 
            letter_j = ImageIO.read( getClass().getResourceAsStream( "../../res/words/J.png" ) ); 
            letter_k = ImageIO.read( getClass().getResourceAsStream( "../../res/words/K.png" ) ); 
            letter_l = ImageIO.read( getClass().getResourceAsStream( "../../res/words/L.png" ) ); 
            letter_m = ImageIO.read( getClass().getResourceAsStream( "../../res/words/M.png" ) ); 
            letter_n = ImageIO.read( getClass().getResourceAsStream( "../../res/words/N.png" ) ); 
            letter_o = ImageIO.read( getClass().getResourceAsStream( "../../res/words/O.png" ) ); 
            letter_p = ImageIO.read( getClass().getResourceAsStream( "../../res/words/P.png" ) ); 
            letter_q = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Q.png" ) ); 
            letter_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/R.png" ) ); 
            letter_s = ImageIO.read( getClass().getResourceAsStream( "../../res/words/S.png" ) ); 
            letter_t = ImageIO.read( getClass().getResourceAsStream( "../../res/words/T.png" ) ); 
            letter_u = ImageIO.read( getClass().getResourceAsStream( "../../res/words/U.png" ) ); 
            letter_v = ImageIO.read( getClass().getResourceAsStream( "../../res/words/V.png" ) ); 
            letter_w = ImageIO.read( getClass().getResourceAsStream( "../../res/words/W.png" ) ); 
            letter_x = ImageIO.read( getClass().getResourceAsStream( "../../res/words/X.png" ) ); 
            letter_y = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Y.png" ) ); 
            letter_z = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Z.png" ) ); 
            space = ImageIO.read( getClass().getResourceAsStream( "../../res/words/space.png" ) );
        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    public void update(){ 

        wordsX_1 = wordsX_1 - 5; 
       
        spriteCounter++; 
    } //end update

    public void draw( Graphics2D graphics2 ){ 

        //adds all the letter images into an array in order
        BufferedImage[] images = {letter_a, letter_b, letter_c, letter_d, letter_e, letter_f, letter_g, letter_h, letter_i, letter_j, letter_k, letter_l, letter_m, letter_n, letter_o, letter_p, letter_q, letter_r, letter_s, letter_t, letter_u, letter_v, letter_w, letter_x, letter_y, letter_z};
        
        // Only Works with lowercase letters!
        try {
            //The txt file has one word per line
            BufferedReader br = new BufferedReader ( new FileReader("mediumWords.txt") );
            String line = br.readLine() ;
            int i = 1; //keeps letters from overlapping

        while(line != null) {
            // create an array of ascii codes coresponding to each letter in the word
            byte[] bytes = line.getBytes("US-ASCII");
            for(byte letter : bytes) {

                //prints each letter corresponding to the ascii code. 
                //array index is letter - 97 because ascii code starting from lowercase a=97, b=98, c=99 ..etc
                graphics2.drawImage(images[letter - 97], ( wordsX_2 = wordsX_1 + ( i * gp.tileSize + ( gp.tileSize / 4 ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
                i++;
            }//end for

            //prints space here
            graphics2.drawImage(space, ( wordsX_2 = wordsX_1 + ( i * gp.tileSize + ( gp.tileSize / 4 ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
            i++;
            line = br.readLine();
        }//end while

        br.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }//end catch

 

/*
        graphics2.drawImage( letter_a, wordsX_1, wordsY, gp.tileSize, gp.tileSize, null ); 
        graphics2.drawImage( letter_b, ( wordsX_2 = wordsX_1 + ( gp.tileSize + ( gp.tileSize / 4 ) ) ), wordsY, gp.tileSize, gp.tileSize, null ); 
        graphics2.drawImage( letter_c, ( wordsX_2 = wordsX_1 + ( 2 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_d, ( wordsX_2 = wordsX_1 + ( 3 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_e, ( wordsX_2 = wordsX_1 + ( 4 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_f, ( wordsX_2 = wordsX_1 + ( 5 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_g, ( wordsX_2 = wordsX_1 + ( 6 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_h, ( wordsX_2 = wordsX_1 + ( 7 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_i, ( wordsX_2 = wordsX_1 + ( 8 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_j, ( wordsX_2 = wordsX_1 + ( 9 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_k, ( wordsX_2 = wordsX_1 + ( 10 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_l, ( wordsX_2 = wordsX_1 + ( 11 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_m, ( wordsX_2 = wordsX_1 + ( 12 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_n, ( wordsX_2 = wordsX_1 + ( 13 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_o, ( wordsX_2 = wordsX_1 + ( 14 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_p, ( wordsX_2 = wordsX_1 + ( 15 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_q, ( wordsX_2 = wordsX_1 + ( 16 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_r, ( wordsX_2 = wordsX_1 + ( 17 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_s, ( wordsX_2 = wordsX_1 + ( 18 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_t, ( wordsX_2 = wordsX_1 + ( 19 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_u, ( wordsX_2 = wordsX_1 + ( 20 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_v, ( wordsX_2 = wordsX_1 + ( 21 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_w, ( wordsX_2 = wordsX_1 + ( 22 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_x, ( wordsX_2 = wordsX_1 + ( 23 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_y, ( wordsX_2 = wordsX_1 + ( 24 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
        graphics2.drawImage( letter_z, ( wordsX_2 = wordsX_1 + ( 25 * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
*/
    } //end draw
} //end class
