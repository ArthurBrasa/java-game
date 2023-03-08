package game;

import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class Main {

    public static void main(String args[]) {
        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel jogo = new GamePanel();
        window.add(jogo);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Iniciar loop do jogo
        jogo.startGameThread();
        
        
    }
}
