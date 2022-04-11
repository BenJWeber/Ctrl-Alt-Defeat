/*
* Entity.java
* Contains public characteristics for entities. 
*/

package GUI_attempt.src.entity;

import java.awt.image.BufferedImage; 

public class Entity {
    public int playerX, playerY, worldX, worldY, monsterX, monsterY, tumbleX, tumbleY, wordStreamX_1, wordStreamX_2, liveWordsX, liveWordsY, 
        wordsY, letterX, cursorX, lengthHold, speed, liveCounter, wordCounter, currentLength, numWords, pace, spriteCounter = 0, spriteNum = 1,
        actionWordX_1, actionWordX_2, actionWordY;

    public BufferedImage forward1, forward2, jump, monster1, monster2, tumble1, tumble2, tumble3, tumble4,
        letter_a, letter_b, letter_c, letter_d, letter_e, letter_f, letter_g, letter_h, 
        letter_i, letter_j, letter_k, letter_l, letter_m, letter_n, letter_o, letter_p, 
        letter_q, letter_r, letter_s, letter_t, letter_u, letter_v, letter_w, letter_x, 
        letter_y, letter_z, 

        letter_a_gr, letter_b_gr, letter_c_gr, letter_d_gr, letter_e_gr, letter_f_gr, letter_g_gr, 
        letter_h_gr, letter_i_gr, letter_j_gr, letter_k_gr, letter_l_gr, letter_m_gr, letter_n_gr, 
        letter_o_gr, letter_p_gr, letter_q_gr,letter_r_gr, letter_s_gr, letter_t_gr, letter_u_gr, 
        letter_v_gr, letter_w_gr, letter_x_gr, letter_y_gr, letter_z_gr,

        letter_a_g, letter_b_g, letter_c_g, letter_d_g, letter_e_g, letter_f_g, letter_g_g, 
        letter_h_g, letter_i_g, letter_j_g, letter_k_g, letter_l_g, letter_m_g, letter_n_g, 
        letter_o_g, letter_p_g, letter_q_g,letter_r_g, letter_s_g, letter_t_g, letter_u_g, 
        letter_v_g, letter_w_g, letter_x_g, letter_y_g, letter_z_g, 
        
        letter_a_r, letter_b_r, letter_c_r, letter_d_r, letter_e_r, letter_f_r, letter_g_r, 
        letter_h_r, letter_i_r, letter_j_r, letter_k_r, letter_l_r, letter_m_r, letter_n_r, 
        letter_o_r, letter_p_r, letter_q_r, letter_r_r, letter_s_r, letter_t_r, letter_u_r, 
        letter_v_r, letter_w_r, letter_x_r, letter_y_r, letter_z_r, 

        letter_a_act, letter_b_act, letter_c_act, letter_d_act, letter_e_act, letter_f_act, letter_g_act, 
        letter_h_act, letter_i_act, letter_j_act, letter_k_act, letter_l_act, letter_m_act, letter_n_act, 
        letter_o_act, letter_p_act, letter_q_act,letter_r_act, letter_s_act, letter_t_act, letter_u_act, 
        letter_v_act, letter_w_act, letter_x_act, letter_y_act, letter_z_act, 

        cursor, space, pause, play; 
        
    public String direction, color, colorVerified, colorVerifiedLive, compareWord, userInput, cursor_space, actionCheck;

    public static String difficulty; 

    public String[] correctWords = { " " }, currentWords = {"1", "2", "3"}; 

    public boolean keyPressFlag = false, resetFlag = false, tumbleIncoming = false; 
} //end class