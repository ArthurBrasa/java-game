package fases;

import entidades.Inimigo;
import entidades.Inimigos;
import entidades.Player;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public class Fase_1 {

    ArrayList<Inimigo> inimigos;
    public Player player;
    GamePanel gp;
    MouseHandler mouseH;
    int TOTAL_INIMIGOS = 1;
    boolean startFase;

    public Fase_1(GamePanel gp, KeyHandler keyH, MouseHandler mouseH) {
        this.inimigos = new ArrayList<>();
        this.player = new Player(384, 336, gp, keyH, mouseH,inimigos);
        this.gp = gp;
        this.mouseH = mouseH;
        this.startFase = true;
    }

    private void gerarInimigos() {
        for (int i = 0; i <= TOTAL_INIMIGOS; i++) {
            Inimigo inimigo_1 = new Inimigo(12, 368, Inimigos.ZOMBI, gp);
            inimigo_1.aumentarVelocidade();
            inimigos.add(inimigo_1);
        }
        for (int i = 0; i <= TOTAL_INIMIGOS; i++) {
            Inimigo inimigo_2 = new Inimigo(364, 8, Inimigos.ZOMBI, gp);
            inimigo_2.aumentarVelocidade();
            inimigos.add(inimigo_2);
        }
        for (int i = 0; i <= TOTAL_INIMIGOS; i++) {
            Inimigo inimigo_3 = new Inimigo(712, 356, Inimigos.ZOMBI, gp);
            inimigo_3.aumentarVelocidade();
            inimigos.add(inimigo_3);
        }
        for (int i = 0; i <= TOTAL_INIMIGOS; i++) {
            Inimigo inimigo_4 = new Inimigo(368, 668, Inimigos.ZOMBI, gp);
            inimigo_4.aumentarVelocidade();
            inimigos.add(inimigo_4);
        }
    }

    public void upFaseLevel() {
        mouseH.positionX = 0;
        mouseH.positionPressedY = 0;
        TOTAL_INIMIGOS += 1;
        gerarInimigos();
        player.resetDefaultLocation();
    }

    public void resetFase() {

        resetTotalInimigos();

        gerarInimigos();

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo ini = inimigos.get(i);
            ini.resetDefaultValores();
        }

        player.resetDefaultValoresJogador();

    }

    public void carregarFase() {
        upFaseLevel();

        startFase = true;
    }

    public void paint(Graphics2D g2) {
        player.paint(g2);

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo ini = inimigos.get(i);
            ini.paint(g2);
        }
        
        g2.setColor(new Color(255,69,0));
        g2.setFont(new Font("Arial", Font.BOLD, 25) {
        });
        g2.drawString("Score: "+String.valueOf(player.getScore()), 50, 80);
        g2.drawString("Level: " + TOTAL_INIMIGOS, 550, 80);
    }

    public void update() {

        if (startFase) {
            if (inimigos.isEmpty()) {
                startFase = false;
                carregarFase();
            }

            player.update();

            for (int i = 0; i < inimigos.size(); i++) {
                Inimigo ini = inimigos.get(i);
                if (!ini.visible()) {
                    inimigos.remove(i);
                } else {
                    ini.update(player.getX(), player.getY(), player.getColisao());

                }
            }
        }

    }

    public void resetTotalInimigos() {
        TOTAL_INIMIGOS = 1;
        inimigos.removeAll(inimigos);
    }
}
