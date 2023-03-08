package buttomsGame;

import game.Buttom;
import game.KeyHandler;
import game.MouseHandler;

/**
 *
 * @author arthur
 */
public class LimparTextArea extends Buttom {

    MouseHandler mouseH;
    KeyHandler keyH;
    
    public LimparTextArea(String text, int x, int y, MouseHandler mouseH, KeyHandler keyH) {
        super(text, x, y);
        this.mouseH = mouseH;
        this.keyH = keyH;
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
            keyH.clearStringBUilder();
        }

    }
}
