package entidades;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author arthur
 */
public class Entity {
    int x, y;
    public BufferedImage up1, up2,
                         down1, down2, 
                         left1, left2,
                         right1, right2;
    public String direcao;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    Rectangle colision;
    
    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }
}
