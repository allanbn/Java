package Grafos.GrafoLista;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;


public class grafoListaTest extends funcoesGrafoLista {
//    private funcoesGrafoLista F = new funcoesGrafoLista();
	
	private LinkedList<String> V_P = new LinkedList<>();
	private LinkedList<String> V_P_S = new LinkedList<>();
	private LinkedList<String> V_C1 = new LinkedList<>();
	private LinkedList<String> V_C2 = new LinkedList<>();
	private LinkedList<String> V_C3 = new LinkedList<>();
	private LinkedList<String> V_L1 = new LinkedList<>();
	private LinkedList<String> V_L2 = new LinkedList<>();
	private LinkedList<String> V_L3 = new LinkedList<>();
	private LinkedList<String> V_L4 = new LinkedList<>();
	private LinkedList<String> V_L5 = new LinkedList<>();
	
	private LinkedHashMap<String, String> A_P = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_P_S = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_C1 = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_C2 = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_L1 = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_L2 = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_L3 = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_L4 = new LinkedHashMap<>();
	private LinkedHashMap<String, String> A_L5 = new LinkedHashMap<>();
	
	private final LinkedList<String> R_P = new LinkedList<>(Arrays.asList(
			"J-J", "J-E", "J-P", "J-M", "J-T", "J-Z", "C-C",
			"C-Z", "E-J", "E-E", "E-P", "E-M", "E-T", "E-Z",
			"P-J", "P-E", "P-P", "P-M", "P-T", "P-Z", "M-J",
			"M-E", "M-P", "M-M", "M-Z", "T-J", "T-E", "T-P",
			"T-T", "Z-J", "Z-C", "Z-E", "Z-P", "Z-M", "Z-Z"));
	private final LinkedList<String> R_C1 = new LinkedList<>(Arrays.asList(
			"J-J", "C-C", "E-E", "P-P"));
	private final LinkedList<String> R_C2 = new LinkedList<>(Arrays.asList(
			"J-J", "C-C", "E-E", "P-P"));
	private final LinkedList<String> R_C3 = new LinkedList<>(Collections.singletonList(
			"J-J"));
	private final LinkedList<String> R_P_A_A = new LinkedList<>(Collections.singletonList(
			"a1"));
	private final LinkedList<String> R_P_A_C = new LinkedList<>(Arrays.asList(
			"a1", "a2", "a3", "a4", "a5", "a6", "a7"));
	private final LinkedList<String> R_P_A_M = new LinkedList<>(Arrays.asList(
			"a6", "a8"));
	
	
	private grafoLista G_P;
	private grafoLista G_P_S;
	private grafoLista G_C1;
	private grafoLista G_C2;
	private grafoLista G_C3;
	private grafoLista G_L1;
	private grafoLista G_L2;
	private grafoLista G_L3;
	private grafoLista G_L4;
	private grafoLista G_L5;
	
	@Before
	public void setUp() {
		// Grafos.GrafoLista da Paraiba
		this.V_P = new LinkedList<>(Arrays.asList("J", "C", "E", "P", "M", "T", "Z"));
		
		this.A_P.put("a1", "J-C");
		this.A_P.put("a2", "C-E");
		this.A_P.put("a3", "C-E");
		this.A_P.put("a4", "C-P");
		this.A_P.put("a5", "C-P");
		this.A_P.put("a6", "C-M");
		this.A_P.put("a7", "C-T");
		this.A_P.put("a8", "M-T");
		this.A_P.put("a9", "T-Z");
		
		this.G_P = new grafoLista(this.V_P, this.A_P);
		
		// Grafos.GrafoLista da Paraiba sem paralelas
		this.V_P_S = new LinkedList<>(Arrays.asList("J", "C", "P", "M", "T", "Z"));
		
		this.A_P_S.put("a1", "J-C");
		this.A_P_S.put("a3", "C-E");
		this.A_P_S.put("a4", "C-P");
		this.A_P_S.put("a6", "C-M");
		this.A_P_S.put("a7", "C-T");
		this.A_P_S.put("a8", "M-T");
		this.A_P_S.put("a9", "T-Z");
		
		this.G_P_S = new grafoLista(this.V_P_S, this.A_P_S);
		// Grafos.GrafoLista completos
		this.V_C1 = new LinkedList<>(Arrays.asList("J", "C", "E", "P"));
		
		this.A_C1.put("a1", "J-C");
		this.A_C1.put("a3", "J-E");
		this.A_C1.put("a4", "J-P");
		this.A_C1.put("a6", "C-E");
		this.A_C1.put("a7", "C-P");
		this.A_C1.put("a8", "E-P");
		
		this.G_C1 = new grafoLista(this.V_C1, this.A_C1);
		
		this.V_C2 = new LinkedList<>(Arrays.asList("J", "C", "E", "P"));
		this.A_C2.put("a1", "J-C");
		this.A_C2.put("a3", "E-J");
		this.A_C2.put("a4", "J-P");
		this.A_C2.put("a6", "E-C");
		this.A_C2.put("a7", "C-P");
		this.A_C2.put("a8", "P-E");
		
		this.G_C2 = new grafoLista(this.V_C2, this.A_C2);
		
		this.V_C3 = new LinkedList<>(Collections.singletonList("J"));
		
		this.G_C3 = new grafoLista(this.V_C3);
		
		// Grafos.GrafoLista com lacos
		this.V_L1 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		
		this.A_L1.put("a1", "A-A");
		this.A_L1.put("a2", "B-A");
		this.A_L1.put("a3", "A-A");
		
		this.G_L1 = new grafoLista(this.V_L1, this.A_L1);
		
		this.V_L2 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		
		this.A_L2.put("a1", "A-B");
		this.A_L2.put("a2", "B-B");
		this.A_L2.put("a3", "B-A");
		
		this.G_L2 = new grafoLista(this.V_L2, this.A_L2);
		
		this.V_L3 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		
		this.A_L3.put("a1", "C-A");
		this.A_L3.put("a2", "C-C");
		this.A_L3.put("a3", "D-D");
		
		this.G_L3 = new grafoLista(this.V_L3, this.A_L3);
		
		this.V_L4 = new LinkedList<>(Collections.singletonList("D"));
		
		this.A_L4.put("a1", "D-D");
		
		this.G_L4 = new grafoLista(this.V_L4, this.A_L4);
		
		
		this.V_L5 = new LinkedList<>(Arrays.asList("C", "D"));
		
		this.A_L5.put("a1", "D-C");
		this.A_L5.put("a2", "C-C");
		
		this.G_L5 = new grafoLista(this.V_L5, this.A_L5);
	}
	
