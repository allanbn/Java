package br.edu.ifpb.cg.q3.dominio;


import br.edu.ifpb.cg.q3.Geradores.GeradorID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;

    private GeradorID geradorId;
    private List<Produto> produtos;


    public Estoque(GeradorID geradorId) {
        this.produtos = new ArrayList<>();
        this.geradorId = geradorId;
    }

    public void adicionarProduto(Produto p) {
        Long id = this.geradorId.obterProximoId(this);
        p.setId(id);
        this.produtos.add(p);
    }

    public void removerProduto(Long id){
        Produto produtoRemover = null;
        for (Produto ps : this.produtos) {
            if (ps.getId().equals(id)) {
                produtoRemover = ps;
                break;
            }
        }
        if (produtoRemover == null) {
            System.out.println("Produto inexistente");
        }
        else {
            this.produtos.remove(produtoRemover);
        }
    }

    public void incrementar(Long id) {
        Produto produtoIncrementar = null;
        for (Produto ps : this.produtos) {
            if (ps.getId().equals(id)) {
                produtoIncrementar = ps;
                break;
            }
        }
        if (produtoIncrementar == null) {
            System.out.println("Produto inexistente.");
        }
        else {
            if (produtoIncrementar.getQuantidade() < 5) {
                produtoIncrementar.setQuantidade(produtoIncrementar.getQuantidade() + 1);
            }
            else {
                System.out.println("Produto com quantidade máxima.");
            }
        }
    }

    public void decrementar(Long id) {
        Produto produtoDecrementar = null;
        for (Produto ps : this.produtos) {
            if (ps.getId().equals(id)) {
                produtoDecrementar = ps;
                break;
            }
        }
        if (produtoDecrementar == null) {
            System.out.println("Produto inexistente.");
        }
        else {
            if (produtoDecrementar.getQuantidade() > 0) {
                produtoDecrementar.setQuantidade(produtoDecrementar.getQuantidade() - 1);
            }
            else {
                System.out.println("Não há produto no estoque.");
            }
        }
    }

    public GeradorID getGeradorId() {
        return geradorId;
    }

    public void setGeradorId(GeradorID geradorId) {
        this.geradorId = geradorId;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }


}
