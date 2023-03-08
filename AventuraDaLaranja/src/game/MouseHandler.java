package game;

import java.awt.event.MouseListener;

/**
 *
 * @author arthur
 */
public class MouseHandler implements MouseListener {

    public boolean pressed, click;
    public int positionX, positionY, positionPressedX, positionPressedY;

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        positionX = e.getX();
        positionY = e.getY();
        click = true;

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        pressed = true;
        positionPressedX = e.getX();
        positionPressedY = e.getY();
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        pressed = false;

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        //
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

}
