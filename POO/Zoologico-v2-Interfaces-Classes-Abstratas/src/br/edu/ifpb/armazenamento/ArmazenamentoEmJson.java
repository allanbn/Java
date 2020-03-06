package br.edu.ifpb.armazenamento;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.JsonBindingException;
import com.owlike.genson.stream.JsonStreamException;

import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.GeradorId;

public class ArmazenamentoEmJson implements Armazenamento {

	private String nomeArquivo;

	public ArmazenamentoEmJson(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	@Override
	public Zoologico recuperar(GeradorId geradorId) throws ZooException {
		Path path = Paths.get(this.nomeArquivo);
		Zoologico zoo = null;
		String json = "";
		
		if (Files.exists(path)) {
			try {
				List<String> linhas = Files.readAllLines(path);
				for (String linha : linhas) {
					json += linha;
					json += " ";
				}
				json = json.trim();
			} catch (IOException e) {
				throw new ZooException("Houve algum erro ao tentar recuperar os dados do zoológico!", e);
			}
			
			Genson genson = obterGenson();
			try {
				zoo = genson.deserialize(json, Zoologico.class);
			} catch (JsonStreamException | JsonBindingException e) {
				throw new ZooException("Houve algum erro ao tentar recuperar os dados do zoológico!", e);
			}
			zoo.setGeradorId(geradorId);
		} else {
			zoo = new Zoologico(geradorId);
		}
		
		return zoo;
	}

	@Override
	public void armazenar(Zoologico zoo) throws ZooException {
		Genson genson = obterGenson();
		String json = null;
		try {
			json = genson.serialize(zoo);
		} catch (JsonStreamException | JsonBindingException e) {
			throw new ZooException("Houve algum erro ao tentar armazenar os dados do zoológico!", e);
		}

		Path path = Paths.get(this.nomeArquivo);
		try {
			Files.write(path,
			        Arrays.asList(json),
			        StandardCharsets.UTF_8,
			        StandardOpenOption.CREATE,
			        StandardOpenOption.TRUNCATE_EXISTING,
			        StandardOpenOption.WRITE );
		} catch (IOException e) {
			throw new ZooException("Houve algum erro ao tentar armazenar os dados do zoológico!", e);
		}
	}

	private Genson obterGenson() {
		Genson genson = new GensonBuilder()
					.useConstructorWithArguments(true)
					.useRuntimeType(true)
					.useClassMetadata(true)
					.useIndentation(true)
					.create();
		return genson;
	}

}
