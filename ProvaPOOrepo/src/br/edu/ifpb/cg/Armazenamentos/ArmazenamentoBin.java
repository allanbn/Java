package br.edu.ifpb.cg.Armazenamentos;

import br.edu.ifpb.cg.domain.Locadora;
import br.edu.ifpb.cg.geradoresID.geradorID;
import java.io.*;

public class ArmazenamentoBin implements Armazenamento {

    private String nomeArquivo;

    public ArmazenamentoBin(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void armazenar(Locadora L) {
        try {
            FileOutputStream fos = new FileOutputStream(this.nomeArquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(L);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Locadora recuperar(geradorID G) {
        Locadora L = null;
        try {
            FileInputStream fis = new FileInputStream(this.nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            L = (Locadora) ois.readObject();
            L.setGerador(G);
        }
        catch (Exception e) {
            L = new Locadora(G);
        }
        return L;
    }
}
