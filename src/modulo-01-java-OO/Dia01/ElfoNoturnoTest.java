

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoNasceCom100DeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        int esperado = 100;
        
        assertEquals(esperado, umElfo.getVida());
    }
    
    @Test
    public void elfoNoturnoGanhaTresDeExperienciaPorFlechaLancadaEPerde5PorCentoDeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        umElfo.atirarFlecha(new Orc("nome"));
        
        int esperado = 3;
        int esperadoVida = 95;
        
        assertEquals(esperado, umElfo.getExperiencia());
        assertEquals(esperadoVida, umElfo.getVida());
    }
    
    @Test
    public void elfoNoturnoGanhaSeisDeExperienciaPorDuasFlechasLancadasEPerdeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        umElfo.atirarFlecha(new Orc("nome"));
        umElfo.atirarFlecha(new Orc("nome"));
        
        int esperado = 6;
        int esperadoVida = 90;
        
        assertEquals(esperado, umElfo.getExperiencia());
        assertEquals(esperadoVida, umElfo.getVida());
    }
    
    @Test
    public void elfoNoturnoGanhaQuinzeDeExperienciaPorFlechasLancadasEPerdeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        umElfo.atirarFlecha(new Orc("nome"));
        umElfo.atirarFlecha(new Orc("nome"));
        umElfo.atirarFlecha(new Orc("nome"));
        umElfo.atirarFlecha(new Orc("nome"));
        umElfo.atirarFlecha(new Orc("nome"));
        
        int esperado = 15;
        int esperadoVida = 76;
        
        assertEquals(esperado, umElfo.getExperiencia());
        assertEquals(esperadoVida, umElfo.getVida());
    }
}
