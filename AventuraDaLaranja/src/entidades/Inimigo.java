package entidades;

import game.Colisao;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import game.GamePanel;
import java.util.Random;

/**
 *
 * @author arthur
 */
public class Inimigo extends Entity implements Colisao {

    GamePanel gp;
    Inimigos inimigo;
    float velocidade;
    int movimentacao;
    boolean alternancia;
    int distanciaPercorrida;
    Random gerador;
    int defaultX, defaultY;
    boolean visivel;
    Rectangle collisionTiro;

    public Inimigo(int x, int y, Inimigos inimigo, GamePanel gp) {
        super(x, y);
        super.colision = new Rectangle(x + 9, y + 9, 30, 30);
        super.direcao = "down";
        this.visivel = true;
        this.defaultX = x;
        this.defaultY = y;
        this.inimigo = inimigo;
        this.gp = gp;
        this.velocidade = (float) 1.2;
        this.gerador = new Random();
        this.distanciaPercorrida = gerador.nextInt(50);
        this.movimentacao = 0;
        this.alternancia = true;

        getSprite();
    }

    public void resetDefaultValores() {
        super.x = defaultX;
        super.y = defaultY;
        this.visivel = true;
        super.colision.setLocation(defaultX, defaultY);
        this.velocidade = (float) 1.2;
    }
    
    public boolean visible(){
        return visivel;
    }
    
    public void aumentarVelocidade(){
        velocidade += 0.1;
    }
    
    public void paint(Graphics2D g2) {
        if (visivel) {
            BufferedImage image = null;

            switch (direcao) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }

                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }

                    break;
               
            }

            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
            
        }
    }

    public void update(int xPlayer, int yPlayer, Rectangle obj1) {
        if (visivel) {
            // MOVIMENTAÇÃO DO INIMIGO
            if (movimentacao == distanciaPercorrida) {
                movimentacao = 0;
                distanciaPercorrida = gerador.nextInt(100);
                trocarDirecao();
            } else {
                movimentacao += 1;
            }

            if (alternancia) {
                movimentacaoX(xPlayer);
                if (xPlayer == x) {
                    movimentacaoY(yPlayer);

                }

            } else {
                movimentacaoY(yPlayer);
                if (yPlayer == y) {
                    movimentacaoX(xPlayer);
                }
            }

            // FIM DO JOGO
            if (colisaoPlayer(obj1)) {
                gp.gameOver();
            }

            // ATUALIZANDO AS CORDENADAS DO RECTANGLE   
            super.colision.setLocation(x, y);

            // MUDANÇA DE SPRITES
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    private void getSprite() {
        //System.out.println("Fadsf");
        switch (inimigo) {
            case ZOMBI:
                try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/costas-direita.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/costas-esquerda.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/frente-direita.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/frente-esquerdo.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/lateral-direita.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/lateral-esquerda.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/lateral-2-direita.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/zombi/lateral-2-esquerda.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

            break;
            default:
                throw new AssertionError();
        }

    }
    
    private void trocarDirecao() {
        alternancia = !alternancia;
    }

    private void movimentacaoY(int yPlayer) {
        if (yPlayer < y) {
            direcao = "up";
            y = (int) (y - velocidade);
        } else if (yPlayer > y) {
            direcao = "down";
            y = (int) (y + velocidade);
        }
    }

    private void movimentacaoX(int xPlayer) {
        if (xPlayer < x) {
            direcao = "left";
            x = (int) (x - velocidade);
        } else if (xPlayer > x) {
            direcao = "right";
            x = (int) (x + velocidade);
        }
    }

    @Override
    public boolean colisaoPlayer(Rectangle obj1) {
        return obj1.intersects(super.colision);
    }


}
