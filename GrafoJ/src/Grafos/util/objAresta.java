package Grafos.util;

public class objAresta {

    private String aresta;
    private Integer peso;
    private String src;
    private String dst;

    public objAresta(String aresta, Integer peso) {
        this.aresta = aresta;
        this.peso = peso;
        String[] a = aresta.split("-");
        this.src = a[0];
        this.dst = a[1];
    }

    public String getAresta() {
        return aresta;
    }

    public void setAresta(String aresta) {
        this.aresta = aresta;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getSrc() {
        return src;
    }

    public String getDst() {
        return dst;
    }

    @Override
    public String toString() {
        return "objAresta{" +
                "aresta='" + aresta + '\'' +
                ", peso=" + peso +
                '}';
    }
}
