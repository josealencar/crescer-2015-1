

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test
    public void criarUmElfoVerdeComFlechasPadrao(){
        String nome = "Elfo Verde";
        ElfoVerde umElfo;
        
        umElfo = new ElfoVerde(nome);
        
        String nomeEsperado = nome;
        String corEsperado = "VERDE";
        
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(corEsperado, umElfo.getCor());
    }
    
    @Test
    public void criarUmElfoVerdeComFlechasInformada(){
        String nome = "Elfo Verde";
        int flechas = 100;
        ElfoVerde umElfo;
        
        umElfo = new ElfoVerde(nome, flechas);
        
        String nomeEsperado = nome;
        int flechasEsperado = flechas;
        String corEsperado = "VERDE";
        
        assertEquals(nomeEsperado, umElfo.getNome());
        assertEquals(corEsperado, umElfo.getCor());
        assertEquals(flechasEsperado, umElfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeTentaReceberUmaArmaNaoPermitida(){
        
    }
}
