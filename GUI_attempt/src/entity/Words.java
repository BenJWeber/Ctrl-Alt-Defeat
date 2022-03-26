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

public class Words extends Entity {
    GamePanel gp;
    InputHandler keyH; 
    String color = "BLACK";
    String[] correctWords = getWords();
    String[] correctLetters; 
    boolean colorFlag = false; 

    public Words( GamePanel gp, InputHandler keyH ){ 
        this.gp = gp; 
        this.keyH = keyH; 

        setDefaultValues(); 
        getLetterImages(); 
    } //end Player

    public void setDefaultValues(){ 
        wordsX_1 = 1000; 
        wordsY = 250;
    } //end setDefaultValues

    public void getLetterImages(){
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

            letter_a_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/A_G.png" ) ); 
            letter_b_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/B_G.png" ) ); 
            letter_c_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/C_G.png" ) ); 
            letter_d_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/D_G.png" ) ); 
            letter_e_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/E_G.png" ) ); 
            letter_f_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/F_G.png" ) ); 
            letter_g_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/G_G.png" ) ); 
            letter_h_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/H_G.png" ) ); 
            letter_i_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/I_G.png" ) ); 
            letter_j_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/J_G.png" ) ); 
            letter_k_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/K_G.png" ) ); 
            letter_l_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/L_G.png" ) ); 
            letter_m_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/M_G.png" ) ); 
            letter_n_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/N_G.png" ) ); 
            letter_o_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/O_G.png" ) ); 
            letter_p_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/P_G.png" ) ); 
            letter_q_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Q_G.png" ) ); 
            letter_r_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/R_G.png" ) ); 
            letter_s_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/S_G.png" ) ); 
            letter_t_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/T_G.png" ) ); 
            letter_u_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/U_G.png" ) ); 
            letter_v_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/V_G.png" ) ); 
            letter_w_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/W_G.png" ) ); 
            letter_x_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/X_G.png" ) ); 
            letter_y_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Y_G.png" ) ); 
            letter_z_g = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Z_G.png" ) ); 

            letter_a_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/A_R.png" ) ); 
            letter_b_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/B_R.png" ) ); 
            letter_c_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/C_R.png" ) ); 
            letter_d_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/D_R.png" ) ); 
            letter_e_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/E_R.png" ) ); 
            letter_f_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/F_R.png" ) ); 
            letter_g_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/G_R.png" ) ); 
            letter_h_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/H_R.png" ) ); 
            letter_i_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/I_R.png" ) ); 
            letter_j_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/J_R.png" ) ); 
            letter_k_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/K_R.png" ) ); 
            letter_l_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/L_R.png" ) ); 
            letter_m_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/M_R.png" ) ); 
            letter_n_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/N_R.png" ) ); 
            letter_o_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/O_R.png" ) ); 
            letter_p_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/P_R.png" ) ); 
            letter_q_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Q_R.png" ) ); 
            letter_r_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/R_R.png" ) ); 
            letter_s_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/S_R.png" ) ); 
            letter_t_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/T_R.png" ) ); 
            letter_u_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/U_R.png" ) ); 
            letter_v_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/V_R.png" ) ); 
            letter_w_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/W_R.png" ) ); 
            letter_x_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/X_R.png" ) ); 
            letter_y_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Y_R.png" ) ); 
            letter_z_r = ImageIO.read( getClass().getResourceAsStream( "../../res/words/Z_R.png" ) );

            space = ImageIO.read( getClass().getResourceAsStream( "../../res/words/space.png" ) );

        } catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } //end getPlayerImage



    public void update(){

        wordsX_1 = wordsX_1 - 5; 
       
        spriteCounter++; 
    } //end update



    public static String[] getWords(){ 
        try {
        String files[] = {"easyWords.txt", "mediumWords.txt", "hardWords.txt"};                     
        BufferedReader br = new BufferedReader( new FileReader( files[1] ) );

        ArrayList<String> words = new ArrayList<String>();
        String line = br.readLine();
        while( line != null ){ 
            words.add(line);
            line = br.readLine(); 
        }//end while
        br.close(); 

        /* commented out for testing
        //to make sure there is no duplicates
        ArrayList<String> correct = new ArrayList<String>();   
        Random rand = new Random();
        while (correct.size() < 17) {
            String random = words.get(rand.nextInt(50));
            if (!correct.contains(random)) {
                correct.add(random);
            }//end if
        }//end while

        String[] correctWords = new String[correct.size()];
        correctWords = correct.toArray(correctWords);

        return correctWords;
        */

        //To use random words generation  uncomment code above and comment out next three lines
        String[] correctWords = new String[words.size()];
        correctWords = words.toArray(correctWords);
        return correctWords;
        
    } catch ( IOException e) {
        e.printStackTrace();
    }//end catch

    //if theres an IOException
    String[] empty = {"error", "error", "error"};
    return empty;
    }//end getWords

    public void draw( Graphics2D graphics2 ){
        //in the future id imagine we would just be reading in every character they type in
        String exampleInput = "elbow grown mesay rider crate hello noble";
        exampleInput = exampleInput.replace(" ", "");
        String[] input = exampleInput.split("");

        BufferedImage[] images_green = {letter_a_g, letter_b_g, letter_c_g, letter_d_g, letter_e_g, letter_f_g, letter_g_g, letter_h_g, letter_i_g, letter_j_g, letter_k_g, letter_l_g, letter_m_g, letter_n_g, letter_o_g, letter_p_g, letter_q_g, letter_r_g, letter_s_g, letter_t_g, letter_u_g, letter_v_g, letter_w_g, letter_x_g, letter_y_g, letter_z_g};
        BufferedImage[] images_red = {letter_a_r, letter_b_r, letter_c_r, letter_d_r, letter_e_r, letter_f_r, letter_g_r, letter_h_r, letter_i_r, letter_j_r, letter_k_r, letter_l_r, letter_m_r, letter_n_r, letter_o_r, letter_p_r, letter_q_r, letter_r_r, letter_s_r, letter_t_r, letter_u_r, letter_v_r, letter_w_r, letter_x_r, letter_y_r, letter_z_r};
        BufferedImage[] images = {letter_a, letter_b, letter_c, letter_d, letter_e, letter_f, letter_g, letter_h, letter_i, letter_j, letter_k, letter_l, letter_m, letter_n, letter_o, letter_p, letter_q, letter_r, letter_s, letter_t, letter_u, letter_v, letter_w, letter_x, letter_y, letter_z};
        BufferedImage imageLetter; 
        try {
            int i = 1; //keeps letters from overlapping
            int k = 0; //indexes for the arrays
        for(int x = 0; x < correctWords.length; x++) {
            color = "BLACK";
            // create an array of ascii codes coresponding to each letter in the word
            byte[] bytes = correctWords[x].getBytes("US-ASCII");
            for(byte letter : bytes) {
                
            //checks if input is correct and sets color
            if(k < exampleInput.length()) { 
                if(input[k].charAt(0) == letter)
                    color = "GREEN";
                else
                    color = "RED";
            }//end if

                //array index is letter - 97 because ascii code starting from lowercase a=97, b=98, c=99 ..etc            
                switch( color ){ 
                    case "GREEN": //User got letter correct
                        if( colorFlag == false )
                            imageLetter = images_green[ letter - 97 ]; 
                        else
                            imageLetter = images[ letter - 97 ]; 

                        System.out.println( letter ); 
                        colorFlag = true; 
                        break; 
                    case "RED":  //user got letter wrong
                        imageLetter = images_red[ letter - 97 ];
                        break;
                    default:      //User has not attempted letter
                       imageLetter = images[letter - 97]; 
                       break;
                } //end switch
            

                graphics2.drawImage(imageLetter, ( wordsX_2 = wordsX_1 + ( i * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
                i++; 
                k++;
            }//end for

            //prints space here
            graphics2.drawImage(space, ( wordsX_2 = wordsX_1 + ( i * ( gp.tileSize + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize, gp.tileSize, null );
            i++;
        } //end for

        } catch ( IOException e) {
            e.printStackTrace();
        }//end catch

    }//end draw

} //end class