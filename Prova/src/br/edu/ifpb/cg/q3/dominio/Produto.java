package br.edu.ifpb.cg.q3.dominio;


import java.io.Serializable;

public abstract class Produto implements Serializable, temRepresentacaoTextual, Comparable<Produto> {

    private static final long serialVersionUID = 1L;

    private String marca;
    private Integer quantidade;
    private minhaData data;
    private Long id;

    Produto(String s, Integer q, String data) {
        this.marca = s;
        if (this.validarQntd(q)) {
            this.quantidade = q;
        }
        this.data = new minhaData(data);
    }

    private boolean validarQntd(Integer q) {
        return q != null && (q < 6 && q > 0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public minhaData getData() {
        return data;
    }

    public void setData(minhaData data) {
        this.data = data;
    }

    @Override
    public String produtoTexto() {
        String s = "";
        s += "Marca: " + this.getMarca() + System.lineSeparator();
        s += "ID: " + this.getId() + System.lineSeparator();
        s += "Quantidade: " + this.getQuantidade() + System.lineSeparator();
        s += "Validade: " + this.getData() + System.lineSeparator();
        return s;
    }

    @Override
    public int compareTo(Produto produto) {

        String p1 = this.getMarca();
        String p2 = produto.getMarca();

        return p1.compareTo(p2);
    }
}
