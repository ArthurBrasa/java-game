package game;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author arthur
 */
public class Buttom {

    public Rectangle buttomArea;
    public boolean enabled;
    public boolean pressed = false;
    

    public String text;
    public final Font font = new Font("Arial", Font.BOLD, 18); 
    public Rectangle area;

    public Buttom(String text, int x, int y) {
        this.enabled = true;
        this.text = text;
        this.buttomArea = new Rectangle(x, y, 120, 50);
    }

    public void paint(Graphics2D g2) {
        if (pressed) {
            g2.setColor(new Color(255,127,80));
        } else {
            g2.setColor(new Color(255,215,0));
        }

        if (enabled) {
            g2.fillRect((int) buttomArea.getX(), (int) buttomArea.getY(), (int) buttomArea.getWidth(), (int) buttomArea.getHeight());
            g2.setFont(font);
            g2.setColor(new Color(255,69,0));
            int Stringwidth = g2.getFontMetrics().stringWidth(text);
            g2.drawString(text, (int) buttomArea.getX() + (int) buttomArea.getWidth() / 2 - Stringwidth / 2, (int) buttomArea.getY() + (int) buttomArea.getHeight() / 2);

        }
    }

    public void update() {
    }

    public boolean getPressed() {
        return this.pressed;
    }

}
