package buttomsGame;

import game.Buttom;
import game.MouseHandler;
import gameStates.TelasGame;

/**
 *
 * @author arthur
 */
public class MenuButtom extends Buttom {

    MouseHandler mouseH;

    public MenuButtom(String text, int x, int y, MouseHandler mouseH) {
        super(text, x, y);
        this.mouseH = mouseH;
    }

    @Override
    public void update() {
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
            TelasGame.tela = TelasGame.MENU;
        }
    }

}
