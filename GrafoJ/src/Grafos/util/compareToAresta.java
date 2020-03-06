package Grafos.util;

public class compareToAresta {

    public int compareToAresta(objAresta a, objAresta b) {
        Integer p1 = a.getPeso();
        Integer p2 = b.getPeso();

        return p1.compareTo(p2);
    }
}
