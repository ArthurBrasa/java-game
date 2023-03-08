package cadastro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author arthur
 */
public class BancoDeDados {

    String path;
    File arquivo;
    FileReader read;
    BufferedReader readerBuffer;

    public BancoDeDados(String path) {
        this.path = path;
        arquivo = new File(path);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(Usuario usuario) {
        String infoUsuario = usuario.getInfoUsuario();
        try {
            FileWriter fileWriter = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            bw.write(infoUsuario);
            bw.newLine();

            bw.close();
            fileWriter.close();

        } catch (IOException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregarBancoDeDados(HashMap<String, Usuario> map) {
        arquivo = new File(getPath());
        HashMap<String, Integer> mapa = new HashMap<>();
        try {
            read = new FileReader(arquivo);
            readerBuffer = new BufferedReader(read);

            String line = readerBuffer.readLine();

            while (line != null) {
                String infoUsuario = (String) line;

                String[] infoUsuarioArray;
                infoUsuarioArray = infoUsuario.split("\\|");

                if (infoUsuarioArray.length == 1) {
                    break;
                }

                Usuario usuario = new Usuario(infoUsuarioArray[0], Integer.parseInt(infoUsuarioArray[1]));

                mapa.put(infoUsuarioArray[0], Integer.parseInt(infoUsuarioArray[1]));
                line = readerBuffer.readLine();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        Map<String, Integer> result = mapa.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        String[] nomes = new String[result.size()];
        String[] score = new String[result.size()];

        int index = 0;
        for (String nome : result.keySet()) {
            nomes[index] = nome;
            index +=1;
        }
        index = 0;
        for (String nome : result.keySet()) {
            score[index] = String.valueOf(result.get(nome));
            index +=1;
        }
        
        inverter(nomes);
        inverter(score);
        
        for (int i = 0; i<nomes.length; i++){
            map.put(nomes[i], new Usuario(nomes[i], Integer.parseInt(score[i])));
        }
        
    }

    private void inverter(Object[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }    

    public String getPath() {
        return this.path;
    }

}
