import java.util.*;

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
        String nome = "umElfoVerde";
        ElfoVerde umElfo = new ElfoVerde(nome);
        
        ItemDoInventario adaga = new ItemDoInventario("adaga", 12);
        
        umElfo.adicionarItem(adaga);
        
        ArrayList<ItemDoInventario> esperado = new ArrayList<>();
        
        assertEquals(esperado, umElfo.getItens());
    }
    
    @Test
    public void elfoVerdeTentaReceberUmaArmaPermitida(){
        String nome = "umElfoVerde";
        ElfoVerde umElfo = new ElfoVerde(nome);
        
        ItemDoInventario espada = new ItemDoInventario("Espada de aço valiriano", 1);
        
        umElfo.adicionarItem(espada);
        
        ArrayList<ItemDoInventario> esperado = new ArrayList<>();
        esperado.add(espada);
        
        assertEquals(esperado, umElfo.getItens());
    }
    
    @Test
    public void elfoVerdeAtiraUmaFlechaEGanhaDoisDeExperiencia(){
        String nome = "umElfoVerde";
        ElfoVerde umElfo = new ElfoVerde(nome);
        
        Orc umOrc = new Orc("nome");
        
        umElfo.atirarFlecha(umOrc);
        
        int esperado = 2;
        
        assertEquals(esperado, umElfo.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAtiraDuasFlechasEGanhaQuatroDeExperiencia(){
        String nome = "umElfoVerde";
        ElfoVerde umElfo = new ElfoVerde(nome);
        
        Orc umOrc = new Orc("nome");
        
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        
        int esperado = 4;
        
        assertEquals(esperado, umElfo.getExperiencia());
    }
    
    @Test
    public void elfoVerdeAtiraDuasFlechasEmOrcsDiferentesEGanhaQuatroDeExperiencia(){
        String nome = "umElfoVerde";
        ElfoVerde umElfo = new ElfoVerde(nome);
        
        Orc umOrc = new Orc("nome");
        Orc outroOrc = new Orc("nome");
        
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(outroOrc);
        
        int esperado = 4;
        
        assertEquals(esperado, umElfo.getExperiencia());
    }
    
    @Test
    public void elfoVerdeNasceCom100DeVida(){
        String nome = "umElfoVerde";
        ElfoVerde umElfo;
        
        umElfo = new ElfoVerde(nome);
        
        int esperado = 100;
        
        assertEquals(esperado, umElfo.getVida());
    }
}
