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
    /*
    * Set variables for class. 
    */ 
    GamePanel gp;
    InputHandler keyH;  
  
    /*
    * Call methods. 
    */ 
    public Words( GamePanel gp, InputHandler keyH ){ 
        this.gp = gp; 
        this.keyH = keyH; 

        setDefaultValues(); 
        getLetterImages(); 
        //correctWords = getWords(); 
    } //end Player

    /*
    * Set default Values. 
    */ 
    public void setDefaultValues(){ 
        System.out.println( "RESET RESET" ); 
        wordStreamX_1 = 30; 
        cursorX = 500; 
        liveWordsX = 500;
        liveWordsY = 300;  
        wordsY = 200;
        wordCounter = 0; //Changed to 0 from 1 - RC - 3/29 
        liveCounter = 0; 
        currentLength = 3;
        numWords = 100;
        pace = 0; 
        color = "BLACK"; 
        colorVerified = "RED"; 
        colorVerifiedLive = "BLACK"; 
        compareWord = ""; 
        userInput = ""; 
        cursor_space = "cursor"; 
        difficulty = ""; 
    } //end setDefaultValues

    /*
    * Get images for letters. 
    */ 
    public void getLetterImages(){
        try{ 
            letter_a = ImageIO.read( getClass().getResourceAsStream( "../words/A.png" ) ); 
            letter_b = ImageIO.read( getClass().getResourceAsStream( "../words/B.png" ) ); 
            letter_c = ImageIO.read( getClass().getResourceAsStream( "../words/C.png" ) ); 
            letter_d = ImageIO.read( getClass().getResourceAsStream( "../words/D.png" ) ); 
            letter_e = ImageIO.read( getClass().getResourceAsStream( "../words/E.png" ) ); 
            letter_f = ImageIO.read( getClass().getResourceAsStream( "../words/F.png" ) ); 
            letter_g = ImageIO.read( getClass().getResourceAsStream( "../words/G.png" ) ); 
            letter_h = ImageIO.read( getClass().getResourceAsStream( "../words/H.png" ) ); 
            letter_i = ImageIO.read( getClass().getResourceAsStream( "../words/I.png" ) ); 
            letter_j = ImageIO.read( getClass().getResourceAsStream( "../words/J.png" ) ); 
            letter_k = ImageIO.read( getClass().getResourceAsStream( "../words/K.png" ) ); 
            letter_l = ImageIO.read( getClass().getResourceAsStream( "../words/L.png" ) ); 
            letter_m = ImageIO.read( getClass().getResourceAsStream( "../words/M.png" ) ); 
            letter_n = ImageIO.read( getClass().getResourceAsStream( "../words/N.png" ) ); 
            letter_o = ImageIO.read( getClass().getResourceAsStream( "../words/O.png" ) ); 
            letter_p = ImageIO.read( getClass().getResourceAsStream( "../words/P.png" ) ); 
            letter_q = ImageIO.read( getClass().getResourceAsStream( "../words/Q.png" ) ); 
            letter_r = ImageIO.read( getClass().getResourceAsStream( "../words/R.png" ) ); 
            letter_s = ImageIO.read( getClass().getResourceAsStream( "../words/S.png" ) ); 
            letter_t = ImageIO.read( getClass().getResourceAsStream( "../words/T.png" ) ); 
            letter_u = ImageIO.read( getClass().getResourceAsStream( "../words/U.png" ) ); 
            letter_v = ImageIO.read( getClass().getResourceAsStream( "../words/V.png" ) ); 
            letter_w = ImageIO.read( getClass().getResourceAsStream( "../words/W.png" ) ); 
            letter_x = ImageIO.read( getClass().getResourceAsStream( "../words/X.png" ) ); 
            letter_y = ImageIO.read( getClass().getResourceAsStream( "../words/Y.png" ) ); 
            letter_z = ImageIO.read( getClass().getResourceAsStream( "../words/Z.png" ) ); 

            letter_a_gr = ImageIO.read( getClass().getResourceAsStream( "../words/A_GR.png" ) ); 
            letter_b_gr = ImageIO.read( getClass().getResourceAsStream( "../words/B_GR.png" ) ); 
            letter_c_gr = ImageIO.read( getClass().getResourceAsStream( "../words/C_GR.png" ) ); 
            letter_d_gr = ImageIO.read( getClass().getResourceAsStream( "../words/D_GR.png" ) ); 
            letter_e_gr = ImageIO.read( getClass().getResourceAsStream( "../words/E_GR.png" ) ); 
            letter_f_gr = ImageIO.read( getClass().getResourceAsStream( "../words/F_GR.png" ) ); 
            letter_g_gr = ImageIO.read( getClass().getResourceAsStream( "../words/G_GR.png" ) ); 
            letter_h_gr = ImageIO.read( getClass().getResourceAsStream( "../words/H_GR.png" ) ); 
            letter_i_gr = ImageIO.read( getClass().getResourceAsStream( "../words/I_GR.png" ) ); 
            letter_j_gr = ImageIO.read( getClass().getResourceAsStream( "../words/J_GR.png" ) ); 
            letter_k_gr = ImageIO.read( getClass().getResourceAsStream( "../words/K_GR.png" ) ); 
            letter_l_gr = ImageIO.read( getClass().getResourceAsStream( "../words/L_GR.png" ) ); 
            letter_m_gr = ImageIO.read( getClass().getResourceAsStream( "../words/M_GR.png" ) ); 
            letter_n_gr = ImageIO.read( getClass().getResourceAsStream( "../words/N_GR.png" ) ); 
            letter_o_gr = ImageIO.read( getClass().getResourceAsStream( "../words/O_GR.png" ) ); 
            letter_p_gr = ImageIO.read( getClass().getResourceAsStream( "../words/P_GR.png" ) ); 
            letter_q_gr = ImageIO.read( getClass().getResourceAsStream( "../words/Q_GR.png" ) ); 
            letter_r_gr = ImageIO.read( getClass().getResourceAsStream( "../words/R_GR.png" ) ); 
            letter_s_gr = ImageIO.read( getClass().getResourceAsStream( "../words/S_GR.png" ) ); 
            letter_t_gr = ImageIO.read( getClass().getResourceAsStream( "../words/T_GR.png" ) ); 
            letter_u_gr = ImageIO.read( getClass().getResourceAsStream( "../words/U_GR.png" ) ); 
            letter_v_gr = ImageIO.read( getClass().getResourceAsStream( "../words/V_GR.png" ) ); 
            letter_w_gr = ImageIO.read( getClass().getResourceAsStream( "../words/W_GR.png" ) ); 
            letter_x_gr = ImageIO.read( getClass().getResourceAsStream( "../words/X_GR.png" ) ); 
            letter_y_gr = ImageIO.read( getClass().getResourceAsStream( "../words/Y_GR.png" ) ); 
            letter_z_gr = ImageIO.read( getClass().getResourceAsStream( "../words/Z_GR.png" ) );

            letter_a_g = ImageIO.read( getClass().getResourceAsStream( "../words/A_G.png" ) ); 
            letter_b_g = ImageIO.read( getClass().getResourceAsStream( "../words/B_G.png" ) ); 
            letter_c_g = ImageIO.read( getClass().getResourceAsStream( "../words/C_G.png" ) ); 
            letter_d_g = ImageIO.read( getClass().getResourceAsStream( "../words/D_G.png" ) ); 
            letter_e_g = ImageIO.read( getClass().getResourceAsStream( "../words/E_G.png" ) ); 
            letter_f_g = ImageIO.read( getClass().getResourceAsStream( "../words/F_G.png" ) ); 
            letter_g_g = ImageIO.read( getClass().getResourceAsStream( "../words/G_G.png" ) ); 
            letter_h_g = ImageIO.read( getClass().getResourceAsStream( "../words/H_G.png" ) ); 
            letter_i_g = ImageIO.read( getClass().getResourceAsStream( "../words/I_G.png" ) ); 
            letter_j_g = ImageIO.read( getClass().getResourceAsStream( "../words/J_G.png" ) ); 
            letter_k_g = ImageIO.read( getClass().getResourceAsStream( "../words/K_G.png" ) ); 
            letter_l_g = ImageIO.read( getClass().getResourceAsStream( "../words/L_G.png" ) ); 
            letter_m_g = ImageIO.read( getClass().getResourceAsStream( "../words/M_G.png" ) ); 
            letter_n_g = ImageIO.read( getClass().getResourceAsStream( "../words/N_G.png" ) ); 
            letter_o_g = ImageIO.read( getClass().getResourceAsStream( "../words/O_G.png" ) ); 
            letter_p_g = ImageIO.read( getClass().getResourceAsStream( "../words/P_G.png" ) ); 
            letter_q_g = ImageIO.read( getClass().getResourceAsStream( "../words/Q_G.png" ) ); 
            letter_r_g = ImageIO.read( getClass().getResourceAsStream( "../words/R_G.png" ) ); 
            letter_s_g = ImageIO.read( getClass().getResourceAsStream( "../words/S_G.png" ) ); 
            letter_t_g = ImageIO.read( getClass().getResourceAsStream( "../words/T_G.png" ) ); 
            letter_u_g = ImageIO.read( getClass().getResourceAsStream( "../words/U_G.png" ) ); 
            letter_v_g = ImageIO.read( getClass().getResourceAsStream( "../words/V_G.png" ) ); 
            letter_w_g = ImageIO.read( getClass().getResourceAsStream( "../words/W_G.png" ) ); 
            letter_x_g = ImageIO.read( getClass().getResourceAsStream( "../words/X_G.png" ) ); 
            letter_y_g = ImageIO.read( getClass().getResourceAsStream( "../words/Y_G.png" ) ); 
            letter_z_g = ImageIO.read( getClass().getResourceAsStream( "../words/Z_G.png" ) ); 

            letter_a_r = ImageIO.read( getClass().getResourceAsStream( "../words/A_R.png" ) ); 
            letter_b_r = ImageIO.read( getClass().getResourceAsStream( "../words/B_R.png" ) ); 
            letter_c_r = ImageIO.read( getClass().getResourceAsStream( "../words/C_R.png" ) ); 
            letter_d_r = ImageIO.read( getClass().getResourceAsStream( "../words/D_R.png" ) ); 
            letter_e_r = ImageIO.read( getClass().getResourceAsStream( "../words/E_R.png" ) ); 
            letter_f_r = ImageIO.read( getClass().getResourceAsStream( "../words/F_R.png" ) ); 
            letter_g_r = ImageIO.read( getClass().getResourceAsStream( "../words/G_R.png" ) ); 
            letter_h_r = ImageIO.read( getClass().getResourceAsStream( "../words/H_R.png" ) ); 
            letter_i_r = ImageIO.read( getClass().getResourceAsStream( "../words/I_R.png" ) ); 
            letter_j_r = ImageIO.read( getClass().getResourceAsStream( "../words/J_R.png" ) ); 
            letter_k_r = ImageIO.read( getClass().getResourceAsStream( "../words/K_R.png" ) ); 
            letter_l_r = ImageIO.read( getClass().getResourceAsStream( "../words/L_R.png" ) ); 
            letter_m_r = ImageIO.read( getClass().getResourceAsStream( "../words/M_R.png" ) ); 
            letter_n_r = ImageIO.read( getClass().getResourceAsStream( "../words/N_R.png" ) ); 
            letter_o_r = ImageIO.read( getClass().getResourceAsStream( "../words/O_R.png" ) ); 
            letter_p_r = ImageIO.read( getClass().getResourceAsStream( "../words/P_R.png" ) ); 
            letter_q_r = ImageIO.read( getClass().getResourceAsStream( "../words/Q_R.png" ) ); 
            letter_r_r = ImageIO.read( getClass().getResourceAsStream( "../words/R_R.png" ) ); 
            letter_s_r = ImageIO.read( getClass().getResourceAsStream( "../words/S_R.png" ) ); 
            letter_t_r = ImageIO.read( getClass().getResourceAsStream( "../words/T_R.png" ) ); 
            letter_u_r = ImageIO.read( getClass().getResourceAsStream( "../words/U_R.png" ) ); 
            letter_v_r = ImageIO.read( getClass().getResourceAsStream( "../words/V_R.png" ) ); 
            letter_w_r = ImageIO.read( getClass().getResourceAsStream( "../words/W_R.png" ) ); 
            letter_x_r = ImageIO.read( getClass().getResourceAsStream( "../words/X_R.png" ) ); 
            letter_y_r = ImageIO.read( getClass().getResourceAsStream( "../words/Y_R.png" ) ); 
            letter_z_r = ImageIO.read( getClass().getResourceAsStream( "../words/Z_R.png" ) );

            cursor = ImageIO.read( getClass().getResourceAsStream( "../words/cursor.png" ) ); 
            space = ImageIO.read( getClass().getResourceAsStream( "../words/space.png" ) );
            pause = ImageIO.read( getClass().getResourceAsStream( "../icons/pause.png" ) );
            play = ImageIO.read( getClass().getResourceAsStream( "../icons/play.png" ) );

        } //end try
        catch( IOException e ){ 
            e.printStackTrace(); 
        } //end catch
    } 

    /*
    * Place words into array from File. 
    */
    public void getWords(){ 
        System.out.println( "GET WORDS" ); 
        int count = 0; 
        String spaceString = "      "; 
        try {

        BufferedReader br = new BufferedReader( new FileReader( difficulty ) );

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
        while (correct.size() < 100) {
            if( count == 0 ){ 
                correct.add( spaceString ); 
                count++; 
            }
            String random = words.get(rand.nextInt(100));
            if (!correct.contains(random)) {
                correct.add(random);
            }//end if
        }//end while

        correctWords = correct.toArray(correctWords);

        } catch ( IOException e) {
            e.printStackTrace();
            System.out.println( "Yo man I got stuck in JAIL JAIL"); 

            //if theres an IOException
            String[] empty = {"error", "error", "error"};
        }//end catch
    }//end getWords

    /*
    * Checks if user typed correct character. 
    */ 
    public void getUserInput(){ 
        if( keyH.aPressed ){ 
            userInput = userInput + "a";
            keyH.aPressed = false;  
            keyPressFlag = true; 
        } //end if
        else if( keyH.bPressed ){ 
            userInput = userInput + "b";
            keyH.bPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.cPressed ){ 
            userInput = userInput + "c";
            keyH.cPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.dPressed ){ 
            userInput = userInput + "d";
            keyH.dPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.ePressed ){ 
            userInput = userInput + "e";
            keyH.ePressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.fPressed ){ 
            userInput = userInput + "f";
            keyH.fPressed = false;
        } //end else if
        else if( keyH.gPressed ){ 
            userInput = userInput + "g";
            keyH.gPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.hPressed ){ 
            userInput = userInput + "h";
            keyH.hPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.iPressed ){ 
            userInput = userInput + "i";
            keyH.iPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.jPressed ){ 
            userInput = userInput + "j";
            keyH.jPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.kPressed ){ 
            userInput = userInput + "k";
            keyH.kPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.lPressed ){ 
            userInput = userInput + "l";
            keyH.lPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.mPressed ){ 
            userInput = userInput + "m";
            keyH.mPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.nPressed ){ 
            userInput = userInput + "n";
            keyH.nPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.oPressed ){ 
            userInput = userInput + "o";
            keyH.oPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.pPressed ){ 
            userInput = userInput + "p";
            keyH.pPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.qPressed ){ 
            userInput = userInput + "q";
            keyH.qPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.rPressed ){ 
            userInput = userInput + "r";
            keyH.rPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.sPressed ){ 
            userInput = userInput + "s";
            keyH.sPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.tPressed ){ 
            userInput = userInput + "t";
            keyH.tPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.uPressed ){ 
            userInput = userInput + "u";
            keyH.uPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.vPressed ){ 
            userInput = userInput + "v";
            keyH.vPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.wPressed ){ 
            userInput = userInput + "w";
            keyH.wPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.xPressed ){ 
            userInput = userInput + "x";
            keyH.xPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.yPressed ){ 
            userInput = userInput + "y";
            keyH.yPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.zPressed ){ 
            userInput = userInput + "z";
            keyH.zPressed = false;
            keyPressFlag = true;
        } //end else if
        else if( keyH.backSpacePressed ){   
            if( userInput.length() > 0 ){
                userInput = userInput.substring( 0, userInput.length() - 1 );
            } 
            keyH.backSpacePressed = false;  
        } //end else if
    } //end getUserInput

    /*
    * Once user hits space check if typed word is correct. 
    */
    public void checkUserInput(){ 
        if( userInput.equals( gp.action.actionCheck ) == true ){ 
            gp.jumpFlag = true; 
            gp.calculate.correctWordsTotal++; 
        } //end if
        else{ 
            if( userInput.equals( compareWord ) == true ){ 
                colorVerified = "GREEN";
                gp.increaseSpeed = true;  
                gp.calculate.correctWordsTotal++; 
            } //end if
            else{
                colorVerified = "RED";
                gp.decreaseSpeed = true;   
            } //end else
        } //end else
        userInput = ""; 
    } //end checkUserInput

    /*
    * Check user input before user hits space.
    * Allows for live feedback. 
    */
    public void checkUserInputLive(){ 
        if( userInput.length() <= compareWord.length() ){ 
            String check  = compareWord.substring( 0, userInput.length() ); 

            if( userInput.equals( check ) == true ){ 
                colorVerifiedLive = "BLACK"; 
            } //end if
            else    
                colorVerifiedLive = "RED"; 
        } //end if
        else
            colorVerifiedLive = "RED"; 
    } //end checkUserInputLive

    /*
    * Calls checkUserInput. 
    * Checks if user entered space. 
    * When space is hit, updates words/positions. 
    */ 
    public void update(){
        if( correctWords.length < 50 || resetFlag ){ 
            getWords(); 
            resetFlag = false; 
        } 
        int j = 0; 
 
        getUserInput(); 
        checkUserInputLive();

        if ( pace > 20 ){ //Control speed of cursor
            if( cursor_space == "space" )
                cursor_space = "cursor"; 
            else if( cursor_space == "cursor" )
                cursor_space = "space";
            pace = 0; 
        } //end if

        if( keyPressFlag ){ //Increment location of cursor
            liveCounter++; 
            if( keyH.backSpacePressed )
                liveCounter = liveCounter - 2; 
            cursorX = liveCounter * 40 + 500; 
            keyPressFlag = false; 
        } //end if

        pace++; 

        for( int i = wordCounter; i < wordCounter + currentLength && i < numWords; i++ ){ //Current words always contains three words from correct words
            currentWords[ j ] = correctWords[ i ];
            j++;  
        } //end for

        if( keyH.spacePressed == true ){ //Iterate words through current words and reset cursor location. 
            wordCounter++; 
            liveCounter = 0; 

            checkUserInput();  

            if( wordCounter == correctWords.length - 2 ) //Allows last word to make it to center. 
                currentLength = 2; 
            
            if( wordCounter == correctWords.length - 1 ) //Allows last word to make it to the left of center. 
                currentLength = 1; 

            keyH.spacePressed = false; 
        } //end if
    } //end update

    /*
    * Draws words. 
    */ 
    public void draw( Graphics2D graphics2 ){
        BufferedImage[] images_green = {letter_a_g, letter_b_g, letter_c_g, letter_d_g, letter_e_g, letter_f_g, letter_g_g, letter_h_g, letter_i_g, letter_j_g, letter_k_g, letter_l_g, letter_m_g, letter_n_g, letter_o_g, letter_p_g, letter_q_g, letter_r_g, letter_s_g, letter_t_g, letter_u_g, letter_v_g, letter_w_g, letter_x_g, letter_y_g, letter_z_g};
        BufferedImage[] images_red = {letter_a_r, letter_b_r, letter_c_r, letter_d_r, letter_e_r, letter_f_r, letter_g_r, letter_h_r, letter_i_r, letter_j_r, letter_k_r, letter_l_r, letter_m_r, letter_n_r, letter_o_r, letter_p_r, letter_q_r, letter_r_r, letter_s_r, letter_t_r, letter_u_r, letter_v_r, letter_w_r, letter_x_r, letter_y_r, letter_z_r};
        BufferedImage[] images_grey = {letter_a_gr, letter_b_gr, letter_c_gr, letter_d_gr, letter_e_gr, letter_f_gr, letter_g_gr, letter_h_gr, letter_i_gr, letter_j_gr, letter_k_gr, letter_l_gr, letter_m_gr, letter_n_gr, letter_o_gr, letter_p_gr, letter_q_gr, letter_r_gr, letter_s_gr, letter_t_gr, letter_u_gr, letter_v_gr, letter_w_gr, letter_x_gr, letter_y_gr, letter_z_gr};
        BufferedImage[] images = {letter_a, letter_b, letter_c, letter_d, letter_e, letter_f, letter_g, letter_h, letter_i, letter_j, letter_k, letter_l, letter_m, letter_n, letter_o, letter_p, letter_q, letter_r, letter_s, letter_t, letter_u, letter_v, letter_w, letter_x, letter_y, letter_z};
        BufferedImage imageLetter;  
        int wordIndex = 0; 
        int k = 0; 

        try {
            int i = 1; //keeps letters from overlapping

            for( int x = wordIndex; x < currentLength; x++ ){ 
                byte[] bytes = currentWords[x].getBytes("US-ASCII");
                int length = bytes.length; 
                if( x == 0 || x == 2 )
                    color = "GREY"; 
                else{     
                    color = "BLACK"; 
                } //end else

                for( int m = 0; m < length; m++ ) {
                        //array index is letter - 97 because ascii code starting from lowercase a=97, b=98, c=99 ..etc 
                        if( x == 1)
                            compareWord = currentWords[x];  

                        else if( x == 0 )
                            color = colorVerified; 

                        switch( color ){ 
                            case "GREEN": //User got letter correct
                                if( bytes[m] - 97 == -65 )
                                    imageLetter = space; 
                                else
                                    imageLetter = images_green[ bytes[m] - 97 ]; 
                                break; 
                            case "RED":  //user got letter wrong
                                if( bytes[m] - 97 == -65 )
                                    imageLetter = space; 
                                else
                                    imageLetter = images_red[ bytes[m] - 97 ];
                                break;
                            case "GREY": 
                                if( bytes[m] -97 == -65 )
                                    imageLetter = space; 
                                else
                                    imageLetter = images_grey[ bytes[m] - 97 ]; 
                                break; 
                            default:      //User has not attempted letter
                                if( bytes[m] - 97 == -65 )
                                    imageLetter = space; 
                                else
                                    imageLetter = images[bytes[m] - 97]; 
                                break;
                        } //end switch
                        if( x == 1 )
                            graphics2.drawImage(imageLetter, wordStreamX_2 = wordStreamX_1 + ( i * ( gp.tileSize/2 + ( gp.tileSize / 4 ) ) ), wordsY, gp.tileSize/2, gp.tileSize/2, null );
                        else
                            graphics2.drawImage(imageLetter, wordStreamX_2 = wordStreamX_1 + ( i * ( gp.tileSize/2 + ( gp.tileSize / 4 ) ) ), wordsY, gp.tileSize/3, gp.tileSize/3, null );
                        i++; 
                   // } //end while
                }//end inner for

                graphics2.drawImage(space, ( wordStreamX_2 = wordStreamX_1 + ( i * ( gp.tileSize/2 + ( gp.tileSize / 4 ) ) ) ), wordsY, gp.tileSize/2, gp.tileSize/2, null );
                i++; 
            } //end outer for

            byte[] bytes = userInput.getBytes("US-ASCII");

            int length = bytes.length;

            if( length == 0 ){ 
                if( cursor_space == "cursor" )
                    graphics2.drawImage(cursor, 500, liveWordsY, gp.tileSize/3, gp.tileSize/3, null );
                if( cursor_space == "space" )
                    graphics2.drawImage(space, 500, liveWordsY, gp.tileSize/3, gp.tileSize/3, null );
            } //end if
            else{ 
                if( cursor_space == "cursor" )
                    graphics2.drawImage(cursor, cursorX, liveWordsY, gp.tileSize/3, gp.tileSize/3, null );
                if( cursor_space == "space" )
                    graphics2.drawImage(space, cursorX, liveWordsY, gp.tileSize/3, gp.tileSize/3, null );
            } //end else

            for( int m = 0; m < length; m++ ) { //Display live user input
                if( colorVerifiedLive == "RED" )
                    imageLetter = images_red[bytes[m] - 97];
                else
                    imageLetter = images[bytes[m] - 97]; 

                letterX = ( liveWordsX ) + ( k * ( gp.tileSize/4 + ( gp.tileSize / 4 ) ) ); 
                
                graphics2.drawImage(imageLetter, letterX, liveWordsY, gp.tileSize/3, gp.tileSize/3, null );
                k++; 
            } //end for 

            //pause/play button
            if(GamePanel.State == GamePanel.STATE.game)
               graphics2.drawImage(pause, 1235, 3, gp.tileSize/2, gp.tileSize/2, null );
            else if(GamePanel.State == GamePanel.STATE.pause)
               graphics2.drawImage(play, 1235, 3, gp.tileSize/2, gp.tileSize/2, null );

        } //end try
        catch ( IOException e) {
            e.printStackTrace();
        }//end catch
    }//end draw
} //end class