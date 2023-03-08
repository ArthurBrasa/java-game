package buttomsGame;

import game.Buttom;
import game.MouseHandler;
import java.awt.Rectangle;

/**
 *
 * @author arthur
 */
public class CloseButtom extends Buttom {

    MouseHandler mouseH;
    
    public CloseButtom(String text, int x, int y, MouseHandler mouseH) {
        super(text, x, y);
        this.mouseH = mouseH;
        this.area = new Rectangle(x, y, 100, 50);
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
            System.exit(0);
        }

    }

}
