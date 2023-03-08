package teclado;

import game.KeyHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
/**
 *
 * @author arthur
 */
public class Teclado {

    KeyHandler keyH;
    int x, y;

    public Teclado(int x, int y, KeyHandler keyH) {
        this.keyH = keyH;
        this.x = x;
        this.y = y;

    }

    public void paint(Graphics2D g2) {

        g2.setColor(new Color(255,69,0));
        g2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 35));
        g2.drawString(keyH.getStringBuilder(), x, y);

    }
    
    public void update(){
        keyH.escrever = true;            
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
}
