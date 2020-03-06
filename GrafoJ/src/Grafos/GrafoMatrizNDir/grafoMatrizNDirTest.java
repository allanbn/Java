package Grafos.GrafoMatrizNDir;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class grafoMatrizNDirTest extends funcoesGrafoMatrizNDir {
	
	private grafoMatrizNDir konigsberg;
	private grafoMatrizNDir konigsbergMod;
	private grafoMatrizNDir g_c_e;
	private grafoMatrizNDir g_p;
	private grafoMatrizNDir g_c;
	private grafoMatrizNDir g_p_sem_paralelas;
	
	private grafoMatrizNDir G_C2;
	private grafoMatrizNDir G_C3;
	private grafoMatrizNDir G_L1;
	private grafoMatrizNDir G_L2;
	private grafoMatrizNDir G_L3;
	private grafoMatrizNDir G_L4;
	private grafoMatrizNDir G_L5;
	
	private String[] konigsbergV = {"M", "T", "B", "R"};
	private String[] konigsbergA = {
			"M-T", "M-T", "M-B", "M-B", "M-R", "B-R", "T-R"
	};
	
	private String[] konigsberg_modV = {"M", "T", "B", "R"};
	private String[] konigsberg_modA = {
			"M-T", "M-T", "M-B", "M-B", "M-R", "M-R", "B-R", "T-R"
	};
	
	private String[] g_c_eV = {"A", "B", "C"};
	private String[] g_c_eA = {
			"A-B", "B-C"
	};
	
	private String[] g_pV = {"J", "C", "E", "P", "M", "T", "Z"};
	private String[] g_pA = {
			"J-C", "C-E", "C-E", "C-P", "C-P", "C-M", "C-T", "M-T", "T-Z"
	};
	
	private String[] g_p_sem_paralelasV = {"J", "C", "E", "P", "M", "T", "Z"};
	private String[] g_p_sem_paralelasA = {
			"J-C", "C-E", "C-P", "C-M", "C-T", "M-T", "T-Z"
	};
	
	private String[] g_cV = {"J", "C", "E", "P"};
	private String[] g_cA = {
			"J-C", "J-E", "J-P", "C-E", "C-P", "E-P"
	};
	
	private LinkedList<String> V_C2 = new LinkedList<>();
	private LinkedList<String> V_C3 = new LinkedList<>();
	private LinkedList<String> V_L1 = new LinkedList<>();
	private LinkedList<String> V_L2 = new LinkedList<>();
	private LinkedList<String> V_L3 = new LinkedList<>();
	private LinkedList<String> V_L4 = new LinkedList<>();
	private LinkedList<String> V_L5 = new LinkedList<>();
	
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
	private final LinkedList<String> R_C3 = new LinkedList<>(Collections.singletonList(
			"J-J"));
	private final LinkedList<String> R_P_A_A = new LinkedList<>(Collections.singletonList(
			"a1"));
	private final LinkedList<String> R_P_A_C = new LinkedList<>(Arrays.asList(
			"a1", "a2", "a3", "a4", "a5", "a6", "a7"));
	private final LinkedList<String> R_P_A_M = new LinkedList<>(Arrays.asList(
			"a6", "a8"));
	
	
	@Before
	public void setUp() {
		
		konigsberg = new grafoMatrizNDir(konigsbergV);
		konigsberg.adicionaArestasArray(konigsbergA);
		
		konigsbergMod = new grafoMatrizNDir(konigsberg_modV);
		konigsbergMod.adicionaArestasArray(konigsberg_modA);
		
		g_c_e = new grafoMatrizNDir(g_c_eV);
		g_c_e.adicionaArestasArray(g_c_eA);
		
		g_p = new grafoMatrizNDir(g_pV);
		g_p.adicionaArestasArray(g_pA);
		
		g_c = new grafoMatrizNDir(g_cV);
		g_c.adicionaArestasArray(g_cA);
		
		g_p_sem_paralelas = new grafoMatrizNDir(g_p_sem_paralelasV);
		g_p_sem_paralelas.adicionaArestasArray(g_p_sem_paralelasA);
		
		this.V_C2 = new LinkedList<>(Arrays.asList("J", "C", "E", "P"));
//        "J-C", "J-E", "J-P", "C-E", "C-P", "E-P"
		this.A_C2.put("a1", "J-C");
		this.A_C2.put("a3", "E-J");
		this.A_C2.put("a4", "J-P");
		this.A_C2.put("a6", "E-C");
		this.A_C2.put("a7", "C-P");
		this.A_C2.put("a8", "P-E");
		
		this.G_C2 = new grafoMatrizNDir(this.V_C2, this.A_C2);
		
		this.V_C3 = new LinkedList<>(Collections.singletonList("J"));
		
		this.G_C3 = new grafoMatrizNDir(this.V_C3);
		
		// Grafos.GrafoLista com lacos
		this.V_L1 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		
		this.A_L1.put("a1", "A-A");
		this.A_L1.put("a2", "B-A");
		this.A_L1.put("a3", "A-A");
		
		this.G_L1 = new grafoMatrizNDir(this.V_L1, this.A_L1);
		
		this.V_L2 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		
		this.A_L2.put("a1", "A-B");
		this.A_L2.put("a2", "B-B");
		this.A_L2.put("a3", "B-A");
		
		this.G_L2 = new grafoMatrizNDir(this.V_L2, this.A_L2);
		
		this.V_L3 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
		
		this.A_L3.put("a1", "C-A");
		this.A_L3.put("a2", "C-C");
		this.A_L3.put("a3", "D-D");
		
		this.G_L3 = new grafoMatrizNDir(this.V_L3, this.A_L3);
		
		this.V_L4 = new LinkedList<>(Collections.singletonList("D"));
		
		this.A_L4.put("a1", "D-D");
		
		this.G_L4 = new grafoMatrizNDir(this.V_L4, this.A_L4);
		
		
		this.V_L5 = new LinkedList<>(Arrays.asList("C", "D"));
		
		this.A_L5.put("a1", "D-C");
		this.A_L5.put("a2", "C-C");
		
		this.G_L5 = new grafoMatrizNDir(this.V_L5, this.A_L5);
		
	}
	
	@Test
	public void verticesNaoAdjcts() {
		assertEquals(super.verticesNaoAdjcts(this.g_p), this.R_P);
		assertEquals(super.verticesNaoAdjcts(this.g_c), this.R_C1);
		assertEquals(super.verticesNaoAdjcts(this.G_C2), this.R_C1);
		assertEquals(super.verticesNaoAdjcts(this.G_C3), this.R_C3);
	}
	
	@Test
	public void haLaco() {
		assertFalse(super.haLaco(this.g_p));
		assertFalse(super.haLaco(this.g_p_sem_paralelas));
		assertTrue(super.haLaco(this.G_L1));
		assertTrue(super.haLaco(this.G_L2));
		assertTrue(super.haLaco(this.G_L3));
		assertTrue(super.haLaco(this.G_L4));
		assertTrue(super.haLaco(this.G_L5));
	}
	
	@Test
	public void haParalela() {
		assertFalse(super.haParalela(this.g_c));
		assertFalse(super.haParalela(this.G_C2));
		assertFalse(super.haParalela(this.G_C3));
		assertTrue(super.haParalela(this.G_L1));
	}
	
	@Test
	public void grauVert() {
		// Paraiba
		assertEquals(super.grauVert(this.g_p, "J"), 1);
		assertEquals(super.grauVert(this.g_p, "C"), 7);
		assertEquals(super.grauVert(this.g_p, "E"), 2);
		assertEquals(super.grauVert(this.g_p, "P"), 2);
		assertEquals(super.grauVert(this.g_p, "M"), 2);
		assertEquals(super.grauVert(this.g_p, "T"), 3);
		assertEquals(super.grauVert(this.g_p, "Z"), 1);
		// Completos
		assertEquals(super.grauVert(this.g_c, "J"), 3);
		assertEquals(super.grauVert(this.g_c, "C"), 3);
		assertEquals(super.grauVert(this.g_c, "E"), 3);
		assertEquals(super.grauVert(this.g_c, "P"), 3);
		// Lacos
		assertEquals(super.grauVert(this.G_L1, "A"), 3);
		assertEquals(super.grauVert(this.G_L2, "B"), 3);
		assertEquals(super.grauVert(this.G_L4, "D"), 1);
	}
	
	@Test
	public void arestaSobreVert() {
		assertEquals(super.arestaSobreVert(this.g_p, "J"), this.R_P_A_A);
		assertEquals(super.arestaSobreVert(this.g_p, "C"), this.R_P_A_C);
		assertEquals(super.arestaSobreVert(this.g_p, "M"), this.R_P_A_M);
	}
	
	@Test
	public void ehCompleto() {
		assertTrue(super.ehCompleto(this.g_c));
		assertTrue(super.ehCompleto(this.G_C2));
		assertTrue(super.ehCompleto(this.G_C3));
		assertFalse(super.ehCompleto(this.G_L1));
		assertFalse(super.ehCompleto(this.G_L2));
		assertFalse(super.ehCompleto(this.G_L3));
		assertTrue(super.ehCompleto(this.G_L4));
		assertTrue(super.ehCompleto(this.G_L5));
	}
	
	@Test
	public void caminhoEuleriano() {
		assertTrue(super.caminhoEuleriano(this.konigsbergMod));
		assertTrue(super.caminhoEuleriano(this.g_c_e));
		assertFalse(super.caminhoEuleriano(this.konigsberg));
		assertFalse(super.caminhoEuleriano(this.g_p));
		assertFalse(super.caminhoEuleriano(this.g_p_sem_paralelas));
		assertFalse(super.caminhoEuleriano(this.g_c));
	}
}
