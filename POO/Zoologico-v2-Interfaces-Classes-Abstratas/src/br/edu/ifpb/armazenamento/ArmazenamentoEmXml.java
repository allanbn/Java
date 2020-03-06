package br.edu.ifpb.armazenamento;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.GeradorId;

public class ArmazenamentoEmXml implements Armazenamento {

	private String nomeArquivo;

	public ArmazenamentoEmXml(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public Zoologico recuperar(GeradorId geradorId) throws ZooException {
		Path path = Paths.get(this.nomeArquivo);
		Zoologico zoo = null;
		String xml = "";

		if (Files.exists(path)) {
			try {
				List<String> linhas = Files.readAllLines(path);
				for (String linha : linhas) {
					xml += linha;
					xml += " ";
				}
				xml = xml.trim();
			} catch (IOException e) {
				throw new ZooException("Houve algum erro ao tentar recuperar os dados do zoológico!", e);
			}

			XStream xstream = obterXstream();
			zoo = (Zoologico) xstream.fromXML(xml);
			zoo.setGeradorId(geradorId);
		} else {
			zoo = new Zoologico(geradorId);
		}

		return zoo;
	}

	@Override
	public void armazenar(Zoologico zoo) throws ZooException {
		XStream xstream = obterXstream();
		String xml = xstream.toXML(zoo);

		Path path = Paths.get(this.nomeArquivo);
		try {
			Files.write(path, Arrays.asList(xml), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (IOException e) {
			throw new ZooException("Houve algum erro ao tentar armazenar os dados do zoológico!", e);
		}
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
