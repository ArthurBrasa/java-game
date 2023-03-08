/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttomsGame;

import cadastro.ListaRecords;
import entidades.Player;
import game.Buttom;
import game.GamePanel;
import game.KeyHandler;
import game.MouseHandler;
import gameStates.TelasGame;

/**
 *
 * @author arthur
 */
public class SalvarButtom extends Buttom {

    MouseHandler mouseH;
    KeyHandler keyH;
    ListaRecords listaUsuario;
    Player player;

    public SalvarButtom(String text, int x, int y, MouseHandler mouseH, KeyHandler keyH, ListaRecords list, Player player) {
        super(text, x, y);
        this.mouseH = mouseH;
        this.keyH = keyH;
        this.listaUsuario = list;
        this.player = player;
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
            String nickName = keyH.getStringBuilder();

            listaUsuario.cadastrarUsuario(nickName, player.score);
            
            listaUsuario.loadUsuariosSalvos();
            listaUsuario.resetBanco();

            TelasGame.tela = TelasGame.RECORDS;
        }
    }

}
