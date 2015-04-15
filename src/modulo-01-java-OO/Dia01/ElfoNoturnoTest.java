

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
    private final double DELTA = 0.005;
    
    @Test
    public void elfoNoturnoNasceCom100DeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        double esperado = 100;
        
        assertEquals(esperado, umElfo.getVida(), DELTA);
    }
    
    @Test
    public void elfoNoturnoGanhaTresDeExperienciaPorFlechaLancadaEPerde5PorCentoDeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        umElfo.atirarFlecha(new Orc("nome"));
        
        int esperado = 3;
        double esperadoVida = 95;
        
        assertEquals(esperado, umElfo.getExperiencia());
        assertEquals(esperadoVida, umElfo.getVida(), DELTA);
    }
    
    @Test
    public void elfoNoturnoGanhaSeisDeExperienciaPorDuasFlechasLancadasEPerdeVida(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        umElfo.atirarFlecha(new Orc("nome"));
        umElfo.atirarFlecha(new Orc("nome"));
        
        int esperado = 6;
        double esperadoVida = 90.25;
        
        assertEquals(esperado, umElfo.getExperiencia());
        assertEquals(esperadoVida, umElfo.getVida(), DELTA);
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
        double esperadoVida = 77.3781;
        
        assertEquals(esperado, umElfo.getExperiencia());
        assertEquals(esperadoVida, umElfo.getVida(), DELTA);
    }
    
    @Test
    public void elfoNoturnoMorreAtirandoFlecha(){
        String nome = "umElfo";
        ElfoNoturno umElfo;
        
        umElfo = new ElfoNoturno(nome);
        
        for(int i=0; i < 100; i++){
            umElfo.atirarFlecha(new Orc("nome"));
        }
        
        double esperadoVida = 0;
        Status statusEsperado = Status.MORTO;
        
        assertEquals(esperadoVida, umElfo.getVida(), DELTA);
        assertEquals(statusEsperado, umElfo.getStatus());
    }
}
