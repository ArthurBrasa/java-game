package gameStates;

import fases.Fase_1;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import java.awt.Graphics2D;
import teclado.Teclado;
import tile.TileManager;

/**
 *
 * @author arthur
 */
public class Playing extends Tela {

    TileManager tile;
    Fase_1 fase_1;

    public Playing(GamePanel gp, KeyHandler keyH, Teclado teclado, MouseHandler mouseH, Fase_1 fase_1) {
        super(gp, keyH, teclado, mouseH);
        this.fase_1 = fase_1;
        this.tile = new TileManager(gp);

    }

    @Override
    public void paint(Graphics2D g2) {
        super.paint(g2);
        // TERRENO
        tile.draw(g2);

        // PINTANDO COMPONENTES DA FASE
        fase_1.paint(g2);
        g2.dispose();
    }

    @Override
    public void update() {
        super.update();

        fase_1.update();

    }
}
