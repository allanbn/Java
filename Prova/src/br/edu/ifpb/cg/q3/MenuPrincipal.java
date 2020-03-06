package br.edu.ifpb.cg.q3;

import br.edu.ifpb.cg.q3.Ordenamento.ComparatorAlfa;
import br.edu.ifpb.cg.q3.Ordenamento.ComparatorDataCrescente;
import br.edu.ifpb.cg.q3.Ordenamento.ComparatorQntdCrescente;
import br.edu.ifpb.cg.q3.dominio.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

	private static final String LS = System.lineSeparator();

	public MenuPrincipal() {
		super();
	}

	public boolean exibirMenu(Estoque p) {

		Scanner in = new Scanner(System.in);
		String menu = "";
		menu += "===========================" + LS;
		menu += "======= Bem - vindo =======" + LS;
		menu += "===========================" + LS;
		System.out.println(menu);
		int op;
		while (true) {
			op = 0;
			menu = "";
			menu += ++op + ". Listar produtos." + LS;
			menu += ++op + ". Listar produtos em ordem alfabética." + LS;
			menu += ++op + ". Listar produtos em ordem crescente de quantidade." + LS;
			menu += ++op + ". Listar produtos em ordem crescente data de validade" + LS;
			menu += ++op + ". Listar produtos vencidos." + LS;
			menu += ++op + ". Adicionar detergente." + LS;
			menu += ++op + ". Adicionar feijão." + LS;
			menu += ++op + ". Remover produto." + LS;
			menu += ++op + ". Incrementar quantidade de produto em 1." + LS;
			menu += ++op + ". Decrementar quantidade de produro em 1." + LS;
			menu += ++op + ". Sair.";
			System.out.println(menu);
			System.out.println("Insira uma opção!");
			String e = in.nextLine();
			int i = Integer.parseInt(e);
			switch (i) {
				case 1:
					listarProdutos(p);
					break;
				case 2:
					listarProdutosAlfa(p);
					break;
				case 3:
					listarProdutosQntd(p);
					break;
				case 4:
					listarProdutosData(p);
					break;
				case 5:
					listarProdutosVencidos(p);
					break;
				case 6:
					addDetergente(p);
					break;
				case 7:
					addFeijao(p);
					break;
				case 8:
					removerProduto(p);
					break;
				case 9:
					incrementarProduto(p);
					break;
				case 10:
					decrementarProduto(p);
					break;
				case 11:
					return false;
				default:
					System.out.println("Opção inválida!");
					System.out.println();
			}
		}

	}

	private boolean listarProdutos(Estoque p) {

		System.out.println();
		List<Produto> produtos = p.getProdutos();

		if (produtos.isEmpty()) {
			System.out.println("Sem produtos.");
		}
		else {
			for (Produto pd : produtos) {
				System.out.println(pd.produtoTexto());
			}
		}
		System.out.println();
		return true;
	}

	private boolean listarProdutosAlfa(Estoque p) {

		System.out.println();
		List<Produto> produtos = p.getProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Sem produtos.");
		}
		else {
			List<Produto> ordenadoAlfa = new ArrayList<>(produtos);
			ordenadoAlfa.sort(new ComparatorAlfa());
			for (Produto pd : ordenadoAlfa) {
				System.out.println(pd.produtoTexto());
			}
		}
		System.out.println();
		return true;
	}

	private boolean listarProdutosQntd(Estoque p) {

		System.out.println();
		List<Produto> produtos = p.getProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Sem produtos.");
		}
		else {
			List<Produto> ordenadoQntd = new ArrayList<>(produtos);
			ordenadoQntd.sort(new ComparatorQntdCrescente());
			for (Produto pd : ordenadoQntd) {
				System.out.println(pd.produtoTexto());
			}
		}
		System.out.println();
		return true;
	}

	private boolean listarProdutosData(Estoque p) {

		System.out.println();
		List<Produto> produtos = p.getProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Sem produtos.");
		}
		else {
			List<Produto> ordenadoData = new ArrayList<>(produtos);
			ordenadoData.sort(new ComparatorDataCrescente());
			for (Produto pd : ordenadoData) {
				System.out.println(pd.produtoTexto());
			}
		}
		System.out.println();
		return true;
	}
	private boolean listarProdutosVencidos(Estoque p) {

		List<Produto> produtos = p.getProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Sem produtos.");
		}
		else {
			System.out.println("Insira uma data (DD/MM/AAAA) para checagem de produtos vencidos: ");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			minhaData d = new minhaData(s);
			for (Produto pd : produtos) {
				if (d.compareTo(pd.getData()) > 0) {
					System.out.println(pd.produtoTexto());
				}
			}
		}
		System.out.println();
		return true;
	}

	private boolean addDetergente(Estoque p) {
		Scanner in = new Scanner(System.in);
		System.out.println("Insira a marca do detergente:");
		String m = in.nextLine();
		System.out.println("Insira a quantidade de detergentes:");
		Integer qntd = Integer.parseInt(in.nextLine());
		System.out.println("Insira a validade do detergente (DD/MM/AAAA):");
		String data = in.nextLine();
		System.out.println("Insira se o detergente é neutro (sim ou não):");
		String n = in.nextLine();
		Produto d = new Detergente(m, qntd, data, n);
		p.adicionarProduto(d);
		return true;
	}

	private boolean addFeijao(Estoque p) {
		Scanner in = new Scanner(System.in);
		System.out.println("Insira a marca do feijão:");
		String m = in.nextLine();
		System.out.println("Insira a quantidade de feijão:");
		Integer qntd = Integer.parseInt(in.nextLine());
		System.out.println("Insira a validade do feijão (DD/MM/AAAA):");
		String data = in.nextLine();
		System.out.println("Insira o peso do feijão (kg):");
		Integer peso = Integer.parseInt(in.nextLine());
		Produto d = new Feijao(m , qntd, data, peso);
		p.adicionarProduto(d);
		return true;
	}

	private boolean removerProduto(Estoque p) {
		System.out.println();
		this.listarProdutos(p);
		System.out.println();
		System.out.println("Insira o id do produto a ser removido: ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Long l = Long.parseLong(s);
		p.removerProduto(l);
		return true;
	}

	private boolean incrementarProduto(Estoque p) {
		System.out.println();
		this.listarProdutos(p);
		System.out.println();
		System.out.println("Insira o id do produto a ser incrementador: ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Long l = Long.parseLong(s);
		p.incrementar(l);
		return true;
	}

	private boolean decrementarProduto(Estoque p) {
		System.out.println();
		this.listarProdutos(p);
		System.out.println();
		System.out.println("Insira o id do produto a ser decrementado: ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Long l = Long.parseLong(s);
		p.decrementar(l);
		return true;
	}


}
