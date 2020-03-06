package br.edu.ifpb.cg.armazenamento;

import br.edu.ifpb.cg.GeradorID.interGeradorID;
import br.edu.ifpb.cg.domain.Hotel;

import java.io.*;

public class ArmazenamentoBin implements Armazenamento {

    private String nomeArquivo;

    public ArmazenamentoBin(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public Hotel recuperar(interGeradorID GeradorID) {
        Hotel H = null;
        try {
            FileInputStream fis = new FileInputStream(this.nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            H = (Hotel) ois.readObject();
        }
        catch (FileNotFoundException e) {
            H = new Hotel(GeradorID);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return H;
    }

    @Override
    public void armazenar(Hotel H) {
        try {
           FileOutputStream fos = new FileOutputStream(this.nomeArquivo);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(H);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