	@Test
	public void verticesNaoAdjcts() {
		assertEquals(super.verticesNaoAdjcts(this.G_P), this.R_P);
		assertEquals(super.verticesNaoAdjcts(this.G_P), this.R_P);
		assertEquals(super.verticesNaoAdjcts(this.G_C1), this.R_C1);
		assertEquals(super.verticesNaoAdjcts(this.G_C2), this.R_C2);
		assertEquals(super.verticesNaoAdjcts(this.G_C3), this.R_C3);
	}
	
	@Test
	public void haLaco() {
		assertFalse(super.haLaco(this.G_P));
		assertFalse(super.haLaco(this.G_P_S));
		assertTrue(super.haLaco(this.G_L1));
		assertTrue(super.haLaco(this.G_L2));
		assertTrue(super.haLaco(this.G_L3));
		assertTrue(super.haLaco(this.G_L4));
		assertTrue(super.haLaco(this.G_L5));
	}
	
	@Test
	public void haParalela() {
		assertFalse(super.haParalela(this.G_C1));
		assertFalse(super.haParalela(this.G_C2));
		assertFalse(super.haParalela(this.G_C3));
		assertTrue(super.haParalela(this.G_L1));
	}
	
	@Test
	public void grauVert() {
		// Paraiba
		assertEquals(super.grauVert(this.G_P, "J"), 1);
		assertEquals(super.grauVert(this.G_P, "C"), 7);
		assertEquals(super.grauVert(this.G_P, "E"), 2);
		assertEquals(super.grauVert(this.G_P, "P"), 2);
		assertEquals(super.grauVert(this.G_P, "M"), 2);
		assertEquals(super.grauVert(this.G_P, "T"), 3);
		assertEquals(super.grauVert(this.G_P, "Z"), 1);
		// Completos
		assertEquals(super.grauVert(this.G_C1, "J"), 3);
		assertEquals(super.grauVert(this.G_C1, "C"), 3);
		assertEquals(super.grauVert(this.G_C1, "E"), 3);
		assertEquals(super.grauVert(this.G_C1, "P"), 3);
		// Lacos
		assertEquals(super.grauVert(this.G_L1, "A"), 3);
		assertEquals(super.grauVert(this.G_L2, "B"), 3);
		assertEquals(super.grauVert(this.G_L4, "D"), 1);
	}
	
	@Test
	public void arestaSobreVert() {
		assertEquals(super.arestaSobreVert(this.G_P, "J"), this.R_P_A_A);
		assertEquals(super.arestaSobreVert(this.G_P, "C"), this.R_P_A_C);
		assertEquals(super.arestaSobreVert(this.G_P, "M"), this.R_P_A_M);
	}
	
	@Test
	public void ehCompleto() {
		assertTrue(super.ehCompleto(this.G_C1));
		assertTrue(super.ehCompleto(this.G_C2));
		assertTrue(super.ehCompleto(this.G_C3));
		assertFalse(super.ehCompleto(this.G_L1));
		assertFalse(super.ehCompleto(this.G_L2));
		assertFalse(super.ehCompleto(this.G_L3));
		assertTrue(super.ehCompleto(this.G_L4));
		assertTrue(super.ehCompleto(this.G_L5));
	}
}


