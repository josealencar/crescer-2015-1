

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
<<<<<<< HEAD
    public void orcRecebeAtaque() {
        /**
         * @param teste = número de Orcs e Elfos criados nos arrayOrc e arrayElfo
         */
        
        int teste=100;
        
        Orc umOrc;
        Orc[] arrayOrc=new Orc[teste];
        Elfo umElfo;
        Elfo[] arrayElfo=new Elfo[teste];
        umOrc=new Orc();
        for(int i=0;i<teste;i++){
            arrayOrc[i]=new Orc();
        }
        umElfo=new Elfo("Legolas");
        for(int i=0;i<teste;i++){
            String nome="Legolas";
            nome+=i;
            arrayElfo[i]=new Elfo(nome);
        }
        
        //Um Elfo ataca um Orc
        umElfo.atirarFlecha(umOrc);
        int esperado=100;
        int resultadoObtido=umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
        
        //Um Elfo atacando vários Orcs
        int esperado1=100;
        for(int i=0;i<teste;i++){
            umElfo.atirarFlecha(arrayOrc[i]);
            int resultadoObtido1=arrayOrc[i].getVida();
            assertEquals(esperado1,resultadoObtido1);
        }
        
        //Vários Elfos atacando um Orc
        int esperado2=100;
        for(int i=0;i<teste;i++){
            arrayElfo[i].atirarFlecha(umOrc);
            esperado2-=10;
        }
        int resultadoObtido2=umOrc.getVida();
        
        assertEquals(esperado2,resultadoObtido2);
=======
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc();
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc();
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc();
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc();
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = -10;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
>>>>>>> 48edd962379c28721428de9fe01092bd5fc74457
    }
    
    
}




