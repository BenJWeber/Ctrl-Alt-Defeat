/**
 * 
 * CampaignActionWords.java
 * Description: Controls words above tumbleweed when in campaign state. 
 * Modified by: Remington Crichton, Benjamin Weber, Joey Troyer, Mohith Dontireddy
 * Date: April 30th, 2022
 * 
 */

package GUI_attempt.src.entity;

import GUI_attempt.src.main.GamePanel;
import GUI_attempt.src.main.InputHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; 

import javax.imageio.ImageIO;
import javax.lang.model.util.ElementScanner14;

public class CampaignActionWords extends Entity {
    GamePanel gp;
    InputHandler keyH;  
    int hold; 

    /**
     * Constructor 
     */
    public CampaignActionWords( GamePanel gp, InputHandler keyH ){ 
        this.gp = gp; 
        this.keyH = keyH; 

        setDefaultValues(); 
        getLetterImages(); 
    } //end constructor

    /**
     * Set Default Values 
     */
    public void setDefaultValues(){ 
        actionWordX_1 = 5000; 
        actionWordY = 5000; 
        int[] randomNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 
        hold = new Random().nextInt( randomNum.length); 
    } //end setDefaultValues

    /**
     * Import sprites for letters.  
     */
    public void getLetterImages(){
        try{ 
            letter_a_act = ImageIO.read( getClass().getResourceAsStream( "../words/A_ACT.png" ) ); 
            letter_b_act = ImageIO.read( getClass().getResourceAsStream( "../words/B_ACT.png" ) ); 
            letter_c_act = ImageIO.read( getClass().getResourceAsStream( "../words/C_ACT.png" ) ); 
            letter_d_act = ImageIO.read( getClass().getResourceAsStream( "../words/D_ACT.png" ) ); 
            letter_e_act = ImageIO.read( getClass().getResourceAsStream( "../words/E_ACT.png" ) ); 
            letter_f_act = ImageIO.read( getClass().getResourceAsStream( "../words/F_ACT.png" ) ); 
            letter_g_act = ImageIO.read( getClass().getResourceAsStream( "../words/G_ACT.png" ) ); 
            letter_h_act = ImageIO.read( getClass().getResourceAsStream( "../words/H_ACT.png" ) ); 
            letter_i_act = ImageIO.read( getClass().getResourceAsStream( "../words/I_ACT.png" ) ); 
            letter_j_act = ImageIO.read( getClass().getResourceAsStream( "../words/J_ACT.png" ) ); 
            letter_k_act = ImageIO.read( getClass().getResourceAsStream( "../words/K_ACT.png" ) ); 
            letter_l_act = ImageIO.read( getClass().getResourceAsStream( "../words/L_ACT.png" ) ); 
            letter_m_act = ImageIO.read( getClass().getResourceAsStream( "../words/M_ACT.png" ) ); 
            letter_n_act = ImageIO.read( getClass().getResourceAsStream( "../words/N_ACT.png" ) ); 
            letter_o_act = ImageIO.read( getClass().getResourceAsStream( "../words/O_ACT.png" ) ); 
            letter_p_act = ImageIO.read( getClass().getResourceAsStream( "../words/P_ACT.png" ) ); 
            letter_q_act = ImageIO.read( getClass().getResourceAsStream( "../words/Q_ACT.png" ) ); 
            letter_r_act = ImageIO.read( getClass().getResourceAsStream( "../words/R_ACT.png" ) ); 
            letter_s_act = ImageIO.read( getClass().getResourceAsStream( "../words/S_ACT.png" ) ); 
            letter_t_act = ImageIO.read( getClass().getResourceAsStream( "../words/T_ACT.png" ) ); 
            letter_u_act = ImageIO.read( getClass().getResourceAsStream( "../words/U_ACT.png" ) ); 
            letter_v_act = ImageIO.read( getClass().getResourceAsStream( "../words/V_ACT.png" ) ); 
            letter_w_act = ImageIO.read( getClass().getResourceAsStream( "../words/W_ACT.png" ) ); 
            letter_x_act = ImageIO.read( getClass().getResourceAsStream( "../words/X_ACT.png" ) ); 
            letter_y_act = ImageIO.read( getClass().getResourceAsStream( "../words/Y_ACT.png" ) ); 
            letter_z_act = ImageIO.read( getClass().getResourceAsStream( "../words/Z_ACT.png" ) ); 
        } //end try
        catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage

    /**
     * Generate random word from text file. 
     */
    public void getWords(){ 
        try {

        BufferedReader br = new BufferedReader( new FileReader( "action.txt" ) );

        ArrayList<String> words = new ArrayList<String>();
        String line = ""; 
        line = br.readLine();
        while( line != null ){ 
            words.add(line);
            line = br.readLine(); 
        }//end while
        br.close(); 

        //to make sure there is no duplicates
        ArrayList<String> correct = new ArrayList<String>();   
        Random rand = new Random();
        while (correct.size() < 10) {
            String random = words.get(rand.nextInt(10));
            if (!correct.contains(random)) {
                correct.add(random);
            }//end if
        }//end while

        correctWords = correct.toArray(correctWords);

        } catch ( IOException e) {
            e.printStackTrace();

            //if theres an IOException
            String[] empty = {"error", "error", "error"};
        }//end catch
    }//end getWords

    /**
     * Update position of word so it stays above tumble weed.  
     */
    public void update(){
        if( correctWords.length < 2 ){ 
            getWords(); 
        } 

        actionWordX_1 = gp.cTumble.tumbleX - 35; 
        actionWordY = gp.cTumble.tumbleY - 50; 

        if( actionWordX_1 < 1100 )
            tumbleIncoming = true;  
    } //end update

    /*
    * Draws words on screen. 
    */ 
    public void draw( Graphics2D graphics2 ){
        BufferedImage[] images_act = {letter_a_act, letter_b_act, letter_c_act, letter_d_act, letter_e_act, letter_f_act, letter_g_act, letter_h_act, letter_i_act, letter_j_act, letter_k_act, letter_l_act, letter_m_act, letter_n_act, letter_o_act, letter_p_act, letter_q_act, letter_r_act, letter_s_act, letter_t_act, letter_u_act, letter_v_act, letter_w_act, letter_x_act, letter_y_act, letter_z_act};
        BufferedImage imageLetter;  

        try {
            int i = 1; //keeps letters from overlapping

            byte[] bytes = correctWords[hold].getBytes("US-ASCII");
            actionCheck = correctWords[hold]; 
            int length = bytes.length; 

            for( int m = 0; m < length; m++ ) {
                imageLetter = images_act[bytes[m] - 97]; 
                graphics2.drawImage(imageLetter, ( actionWordX_2 = actionWordX_1 + ( i * ( gp.tileSize/5 + ( gp.tileSize / 5 ) ) ) ), actionWordY, gp.tileSize/3, gp.tileSize/3, null );
                i++;  
            } //end for
        } //end try
        catch ( IOException e) {
            e.printStackTrace();
        }//end catch
    }//end draw
} //end Class
