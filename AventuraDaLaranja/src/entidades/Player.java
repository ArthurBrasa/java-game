package entidades;

import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import game.Tiro;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


/**
 *
 * @author arthur
 */
public class Player extends Entity {

    public int score;
    GamePanel gp;
    KeyHandler keyH;
    MouseHandler mouseH;
   // SoundHandler soundH;
    float playerSpeed;
    ArrayList<Tiro> tiros;
    ArrayList<Inimigo> inimigos;

    public Player(int x, int y, GamePanel gp, KeyHandler keyH, MouseHandler mouseH, ArrayList<Inimigo> inimigos)    {
        super(x, y);
        this.score = 0;
        super.colision = new Rectangle(x, y, 30, 30);
        super.direcao = "down";
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        this.tiros = new ArrayList<>();
        this.inimigos = inimigos;
        //this.soundH = soundH;
        playerSpeed = (float) 3.4;

        getSprite();
    }

    public void resetDefaultValoresJogador() {
        super.x = 384;
        super.y = 336;
        super.colision.setLocation(x, y);
        tiros.removeAll(tiros);
        score = 0;
    }

    public void paint(Graphics2D g2) {
        BufferedImage image = null;

        for (int i = 0; i < tiros.size(); i++) {
            Tiro atacar = tiros.get(i);
            atacar.paint(g2);
        }

        // MOVIMENTAÇÃO
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

    public void update() {

        if (mouseH.click) {
            Tiro tiro = new Tiro(this, getDirecao());
            tiros.add(tiro);
            mouseH.click = false;
        }
        if (keyH.atirar) {
            Tiro tiro = new Tiro(this, getDirecao());
            tiros.add(tiro);
            keyH.atirar = false;
        }

        for (int i = 0; i < tiros.size(); i++) {
            Tiro atacar = tiros.get(i);
            if (atacar.visible == false) {
                tiros.remove(i);
            } else {
                atacar.update();

            }
        }

        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
            for (Inimigo inimigo : inimigos) {
                if (inimigo.colisaoPlayer(tiro.getColisao())) {
                    score += 10;
                    inimigo.visivel = false;
                    tiro.visible = false;
                    tiro.colision.setLocation(0, 0);
                    break;
                }
            }
        }

        if (keyH.upPressed == true && keyH.leftPressed == true) {
            super.direcao = "up";
            if(y-playerSpeed*0.70710678118 < 48){
                y = 48;
            }else{
                y -= playerSpeed*0.70710678118;
            }
            if(x-playerSpeed*0.70710678118 < 48){
                x = 48;
            }else{
                x -= playerSpeed*0.70710678118;
            }
        } else if (keyH.upPressed == true && keyH.rightPressed == true) {
            super.direcao = "up";
            if(y-playerSpeed*0.70710678118 < 48){
                y = 48;
            }else{
                y -= playerSpeed*0.70710678118;
            }
            if( playerSpeed*0.70710678118+x > 672){
                x = 672;
            }else{
                x += playerSpeed*0.70710678118;
            }
        } else if (keyH.downPressed == true && keyH.leftPressed == true) {
            super.direcao = "down";
            if(y+playerSpeed*0.70710678118 > 576){
                y = 576;
            }else{
                y += playerSpeed*0.70710678118;
            }
            
            if(x-playerSpeed*0.70710678118 < 48){
                x = 48;
            }else{
                x -= playerSpeed*0.70710678118;
            }
        } else if (keyH.downPressed == true && keyH.rightPressed == true) {
            super.direcao = "down";
            
            if(y+playerSpeed > 576){
                y = 576;
            }else{
                y += playerSpeed;
            }
            
            if( playerSpeed*0.70710678118+x > 672){
                x = 672;
            }else{
                x += playerSpeed*0.70710678118;
            }
        } // MOVIMENTAÇÃO
        else if (keyH.upPressed == true) {
            super.direcao = "up";
            
            if(y-playerSpeed < 48){
                y = 48;
            }else{
                y -= playerSpeed;
            }
        } else if (keyH.downPressed == true) {
            super.direcao = "down";
            
            if(y+playerSpeed > 576){
                y = 576;
            }else{
                y += playerSpeed;
            }
            

        } else if (keyH.leftPressed == true) {
            super.direcao = "right";
            
            if(x-playerSpeed < 48){
                x = 48;
            }else{
                x -= playerSpeed;
            }
            
        } else if (keyH.rightPressed == true) {
            super.direcao = "left";
            if( playerSpeed+x > 672){
                x = 672;
            }else{
                x += playerSpeed;
            }
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

    public int getX() {
        return super.x;
    }

    public int getY() {
        return super.y;
    }

    private String getDirecao() {
        return this.direcao;
    }

    public Rectangle getColisao() {
        return super.colision;
    }

    private void getSprite() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/right1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/right2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/left1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player1/left2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void resetDefaultLocation() {
        super.x = 384;
        super.y = 336;
        super.colision.setLocation(x, y);
        tiros.removeAll(tiros);
    }

    public int getScore() {
       return score;
    }

}
