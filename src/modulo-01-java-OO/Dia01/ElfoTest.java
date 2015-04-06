

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test
    public void nasceComNomeEFlechasPadraoE0Exp(){
        String nome="Legolas";
        
        Elfo umElfo;
        umElfo=new Elfo(nome);
        
        String esperadoNome=nome;
        int esperadoFlechas=42;
        int esperadoExperiencia=0;
        String resultadoObtidoNome=umElfo.getNome();
        int resultadoObtidoFlechas=umElfo.getFlechas();
        int resultadoObtidoExperiencia=umElfo.getExperiencia();
        
        assertEquals(esperadoNome, resultadoObtidoNome);
        assertEquals(esperadoFlechas, resultadoObtidoFlechas);
        assertEquals(esperadoExperiencia, resultadoObtidoExperiencia);
    }
    
    @Test
    public void nasceComNomeEFlechasEscolhidas(){
        String nome="Legolas";
        int flechas=100;
        
        Elfo umElfo;
        umElfo=new Elfo(nome,flechas);
        
        int esperadoFlechas=flechas;
        int resultadoObtidoFlechas=umElfo.getFlechas();
        
        assertEquals(esperadoFlechas, resultadoObtidoFlechas);
    }
    
    @Test
    public void atiraFlechas(){
        int teste=100;
        String nome="Legolas";
        
        Elfo umElfo;
        Orc umOrc;
        Elfo[] arrayElfos=new Elfo[teste];
        
        umElfo=new Elfo(nome);
        umOrc=new Orc();
        
        for(int i=0;i<teste;i++){
            arrayElfos[i]=new Elfo(nome);
        }
        
        //umElfo atira uma flecha
        umElfo.atirarFlecha(umOrc);
        
        int esperado=41;
        int resultadoObtido=umElfo.getFlechas();
        
        assertEquals(esperado, resultadoObtido);
        
        //umElfo atira várias flechas
        int esperado2=41;
        for(int i=0;i<teste;i++){
            umElfo.atirarFlecha(umOrc);
            esperado2--;
        }
        int resultadoObtido2=umElfo.getFlechas();
        
        assertEquals(esperado2, resultadoObtido2);
        
        //arrayElfos atira uma flecha cada
        int esperado3=41;
        for(int i=0;i<teste;i++){
            arrayElfos[i].atirarFlecha(umOrc);
            int resultadoObtido3=arrayElfos[i].getFlechas();
            
            assertEquals(esperado3, resultadoObtido3);
        }
        
        //arrayElfos atirando várias flechas
        int esperado4=41;
        for(int i=0;i<teste;i++){
            for(int o=0;o<teste;o++){
                arrayElfos[i].atirarFlecha(umOrc);
                esperado4--;
            }
            int resultadoObtido4=arrayElfos[i].getFlechas();
            
            assertEquals(esperado4, resultadoObtido4);
            esperado4=41;
        }
    }
    
    @Test
    public void ganhaExperiencia(){
        int teste=100;
        String nome="Legolas";
        
        Elfo umElfo;
        Orc umOrc;
        Elfo[] arrayElfos=new Elfo[teste];
        
        umElfo=new Elfo(nome);
        umOrc=new Orc();
        
        for(int i=0;i<teste;i++){
            arrayElfos[i]=new Elfo(nome);
        }
        
        //umElfo ganha 1 em experiencia
        umElfo.atirarFlecha(umOrc);
        
        int esperado=1;
        int resultadoObtido=umElfo.getExperiencia();
        
        assertEquals(esperado, resultadoObtido);
        
        //umElfo ganha várias experiencias
        int esperado2=teste+1;
        for(int i=0;i<teste;i++){
            umElfo.atirarFlecha(umOrc);
        }
        int resultadoObtido2=umElfo.getExperiencia();
        
        assertEquals(esperado2, resultadoObtido2);
        
        //arrayElfos ganha 1 em experiencia cada
        int esperado3=1;
        for(int i=0;i<teste;i++){
            arrayElfos[i].atirarFlecha(umOrc);
            int resultadoObtido3=arrayElfos[i].getExperiencia();
            
            assertEquals(esperado3, resultadoObtido3);
        }
        
        //arrayElfos atirando várias flechas
        int esperado4=teste+1;
        for(int i=0;i<teste;i++){
            for(int o=0;o<teste;o++){
                arrayElfos[i].atirarFlecha(umOrc);
            }
            int resultadoObtido4=arrayElfos[i].getExperiencia();
            
            assertEquals(esperado4, resultadoObtido4);
        }
    }
}
