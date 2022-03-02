/*
* Entity.java
* Contains public characteristics for entities. 
*/

package GUI_attempt.src.entity;

import java.awt.image.BufferedImage; 

public class Entity {
    public int playerX, playerY, worldX, worldY, monsterX, monsterY, wordsX_1, wordsX_2, wordsY;
    public int speed; 

    public BufferedImage forward1, forward2, jump, monster1, monster2, letter_a, 
    letter_b, letter_c, letter_d, letter_e, letter_f, letter_g, letter_h, 
    letter_i, letter_j, letter_k, letter_l, letter_m, letter_n, letter_o, 
    letter_p, letter_q, letter_r, letter_s, letter_t, letter_u, letter_v, 
    letter_w, letter_x, letter_y, letter_z;  
    public String direction; 

    public int spriteCounter = 0; 
    public int spriteNum = 1; 
}
