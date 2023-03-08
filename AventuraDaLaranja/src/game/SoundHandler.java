package game;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author arthur
 */
public class SoundHandler {

    AudioInputStream[] inputStream;
    Clip clip;

    public SoundHandler() {
        getMusic();
        try {
            this.clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getMusic() {
        // CARREGANDO MUSICAS
        inputStream = new AudioInputStream[1];

        try {

            inputStream[0] = AudioSystem.getAudioInputStream(new File("music/MusicGame-Song.wav"));

        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setMusic(int index) {
        // TROCAR MUSICA
        try {
            clip.open(inputStream[index]);
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playMusic(int index) {
        // INICIAR MUSICA
        try {
            clip.open(inputStream[index]);
        } catch (LineUnavailableException | IOException ex) {
            Logger.getLogger(SoundHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stopMusic() {
        // PARAR MUSICA
        clip.stop();
        
    }

}
