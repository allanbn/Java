package br.edu.ifpb.armazenamento;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import com.thoughtworks.xstream.XStream;

import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.GeradorId;

public class ArmazenamentoEmXml extends ArmazenamentoEmTexto {

	public ArmazenamentoEmXml(String nomeArquivo) {
		super(nomeArquivo);
	}

	@Override
	public Zoologico recuperar(GeradorId geradorId) throws ZooException {
		Path path = Paths.get(this.nomeArquivo);
		Zoologico zoo = null;

		if (Files.exists(path)) {
			String texto = lerTexto(path);

			XStream xstream = obterXstream();
			zoo = (Zoologico) xstream.fromXML(texto);
			zoo.setGeradorId(geradorId);
		} else {
			zoo = new Zoologico(geradorId);
		}

		return zoo;
	}

	@Override
	public void armazenar(Zoologico zoo) throws ZooException {
		XStream xstream = obterXstream();
		String texto = xstream.toXML(zoo);

		escreverTexto(texto);
	}

	private XStream obterXstream() {
		XStream xStream = new XStream();

		// Inicializar parte de segurança para evitar o WARNING:
		// Security framework of XStream not initialized, XStream is probably
		// vulnerable.
		// Não fazer esta configuração abaixo deixa seu código vulnerável.
		// Mais informações:
		// https://stackoverflow.com/questions/44698296/security-framework-of-xstream-not-initialized-xstream-is-probably-vulnerable
		String[] tiposPermitidos = new String[] { "br.edu.ifpb.**" };
		xStream.allowTypesByWildcard(tiposPermitidos);
		xStream.allowTypeHierarchy(Collection.class);

		return xStream;
	}

}
