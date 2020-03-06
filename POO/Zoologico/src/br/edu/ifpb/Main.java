package br.edu.ifpb;

import java.util.Scanner;

import br.edu.ifpb.dominio.Zoologico;

public class Main {

	public static void main(String[] args) throws Exception {
		ArmazenamentoEmArquivoBinario armazenamento = new ArmazenamentoEmArquivoBinario("zoo.ser");
		Zoologico zoo = armazenamento.recuperar(new GeradorIdNanotime());
		Scanner sc = new Scanner(System.in);
		MenuPrincipal menu = new MenuPrincipal(zoo, sc);
		
		boolean continuarExecucao = true;
		while (continuarExecucao) {
			try {
				continuarExecucao = menu.exibirMenu();
			} catch(ZooException e) {
				System.out.println();
				System.out.println(e.getMessage());
				System.out.println();
			} finally {
				armazenamento.armazenar(zoo);
			}
		}
	}
	
}
