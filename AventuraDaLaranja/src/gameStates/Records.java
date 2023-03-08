package gameStates;

import buttomsGame.NewGameButtom;
import cadastro.ListaRecords;
import cadastro.Usuario;
import fases.Fase_1;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import teclado.Teclado;

/**
 *
 * @author arthur
 */
public class Records extends Tela {
    
    NewGameButtom newGame;
    buttomsGame.MenuButtom menu;
    ListaRecords listaUsuario;
    
    public Records(GamePanel gp, KeyHandler keyH, Teclado teclado, MouseHandler mouseH, Fase_1 fase_1, ListaRecords listaUsuario) {
        super(gp, keyH, teclado, mouseH);
        this.newGame = new NewGameButtom("New Game", 170, 499, mouseH, keyH, fase_1.player, fase_1);
        this.menu = new buttomsGame.MenuButtom( "Menu", 490, 499, mouseH);
        this.listaUsuario = listaUsuario;
    }

    @Override
    public void paint(Graphics2D g2) {
        super.paint(g2);

        // TITULO
        g2.setColor(Color.red);
        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.drawString("RECORDS", 250, 100);

        g2.setFont(new Font("Arial", Font.BOLD, 25));
        g2.setColor(Color.red);
        g2.drawString("Nickname                                         Score", 100, 170);

        // TABELA RECORDS
        g2.setColor(new Color(255, 69, 0));
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        
        HashMap<String, Usuario> usuarios = listaUsuario.getUsuarios();
        int pularLinha = 200;
        int cont = 0;
        for (String nickname : usuarios.keySet()) {
            if (cont < 10) {
                g2.drawString(nickname, 110, pularLinha);
                pularLinha += 30;
                cont++;
            }
        }
        pularLinha = 200;
        cont = 0;
        for (String nickname : usuarios.keySet()) {
            if (cont < 10) {
                g2.drawString("-------------------------------------------", 250, pularLinha);
                pularLinha += 30;
                cont++;
            }
        }
        pularLinha = 200;
        cont = 0;
        for (String nickname : usuarios.keySet()) {
            if (cont < 10) {
                g2.drawString(String.valueOf(usuarios.get(nickname).getScore()), 620, pularLinha);
                pularLinha += 30;
                cont++;
            }
        }

        // BUTTOMS
        newGame.paint(g2);
        menu.paint(g2);
        
        g2.dispose();
    }

    @Override
    public void update() {
        super.update();
        
        newGame.update();
        menu.update();
        
    }

}
