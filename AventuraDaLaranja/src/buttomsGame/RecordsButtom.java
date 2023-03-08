package buttomsGame;

import cadastro.ListaRecords;
import game.Buttom;
import game.MouseHandler;
import gameStates.TelasGame;

/**
 *
 * @author arthur
 */
public class RecordsButtom extends Buttom {

    MouseHandler mouseH;
    ListaRecords listaUsuario;

    public RecordsButtom(String text, int x, int y, MouseHandler mouseH, ListaRecords list) {
        super(text, x, y);
        this.mouseH = mouseH;
        this.listaUsuario = list;
    }

    @Override
    public void update() {
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
            
            listaUsuario.loadUsuariosSalvos();
            listaUsuario.resetBanco();
           
            TelasGame.tela = TelasGame.RECORDS;
        }
    }

}
