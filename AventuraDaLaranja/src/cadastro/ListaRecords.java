package cadastro;

import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author arthur
 */
public final class ListaRecords {

    LinkedHashMap<String, Usuario> usuarios;
    BancoDeDados bancoDeDados;

    private File arquivoUsuarios;
    private BufferedReader br;
    
    public ListaRecords() {
        usuarios = new LinkedHashMap<>();
        bancoDeDados = new BancoDeDados("cadastros/usuariosCadastrados.txt");
        loadUsuariosSalvos();
    }

    public void loadUsuariosSalvos() {
        bancoDeDados.carregarBancoDeDados(usuarios);
    }
    
    public void resetBanco(){
        usuarios = new LinkedHashMap<>();
        loadUsuariosSalvos();
    }
    
    public void cadastrarUsuario(String nickName, int score) {

        if (validadarDados(nickName)) {
            if (!nickName(nickName)) {
                Usuario cadastro = new Usuario(nickName,score);
                usuarios.put(nickName, cadastro);
                bancoDeDados.salvar(cadastro);
            } else {
            }

        } else {
        }
    }

    public boolean nickName(String nickName) {
        if (usuarios.containsKey(nickName)) {
            return true;
        } else {
            return false;
        }

    }
    
    public HashMap<String, Usuario> getUsuarios(){
        return usuarios;
    }
    
    private boolean validadarDados(String nickName) {
        return !"".equals(nickName);
    }
}
