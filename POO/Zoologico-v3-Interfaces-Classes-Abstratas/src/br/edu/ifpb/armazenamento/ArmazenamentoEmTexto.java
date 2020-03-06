package br.edu.ifpb.armazenamento;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import br.edu.ifpb.exceptions.ZooException;

public abstract class ArmazenamentoEmTexto implements Armazenamento {

	protected String nomeArquivo;
	
	public ArmazenamentoEmTexto(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	protected void escreverTexto(String texto) throws ZooException {
		Path path = Paths.get(this.nomeArquivo);
		try {
			Files.write(path,
			        Arrays.asList(texto),
			        StandardCharsets.UTF_8,
			        StandardOpenOption.CREATE,
			        StandardOpenOption.TRUNCATE_EXISTING,
			        StandardOpenOption.WRITE);
		} catch (IOException e) {
			throw new ZooException("Houve algum erro ao tentar armazenar os dados do zoológico!", e);
		}
	}
	
	protected String lerTexto(Path path) throws ZooException {
		String texto = "";
		try {
			List<String> linhas = Files.readAllLines(path);
			for (String linha : linhas) {
				texto += linha;
				texto += " ";
			}
			texto = texto.trim();
		} catch (IOException e) {
			throw new ZooException("Houve algum erro ao tentar recuperar os dados do zoológico!", e);
		}
		return texto;
	}
	
}
