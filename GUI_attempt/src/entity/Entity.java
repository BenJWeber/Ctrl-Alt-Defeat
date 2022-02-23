/*
* Entity.java
* Contains public characteristics for entities. 
*/

package GUI_attempt.src.entity;

import java.awt.image.BufferedImage; 

public class Entity {
    public int x, y; 
    public int speed; 

    public BufferedImage forward1, forward2, jump; 
    public String direction; 

    public int spriteCounter = 0; 
    public int spriteNum = 1; 
}
