/*
* Entity.java
* Contains public characteristics for entities. 
*/

package GUI_attempt.src.entity;

import java.awt.image.BufferedImage; 

public class Entity {
    public int playerX, playerY, worldX, worldY, monsterX, monsterY; 
    public int speed; 

    public BufferedImage forward1, forward2, jump, monster1, monster2; 
    public String direction; 

    public int spriteCounter = 0; 
    public int spriteNum = 1; 
}
