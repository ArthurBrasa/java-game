package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean escrever = false;
    public boolean atirar = false;

    StringBuilder sb = new StringBuilder();

    public String getStringBuilder() {
        return sb.toString();
    }

    public void clearStringBUilder() {
        sb.delete(0, sb.length());
    }
    
    public void resetTextArea() {
        escrever = false;
        clearStringBUilder();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int size = sb.length();
        if (escrever) {
            if (size < 9) {
                sb.append(e.getKeyChar());
            }
        }
        int code = e.getKeyCode();
        
        

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        
        if(code == KeyEvent.VK_SPACE){
            atirar = true;           
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

    }
}
