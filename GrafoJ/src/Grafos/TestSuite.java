package Grafos;


import Grafos.GrafoLista.grafoListaTest;
import Grafos.GrafoMatrizNDir.grafoMatrizNDirTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({grafoListaTest.class, grafoMatrizNDirTest.class})
public class TestSuite {

}
