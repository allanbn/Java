package br.edu.ifpb.cg.GeradorID;

public class GeradorIDNano implements interGeradorID{

    @Override
    public Long obterProximoID() {
        Long ID = System.nanoTime();
        return ID;
    }
}
