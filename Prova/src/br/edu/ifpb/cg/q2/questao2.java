package br.edu.ifpb.cg.q2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class questao2 {

    public static void main(String[] args) {

        Path path = Paths.get("texto.txt");
        try {
            List<String> texto = Files.readAllLines(path);
            for (String i : texto) {
                for (String j: i.split(" ")) {
                    System.out.println(j.trim());
                }
            }
        }
        catch (IOException e) {
            System.out.println("Arquivo inexistente.");
        }
    }
}
