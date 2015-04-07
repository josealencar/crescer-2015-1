import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes integrados entre objetos Elfo e Orc.
 *
 * @author  CWI Software
 */
public class TestesIntegrados
{
    @Test
    public void umElfoAtiraEmDoisOrcs() {
        // Arrange
        Elfo elfo = new Elfo("O Elfo");
        Orc orc1 = new Orc("umNomeGrandeComExp");
        Orc orc2 = new Orc("umNomeGrandeComExp");
        orc1.setStatus(Status.CACANDO);
        orc1.setExperiencia(10);
        orc2.setStatus(Status.CACANDO);
        orc2.setExperiencia(10);
        // Act
        elfo.atirarFlecha(orc1);
        elfo.atirarFlecha(orc2);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        int vidaEsperadaOrc = 100;
        String toStringEsperadoOrc = "Vida atual: 100";
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperadaOrc, orc1.getVida());
        assertEquals(vidaEsperadaOrc, orc2.getVida());
        assertEquals(toStringEsperadoOrc, orc1.toString());
        assertEquals(toStringEsperadoOrc, orc2.toString());
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
