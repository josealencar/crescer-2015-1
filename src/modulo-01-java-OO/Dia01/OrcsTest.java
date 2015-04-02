

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcsTest
{
    @Test
    public void orcNasceCom110Vida(){
        // A (Arrange - Montagem dos dados de teste)
        Orcs umOrc;
        // A (Act - Execução da ação de testes)
        umOrc=new Orcs("Alguem");
        // A (Assert - Verificação se o resultado é o esperado)
        int esperado =110;
        int resultadoObtido=umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
}
