package gameStates;

import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import java.awt.Graphics2D;
import teclado.Teclado;

/**
 *
 * @author arthur
 */
public class Tela {
    GamePanel gp;
    KeyHandler keyH;
    Teclado teclado;
    MouseHandler mouseH;

    public Tela(GamePanel gp, KeyHandler keyH, Teclado teclado, MouseHandler mouseH) {
        this.gp = gp;
        this.keyH = keyH;
        this.teclado = teclado;
        this.mouseH = mouseH;
    }
    
    public void paint(Graphics2D g2){
    }
    
    public void update(){
    }
}
