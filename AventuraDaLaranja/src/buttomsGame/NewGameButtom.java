package buttomsGame;

import entidades.Player;
import fases.Fase_1;
import game.Buttom;
import game.KeyHandler;
import game.MouseHandler;
import gameStates.TelasGame;

/**
 *
 * @author arthur
 */
public class NewGameButtom extends Buttom {

    Player player;
    MouseHandler mouseH;
    KeyHandler keyH;
    Fase_1 fase;

    public NewGameButtom( String text, int x, int y, MouseHandler mouseH, KeyHandler keyH, Player player, Fase_1 fase) {
        super(text, x, y);
        this.mouseH = mouseH;
        this.keyH = keyH;
        this.player = player;
        this.fase = fase;
    }

    @Override
    public void update() {
        super.update();
        if (mouseH.pressed) {
            if (super.buttomArea.contains(mouseH.positionPressedX, mouseH.positionPressedY)) {
                pressed = true;
            }

        } else {
            pressed = false;
        }

        if (super.buttomArea.contains(mouseH.positionX, mouseH.positionY)) {
            // reset position presed
            mouseH.positionX = 0;
            mouseH.positionY = 0;

            keyH.resetTextArea();
            fase.resetTotalInimigos();
            fase.resetFase();

            TelasGame.tela = TelasGame.PLAYING;
        }

    }

}
