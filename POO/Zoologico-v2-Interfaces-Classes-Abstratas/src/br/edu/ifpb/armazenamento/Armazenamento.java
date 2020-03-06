package br.edu.ifpb.armazenamento;

import br.edu.ifpb.dominio.Zoologico;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.GeradorId;

public interface Armazenamento {

	public Zoologico recuperar(GeradorId geradorId) throws ZooException;
	
	public void armazenar(Zoologico zoo) throws ZooException;
	
}
