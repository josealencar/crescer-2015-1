
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest
{
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void alistarUmElfoNaoPermitido(){
        Elfo umElfo = new Elfo("Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        HashMap <String, Elfo> exercitoEsperado = new HashMap<>();
        exercito.alistarElfo(umElfo);
        
        assertEquals(exercitoEsperado, exercito.getExercito());
    }
    
    @Test
    public void alistarUmElfoPermitido(){
        ElfoVerde umElfo = new ElfoVerde("Legolas");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        HashMap <String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(umElfo.getNome(), umElfo);
        exercito.alistarElfo(umElfo);
        
        assertEquals(exercitoEsperado, exercito.getExercito());
    }
    
    @Test
    public void alistarDoisElfosPermitidos(){
        ElfoVerde umElfo = new ElfoVerde("Legolas");
        ElfoNoturno outroElfo = new ElfoNoturno("umElfo");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        HashMap <String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(umElfo.getNome(), umElfo);
        exercitoEsperado.put(outroElfo.getNome(), outroElfo);
        exercito.alistarElfo(umElfo);
        exercito.alistarElfo(outroElfo);
        
        assertEquals(exercitoEsperado, exercito.getExercito());
    }
    
    @Test
    public void buscarUmElfoAlistado(){
        String nome = "Legolas";
        ElfoVerde umElfo = new ElfoVerde(nome);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(umElfo);
        
        Elfo esperado = umElfo;
        
        assertEquals(esperado, exercito.getElfoAlistado(nome));
    }
}
