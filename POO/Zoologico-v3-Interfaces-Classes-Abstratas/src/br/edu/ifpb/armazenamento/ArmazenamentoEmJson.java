package br.edu.ifpb.armazenamento;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.JsonBindingException;
import com.owlike.genson.stream.JsonStreamException;

import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.GeradorId;

public class ArmazenamentoEmJson extends ArmazenamentoEmTexto {

	public ArmazenamentoEmJson(String nomeArquivo) {
		super(nomeArquivo);
	}
	
	@Override
	public Zoologico recuperar(GeradorId geradorId) throws ZooException {
		Path path = Paths.get(this.nomeArquivo);
		Zoologico zoo = null;
		
		if (Files.exists(path)) {
			String texto = lerTexto(path);
			
			Genson genson = obterGenson();
			try {
				zoo = genson.deserialize(texto, Zoologico.class);
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
		String texto = null;
		try {
			texto = genson.serialize(zoo);
		} catch (JsonStreamException | JsonBindingException e) {
			throw new ZooException("Houve algum erro ao tentar armazenar os dados do zoológico!", e);
		}

		escreverTexto(texto);
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
