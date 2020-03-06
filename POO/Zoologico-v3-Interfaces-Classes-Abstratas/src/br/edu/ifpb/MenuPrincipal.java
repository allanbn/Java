package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpb.dominio.Animal;
import br.edu.ifpb.dominio.Cobra;
import br.edu.ifpb.dominio.Leao;
import br.edu.ifpb.dominio.TemRepresentacaoTextual;
import br.edu.ifpb.dominio.Zebra;
import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.util.ComparatorAnimalNome;
import br.edu.ifpb.util.ComparatorAnimaldDecrescente;

public class MenuPrincipal {

	private static final String LS = System.lineSeparator();
	
	private Zoologico zoo;
	
	private Scanner sc;

	public MenuPrincipal(Zoologico zoo, Scanner sc) {
		this.zoo = zoo;
		this.sc = sc;
	}

	public Zoologico getZoo() {
		return zoo;
	}

	public void setZoo(Zoologico zoo) {
		this.zoo = zoo;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public boolean exibirMenu() throws ZooException {
		
		int opcao = 0;
		String menu = "";
		menu += "====================================" + LS;
		menu += "Menu Principal - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		menu += ++opcao + ". Listar Animais" + LS;
		menu += ++opcao + ". Adicionar Leão" + LS;
		menu += ++opcao + ". Adicionar Cobra" + LS;
		menu += ++opcao + ". Adicionar Zebra" + LS;
		menu += ++opcao + ". Remover Animal" + LS;
		menu += ++opcao + ". Sobre a aplicação" + LS;
		menu += ++opcao + ". Sair" + LS;
		menu += ++opcao + ". Listar Animais Ordenados Pelo Nome" + LS;
		menu += ++opcao + ". Listar Animais Ordenados Pelo Id Decrescente" + LS;
		menu += ++opcao + ". Listar Animais Ordenados Pelo Nome Decrescente" + LS;
		
		while (true) {
			System.out.println(menu);
			int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
			switch (opcaoEscolhida) {
				case 1:
					listarAnimais();
					break;
				case 2:
					adicionarLeao();
					break;
				case 3:
					adicionarCobra();
					break;
				case 4:
					adicionarZebra();
					break;
				case 5:
					removerAnimal();
					break;
				case 6:
					sobre();
					break;
				case 7:
					// Sair do programa
					return false;
				case 8:
					listarAnimaisOrdenadosPeloNome();
					break;
				case 9:
					listarAnimaisOrdenadosPeloIdDecrescente();
					break;
				case 10:
					listarAnimaisOrdenadosPeloNomeDecrescente();
					break;
				default:
					System.out.println();
					System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
					System.out.println();
					break;
			}
		}
	}

	private void imprimir(TemRepresentacaoTextual objeto) {
		System.out.println(objeto.obterRepresentacaoTextual());
	}

	private void removerAnimal() throws ZooException {
		String menu = "";
		menu += "====================================" + LS;
		menu += "Remover Animal - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		System.out.println(menu);
		
		Collection<Animal> animais = this.zoo.getAnimais();
		if (animais.isEmpty()) {
			System.out.println("Não há animais para remover!");
			return;
		}
		
		for (Animal animal : animais) {
			System.out.println(animal);
		}
		Long id = obterValorLong("Escolha o id do Animal a ser removido: ");
		this.zoo.removerAnimal(id);
		
		System.out.println();
		System.out.println("Animal removido com sucesso!");
		System.out.println();
	}

	private void adicionarZebra() throws ZooException {
		String menu = "";
		menu += "====================================" + LS;
		menu += "Adicionar Zebra - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		System.out.println(menu);
		
		String nome = obterValorString("Informe o nome: ");
		Integer quantidadeListras = obterValorInteger("Informe a quantidade de listras: ");
		Zebra animal = new Zebra(nome, quantidadeListras);
		this.zoo.adicionarAnimal(animal);
		
		System.out.println();
		System.out.println("Zebra adicionada com sucesso!");
		System.out.println();
	}

	private void adicionarCobra() throws ZooException {
		String menu = "";
		menu += "====================================" + LS;
		menu += "Adicionar Cobra - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		System.out.println(menu);
		
		String nome = obterValorString("Informe o nome: ");
		Boolean ehVenenosa = obterValorBoolean("Informe se a cobra é venenosa (Sim ou Não): ");
		Cobra animal = new Cobra(nome, ehVenenosa);
		this.zoo.adicionarAnimal(animal);
		
		System.out.println();
		System.out.println("Cobra adicionada com sucesso!");
		System.out.println();
	}

	private void adicionarLeao() throws ZooException {
		String menu = "";
		menu += "====================================" + LS;
		menu += "Adicionar Leão - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		System.out.println(menu);
		
		String nome = obterValorString("Informe o nome: ");
		Integer tamanhoDaJuba = obterValorInteger("Informe o tamanho da juba (em cm): ");
		Leao animal = new Leao(nome, tamanhoDaJuba);
		this.zoo.adicionarAnimal(animal);
		
		System.out.println();
		System.out.println("Leão adicionado com sucesso!");
		System.out.println();
	}

	private void listarAnimaisOrdenadosPeloNome() {
		String menu = "";
		menu += "========================================================" + LS;
		menu += "Listar Animais Ordenados Pelo Nome - Aplicação Zoológico" + LS;
		menu += "========================================================" + LS;
		System.out.println(menu);

		Collection<Animal> animais = this.zoo.getAnimais();
		if (animais.isEmpty()) {
			System.out.println("Nenhum animal encontrado!");
		} else {
			List<Animal> animaisOrdenados = new ArrayList<>(animais);
			animaisOrdenados.sort(new ComparatorAnimalNome());
//			Collections.sort(animaisOrdenados, new ComparatorAnimalNome());
			for (Animal animal : animaisOrdenados) {
				imprimir(animal);
			}
		}
		
		System.out.println();

	}

	private void listarAnimaisOrdenadosPeloNomeDecrescente() {
		String menu = "";
		menu += "====================================================================" + LS;
		menu += "Listar Animais Ordenados Pelo Nome Decrescente - Aplicação Zoológico" + LS;
		menu += "====================================================================" + LS;
		System.out.println(menu);

		Collection<Animal> animais = this.zoo.getAnimais();
		if (animais.isEmpty()) {
			System.out.println("Nenhum animal encontrado!");
		} else {
			List<Animal> animaisOrdenados = new ArrayList<>(animais);
			Collections.sort(animaisOrdenados);
//			Collections.sort(animaisOrdenados, new ComparatorAnimalNome());
			for (Animal animal : animaisOrdenados) {
				imprimir(animal);
			}
		}
		
		System.out.println();

	}

	private void listarAnimaisOrdenadosPeloIdDecrescente() {
		String menu = "";
		menu += "==================================================================" + LS;
		menu += "Listar Animais Ordenados Pelo Id Decrescente - Aplicação Zoológico" + LS;
		menu += "==================================================================" + LS;
		System.out.println(menu);

		Collection<Animal> animais = this.zoo.getAnimais();
		if (animais.isEmpty()) {
			System.out.println("Nenhum animal encontrado!");
		} else {
			List<Animal> animaisOrdenados = new ArrayList<>(animais);
			animaisOrdenados.sort(new ComparatorAnimaldDecrescente());
//			Collections.sort(animaisOrdenados, new ComparatorAnimalNome());
			for (Animal animal : animaisOrdenados) {
				imprimir(animal);
			}
		}
		
		System.out.println();

	}
	
	private void listarAnimais() throws ZooException {
		String menu = "";
		menu += "====================================" + LS;
		menu += "Listar Animais - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		System.out.println(menu);

		Collection<Animal> animais = this.zoo.getAnimais();
		if (animais.isEmpty()) {
			System.out.println("Nenhum animal encontrado!");
		} else {
			for (Animal animal : animais) {
				imprimir(animal);
			}
		}
		System.out.println();
		
	}

	private void sobre() {
		String menu = "";
		menu += "====================================" + LS;
		menu += "Sobre - Aplicação Zoológico" + LS;
		menu += "====================================" + LS;
		System.out.println(menu);
		
		imprimir(this.zoo);
		System.out.println();
	}

	private Integer obterValorInteger(String mensagemProUsuario) {
		Integer valor = null;
		while(valor == null) {
			System.out.print(mensagemProUsuario);
			try {
				String line = this.sc.nextLine();
				valor = Integer.parseInt(line);
			} catch(NumberFormatException e) {
				System.out.println("Erro! Valor inválido. Tente novamente!");
			}
		}
		return valor;
	}
	
	private Long obterValorLong(String mensagemProUsuario) {
		Long valor = null;
		while(valor == null) {
			System.out.print(mensagemProUsuario);
			try {
				String line = this.sc.nextLine();
				valor = Long.parseLong(line);
			} catch(NumberFormatException e) {
				System.out.println("Erro! Valor inválido. Tente novamente!");
			}
		}
		return valor;
	}

	private Boolean obterValorBoolean(String mensagemProUsuario) {
		Boolean valor = null;
		while(valor == null) {
			System.out.print(mensagemProUsuario);
			String line = this.sc.nextLine();
			if ("Sim".equalsIgnoreCase(line)) {
				line = "True";
			}
			valor = Boolean.parseBoolean(line);
		}
		return valor;
	}
	
	private String obterValorString(String mensagemProUsuario) {
		String valor = null;
		while (valor == null) {
			System.out.print(mensagemProUsuario);
			String line = this.sc.nextLine();
			valor = line;
		}
		return valor;
	}
	
	private int obterOpcaoEscolhida(String mensagemProUsuario) {
		Integer valor = null;
		while(valor == null) {
			System.out.print(mensagemProUsuario);
			try {
				String line = this.sc.nextLine();
				valor = Integer.parseInt(line);
			} catch(NumberFormatException e) {
				System.out.println("Erro! Opção inválida. Tente novamente!");
			}
		}
		return valor;
	}

}
