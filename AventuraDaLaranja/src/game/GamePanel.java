package game;

import cadastro.ListaRecords;
import fases.Fase_1;
import gameStates.GameOver;
import gameStates.Playing;
import gameStates.TelasGame;
//import static gameStates.TelasGame.GAMEOVER;
//import static gameStates.TelasGame.PLAYING;
//import static gameStates.TelasGame.RECORDS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import teclado.Teclado;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    //TAMANHO DO TILE E SCALING DELE
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    //QNTD DE COLUMNS E ROWS DA TELA
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 14;

    //TAMANHO FINAL DA TELA
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    // SYSTEM
    KeyHandler keyH = new KeyHandler();
    MouseHandler mouseH = new MouseHandler();
    Teclado teclado = new Teclado(150, 460, keyH);
    SoundHandler playMusic = new SoundHandler();
    ListaRecords listaUsuario = new ListaRecords();
    Thread gameThread;

    // FASES
    Fase_1 fase_1 = new Fase_1(this, keyH, mouseH);

    //TELAS GAME
    gameStates.Menu menu = new gameStates.Menu(this, keyH, teclado, mouseH, fase_1, listaUsuario);
    gameStates.Playing playing = new Playing(this, keyH, teclado, mouseH, fase_1);
    gameStates.GameOver gameOver = new GameOver(this, keyH, teclado, mouseH, fase_1, listaUsuario, fase_1.player);
    gameStates.Records records = new gameStates.Records(this, keyH, teclado, mouseH, fase_1, listaUsuario);

    public void gameOver() {
        TelasGame.tela = TelasGame.GAMEOVER;
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(255, 165, 0));
        
        //MELHORA PERFORMANCE
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);
        playMusic.playMusic(0);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        // LOOP PRINCIPAL
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }

    }

    public void update() {

        switch (TelasGame.tela) {
            case MENU:

                menu.update();

                break;
            case PLAYING:

                playing.update();

                break;
            case GAMEOVER:

                gameOver.update();

                break;
            case RECORDS:

                records.update();

                break;

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // casting

        switch (TelasGame.tela) {
            case MENU:
                // MENU JOGO TELA
                menu.paint(g2);
                break;
            case PLAYING:
                // PLAYING TELA
                playing.paint(g2);

                break;
            case GAMEOVER:
                // GAME OVER TELA
                gameOver.paint(g2);

                break;
            case RECORDS:
                // RECORDS TELA
                records.paint(g2);

                break;
        }
    }

}
