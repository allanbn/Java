package br.edu.ifpb.cg.q3.Armazenamentos;

import br.edu.ifpb.cg.q3.Geradores.GeradorID;
import br.edu.ifpb.cg.q3.dominio.Estoque;

import java.io.*;

public class armazenamentoBin implements Armazenamento {

    private String nomeArquivo;

    public armazenamentoBin(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public Estoque recuperar(GeradorID geradorId) {

        Estoque p = null;

        try (FileInputStream fis = new FileInputStream(this.nomeArquivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            p = (Estoque) ois.readObject();
            p.setGeradorId(geradorId);
        } catch (FileNotFoundException e) {
            // primeira vez que o programa está sendo executado armazenando a base de dados
            // neste arquivo?
            p = new Estoque(geradorId);
        } catch (IOException | ClassNotFoundException e) {
//            throw new ZooException("Houve algum erro ao tentar recuperar os dados do plógico!", e);
            System.out.println("Deu erro.");
        }

        return p;
    }

    public void armazenar(Estoque p) {
        try (FileOutputStream fos = new FileOutputStream(this.nomeArquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(p);
        } catch (IOException e) {
//            throw new ZooException("Houve algum erro ao tentar armazenar os dados do Zoológico!", e);
            System.out.println("Deu erro.");
        }
    }
}