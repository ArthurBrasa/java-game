package cadastro;

/**
 *
 * @author arthur
 */
public class Usuario {

    private String nickname;
    private int score;

    public Usuario(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }
    
    public String getInfoUsuario(){
        return getNickname() + "|" +
               getScore();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return this.score;
    }
}
