package game;

import entidades.Player;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author arthur
 */
public class Tiro {

    public int x, y;
    int width, height;
    float velocidade;
    public int maxX, maxY;
    public Rectangle colision;
    public boolean visible;
    public String direcao;
    private int color_1, color_2, color_3;
    Random gerador;

    Player player;

    public Tiro(Player player, String direcao) {
        this.player = player;
        this.x = player.getX() + 20;
        this.y = player.getY() + 15;
        this.width = 25;
        this.height = 10;
        this.direcao = direcao;
        this.velocidade = (float) 8.2;
        this.maxX = 900;
        this.maxY = 900;
        this.visible = true;
        this.colision = new Rectangle(x, y, width, height);
        this.gerador = new Random();
        color_1 = gerador.nextInt(255);
        color_2 = gerador.nextInt(255);
        color_3 = gerador.nextInt(255);
    }

    public Rectangle getColisao() {
        return this.colision;
    }

    public void paint(Graphics2D g2) {
        if (visible) {
            g2.setColor(new Color(color_1, color_2, color_3));
            if ("up".equals(direcao) || "down".equals(direcao)) {

                g2.fillRect(x, y, height, width);
            }
            if ("left".equals(direcao) || "right".equals(direcao)) {

                g2.fillRect(x, y, width, height);
            }

        }
    }

    public void update() {
        if(x>maxX || x < -10){
            visible = false;
        }
        if(y>maxY || y < -10){
            visible = false;
        }
        
        if (visible) {
            if ("up".equals(direcao)) {
                y -= velocidade;

            }
            if ("down".equals(direcao)) {
                y += velocidade;
            }
            if ("right".equals(direcao)) {
                x -= velocidade;
            }
            if ("left".equals(direcao)) {
                x += velocidade;
            }

            colision.setLocation(x, y);
        }
    }

}
