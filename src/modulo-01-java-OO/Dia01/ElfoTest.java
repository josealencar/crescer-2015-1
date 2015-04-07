<<<<<<< HEAD
<<<<<<< HEAD


=======
>>>>>>> 75262ee16a900ba75c82dcd8d0f2f9e6eaff89ea
=======

>>>>>>> a201db61e5f67987d31192710c56cf8c365356ea
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
<<<<<<< HEAD
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
=======
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
<<<<<<< HEAD
>>>>>>> 75262ee16a900ba75c82dcd8d0f2f9e6eaff89ea
=======
>>>>>>> 48edd962379c28721428de9fe01092bd5fc74457
>>>>>>> a201db61e5f67987d31192710c56cf8c365356ea
 */
public class ElfoTest
{
    @Test
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> a201db61e5f67987d31192710c56cf8c365356ea
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


    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    
    
    
    
    
    
    
    
    
    
}


<<<<<<< HEAD

>>>>>>> 75262ee16a900ba75c82dcd8d0f2f9e6eaff89ea
=======
>>>>>>> a201db61e5f67987d31192710c56cf8c365356ea
