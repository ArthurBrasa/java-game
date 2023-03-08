package gameStates;

import buttomsGame.CloseButtom;
import buttomsGame.StartButtom;
import cadastro.ListaRecords;
import fases.Fase_1;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import teclado.Teclado;
import buttomsGame.RecordsButtom;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author arthur
 */
public class Menu extends Tela {

    StartButtom start;
    RecordsButtom records;
    CloseButtom close;

    public Menu(GamePanel gp, KeyHandler keyH, Teclado teclado, MouseHandler mouseH, Fase_1 fase_1, ListaRecords listaUsuario) {
        super(gp, keyH, teclado, mouseH);
        this.start = new StartButtom("Start", 310, 260, mouseH, fase_1.player, keyH, fase_1);
        this.records = new RecordsButtom("Records", 310, 315, mouseH, listaUsuario);
        this.close = new CloseButtom("Exit", 310, 370, mouseH);
    }

    @Override
    public void paint(Graphics2D g2) {
        super.paint(g2);
        
        // TITULO
        g2.setFont(new Font("Arial", Font.HANGING_BASELINE, 40));
        g2.setColor(new Color(255, 69, 0));
        g2.drawString("Aventura da Laranja", 190, 200);
        
        // BUTTOMS
        start.paint(g2);
        records.paint(g2);
        close.paint(g2);
        
        g2.dispose();
    }

    @Override
    public void update() {
        super.update();
        start.update();
        records.update();
        close.update();
    }

}
