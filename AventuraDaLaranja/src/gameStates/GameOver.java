package gameStates;

import buttomsGame.LimparTextArea;
import buttomsGame.NewGameButtom;
import buttomsGame.SalvarButtom;
import cadastro.ListaRecords;
import entidades.Player;
import fases.Fase_1;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import teclado.Teclado;

/**
 *
 * @author arthur
 */
public class GameOver extends Tela {

    NewGameButtom newGame;
    LimparTextArea clear;
    SalvarButtom salvar;
    Player player;

    public GameOver(GamePanel gp, KeyHandler keyH, Teclado teclado, MouseHandler mouseH, Fase_1 fase_1, ListaRecords listaUsuario, Player player) {
        super(gp, keyH, teclado, mouseH);
        this.player = player;
        this.newGame = new NewGameButtom("New Game", 170, 500, mouseH, keyH, fase_1.player, fase_1);
        this.clear = new LimparTextArea("Clear", 330, 500, mouseH, keyH);
        this.salvar = new SalvarButtom("Save", 490, 500, mouseH, keyH, listaUsuario, fase_1.player);

    }

    @Override
    public void paint(Graphics2D g2) {
        super.paint(g2);

        // TITULO
        g2.setColor(Color.red);
        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.drawString("GAME OVER", 200, 150);

        // NICKNAME
        g2.setColor(new Color(255, 69, 0));
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Nickname", 150, 400);

        // TEXTAREA
        g2.setColor(new Color(255, 127, 80));
        g2.fillRect(teclado.getX(), teclado.getY() - 40, 500, 50);
        
        // Placar
        g2.setFont(new Font("Arial", Font.BOLD, 60));
        g2.drawString(String.valueOf(player.getScore()), 300, 300);
        
        
        // IMPUT
        teclado.paint(g2);

        // BOTTOMS
        newGame.paint(g2);
        clear.paint(g2);
        salvar.paint(g2);

        g2.dispose();
    }

    @Override
    public void update() {
        super.update();

        teclado.update();
        newGame.update();
        clear.update();
        salvar.update();
    }

}
