package buttomsGame;

import entidades.Player;
import fases.Fase_1;
import game.Buttom;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import gameStates.TelasGame;

/**
 *
 * @author arthur
 */
public class StartButtom extends Buttom {

    MouseHandler mouseH;
    Player player;
    KeyHandler keyH;
    Fase_1 fase;
    
    public StartButtom(String text, int x, int y, MouseHandler mouseH, Player player, KeyHandler keyH, Fase_1 fase) {
        super(text, x, y);
        this.mouseH = mouseH;
        this.player = player;
        this.keyH = keyH;
        this.fase = fase;
    }

    @Override
    public void update() {
        super.update();
        if(mouseH.pressed){
            if (super.buttomArea.contains(mouseH.positionPressedX, mouseH.positionPressedY))
                pressed = true;
        }else {
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
