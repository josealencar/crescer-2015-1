
import java.util.*;
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
        umOrc = new Orc("nome");
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test

    public void orcRecebeAtaque() {
        /**
         * @param teste = número de Orcs e Elfos criados nos arrayOrc e arrayElfo
         */
        
        int teste=100;
        
        Orc[] arrayOrc=new Orc[teste];
        Elfo umElfo;
        Elfo[] arrayElfo=new Elfo[teste];
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
        for(int i=0;i<teste;i++){
            arrayOrc[i]=new Orc("umNomeGrandeComExp");
            arrayOrc[i].setStatus(Status.CACANDO);
            arrayOrc[i].setExperiencia(10);
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
        int esperado2 = teste >= 11 ? 0 : 100/teste;
        for(int i=0;i<teste;i++){
            arrayElfo[i].atirarFlecha(umOrc);
        }
        int resultadoObtido2=umOrc.getVida();
        
        assertEquals(esperado2,resultadoObtido2);
    }

    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("nome");
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
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
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
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
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
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
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
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);

    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc("nome");
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc=new Orc("umNomeGrandeComExp");
        orc.setStatus(Status.CACANDO);
        orc.setExperiencia(10);
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
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
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceVivo(){
        //Arrange - Montagem dos dados de teste
        Orc umOrc;
        //Act
        umOrc=new Orc("nome");
        //Assert
        Status esperado = Status.VIVO;
        assertEquals(esperado, umOrc.getStatus());
    }
    
    @Test
    public void orcStatusMortoCom0Vida(){
        // Arrange - Montagem dos dados de teste
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
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
        // Assert
        Status esperado = Status.MORTO;
        assertEquals(esperado, umOrc.getStatus());
    }
    
    @Test
    public void orcNasceComNome(){
        // Arrange - Montagem dos dados de teste
        String nome="Um nome qualquer";
        Orc umOrc;
        // Act
        umOrc = new Orc(nome);
        // Assert
        String esperado = nome;
        assertEquals(esperado, umOrc.getNome());
    }
    
    @Test
    public void gerarNumeroNegativo(){
        // Arrange - Montagem dos dados de teste
        Orc umOrc=new Orc("nome");
        umOrc.setStatus(Status.DORMINDO);
        // Act
        umOrc.recebeAtaque();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, umOrc.toString());
        int esperadoExperiencia=2;
        assertEquals(esperadoExperiencia, umOrc.getExperiencia());
    }
    
    @Test
    public void gerarNumeroPositivoMenorQue100(){
        // Arrange - Montagem dos dados de teste
        Orc umOrc=new Orc("umNomeGrande");
        umOrc.setStatus(Status.DORMINDO);
        umOrc.setExperiencia(1);
        // Act
        umOrc.recebeAtaque();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, umOrc.toString());
        int esperadoExperiencia=1;
        assertEquals(esperadoExperiencia, umOrc.getExperiencia());
    }
    
    @Test
    public void gerarNumeroPositivoMaiorQue100(){
        // Arrange - Montagem dos dados de teste
        Orc umOrc=new Orc("umNomeGrandeComExp");
        umOrc.setStatus(Status.CACANDO);
        umOrc.setExperiencia(10);
        // Act
        umOrc.recebeAtaque();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, umOrc.toString());
        int esperadoExperiencia=10;
        assertEquals(esperadoExperiencia, umOrc.getExperiencia());
    }
    
    @Test
    public void adicionarUmItemNoInventario(){
        //Arrange
        String nomeItem="umItem";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        Orc umOrc = new Orc("umNome");
        //Act
        umOrc.adicionarItem(umItem);
        //Assert
        int esperado = 1;
        assertEquals(esperado, umOrc.getContarItensDoInventario());
    }
    
    @Test
    public void adicionarDoisItensNoInventario(){
        //Arrange
        String nomeItem="itemUm";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        String nomeItem2="itemDois";
        int quantidadeItem2=1;
        ItemDoInventario umItem2=new ItemDoInventario(nomeItem2, quantidadeItem2);
        Orc umOrc = new Orc("umNome");
        //Act
        umOrc.adicionarItem(umItem);
        umOrc.adicionarItem(umItem2);
        //Assert
        int esperado = 2;
        assertEquals(esperado, umOrc.getContarItensDoInventario());
    }
    
    @Test
    public void adicionarCincoItensNoInventario(){
        //Arrange
        String nomeItem="itemUm";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        
        String nomeItem2="itemDois";
        int quantidadeItem2=1;
        ItemDoInventario umItem2=new ItemDoInventario(nomeItem2, quantidadeItem2);
        
        String nomeItem3="itemTres";
        int quantidadeItem3=1;
        ItemDoInventario umItem3=new ItemDoInventario(nomeItem3, quantidadeItem3);
        
        String nomeItem4="itemQuatro";
        int quantidadeItem4=1;
        ItemDoInventario umItem4=new ItemDoInventario(nomeItem4, quantidadeItem4);
        
        String nomeItem5="itemCinco";
        int quantidadeItem5=1;
        ItemDoInventario umItem5=new ItemDoInventario(nomeItem5, quantidadeItem5);
        
        Orc umOrc = new Orc("umNome");
        
        //Act
        umOrc.adicionarItem(umItem);
        umOrc.adicionarItem(umItem2);
        umOrc.adicionarItem(umItem3);
        umOrc.adicionarItem(umItem4);
        umOrc.adicionarItem(umItem5);
        //Assert
        int esperado = 5;
        assertEquals(esperado, umOrc.getContarItensDoInventario());
    }
    
    @Test
    public void removerUmItemNoInventario(){
        //Arrange
        String nomeItem="umItem";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        
        Orc umOrc = new Orc("umNome");
        umOrc.adicionarItem(umItem);
        
        //Act
        umOrc.perderItem(umItem);
        
        //Assert
        int esperado = 0;
        assertEquals(esperado, umOrc.getContarItensDoInventario());
    }
    
    @Test
    public void adicionarDoisItensNoInventarioERemoverUm(){
        //Arrange
        String nomeItem="itemUm";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        String nomeItem2="itemDois";
        int quantidadeItem2=1;
        ItemDoInventario umItem2=new ItemDoInventario(nomeItem2, quantidadeItem2);
        Orc umOrc = new Orc("umNome");
        umOrc.adicionarItem(umItem);
        umOrc.adicionarItem(umItem2);
        //Act
        umOrc.perderItem(umItem);
        //Assert
        int esperado = 1;
        assertEquals(esperado, umOrc.getContarItensDoInventario());
    }
    
    @Test
    public void adicionarCincoItensNoInventarioERemoverDois(){
        //Arrange
        String nomeItem="itemUm";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        
        String nomeItem2="itemDois";
        int quantidadeItem2=1;
        ItemDoInventario umItem2=new ItemDoInventario(nomeItem2, quantidadeItem2);
        
        String nomeItem3="itemTres";
        int quantidadeItem3=1;
        ItemDoInventario umItem3=new ItemDoInventario(nomeItem3, quantidadeItem3);
        
        String nomeItem4="itemQuatro";
        int quantidadeItem4=1;
        ItemDoInventario umItem4=new ItemDoInventario(nomeItem4, quantidadeItem4);
        
        String nomeItem5="itemCinco";
        int quantidadeItem5=1;
        ItemDoInventario umItem5=new ItemDoInventario(nomeItem5, quantidadeItem5);
        
        Orc umOrc = new Orc("umNome");
        
        umOrc.adicionarItem(umItem);
        umOrc.adicionarItem(umItem2);
        umOrc.adicionarItem(umItem3);
        umOrc.adicionarItem(umItem4);
        umOrc.adicionarItem(umItem5);
        
        //Act
        umOrc.perderItem(umItem3);
        umOrc.perderItem(umItem5);
        
        //Assert
        int esperado = 3;
        assertEquals(esperado, umOrc.getContarItensDoInventario());
    }
    
    @Test
    public void verificarArrayListDeItens(){
        //Arrange
        String nomeItem="itemUm";
        int quantidadeItem=1;
        ItemDoInventario umItem=new ItemDoInventario(nomeItem, quantidadeItem);
        
        String nomeItem2="itemDois";
        int quantidadeItem2=1;
        ItemDoInventario umItem2=new ItemDoInventario(nomeItem2, quantidadeItem2);
        
        Orc umOrc = new Orc("umNome");
        
        //Act
        umOrc.adicionarItem(umItem);
        umOrc.adicionarItem(umItem2);
        
        //Assert
        ItemDoInventario esperado = umItem;
        ItemDoInventario esperado2 = umItem2;
        
        assertEquals(esperado, umOrc.getItem(0));
        assertEquals(esperado2, umOrc.getItem(1));
    }
    
    @Test
    public void imprimirItensCom3Itens(){
        //Arrange
        String nomeItem1 = "Adaga";
        String nomeItem2 = "Escudo";
        String nomeItem3 = "Bracelete";
        int qtdItem1 = 5;
        int qtdItem2 = 1;
        int qtdItem3 = 10;
        
        ItemDoInventario itemUm = new ItemDoInventario (nomeItem1, qtdItem1);
        ItemDoInventario itemDois = new ItemDoInventario (nomeItem2, qtdItem2);
        ItemDoInventario itemTres = new ItemDoInventario (nomeItem3, qtdItem3);
        
        Orc umOrc = new Orc("teste");
        
        //Act
        umOrc.adicionarItem(itemUm);
        umOrc.adicionarItem(itemDois);
        umOrc.adicionarItem(itemTres);
        
        //Assert
        String esperado = nomeItem1 + "," + nomeItem2 + "," + nomeItem3;
        
        assertEquals(esperado, umOrc.imprimirItens());
    }
    
    @Test
    public void imprimirItensCom1Item(){
        //Arrange
        String nomeItem1 = "Adaga";
        int qtdItem1 = 5;
        
        ItemDoInventario itemUm = new ItemDoInventario (nomeItem1, qtdItem1);
        
        Orc umOrc = new Orc("teste");
        
        //Act
        umOrc.adicionarItem(itemUm);
        
        //Assert
        String esperado = nomeItem1;
        
        assertEquals(esperado, umOrc.imprimirItens());
    }
    
    @Test
    public void imprimirItensComListaVazia(){
        //Arrange
        Orc umOrc = new Orc("teste");
        
        //Act
        
        //Assert
        String esperado = null;
        
        assertEquals(esperado, umOrc.imprimirItens());
    }
    
    @Test
    public void tentarSorteSemSorte(){
        Orc umOrc = new Orc("nome");
        String nomeItem = "item";
        int quantidadeItem = 20;
        ItemDoInventario item = new ItemDoInventario(nomeItem, quantidadeItem);
        
        umOrc.adicionarItem(item);
        
        umOrc.tentarSorte();
        
        int esperado = quantidadeItem;
        
        assertEquals(esperado, item.getQuantidade());
    }
    
    @Test
    public void tentarSorteComSorte(){
        Orc umOrc = new Orc("nome");
        String nomeItem = "item";
        int quantidadeItem = 20;
        ItemDoInventario item = new ItemDoInventario(nomeItem, quantidadeItem);
        
        umOrc.setExperiencia(5);
        umOrc.setStatus(Status.DORMINDO);
        umOrc.adicionarItem(item);
        
        umOrc.tentarSorte();
        
        int esperado = quantidadeItem+1000;
        ItemDoInventario novo = umOrc.getItem(0);
        
        assertEquals(esperado, novo.getQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeEntreDoisItens(){
        ItemDoInventario itemMenor = new ItemDoInventario("Machado", 10);
        ItemDoInventario itemMaior = new ItemDoInventario("Poção HP", 20);
        
        Orc umOrc = new Orc("orc");
        
        umOrc.adicionarItem(itemMenor);
        umOrc.adicionarItem(itemMaior);
        
        ItemDoInventario esperado = itemMaior;
        
        assertEquals(esperado, umOrc.getItemComMaiorQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeEntreCincoItens(){
        ItemDoInventario itemMenor = new ItemDoInventario("Machado", 10);
        ItemDoInventario itemMenor2 = new ItemDoInventario("Adaga", 13);
        ItemDoInventario itemMenor3 = new ItemDoInventario("Escudo", 16);
        ItemDoInventario itemMenor4 = new ItemDoInventario("Flecha", 19);
        ItemDoInventario itemMaior = new ItemDoInventario("Poção HP", 20);
        
        Orc umOrc = new Orc("orc");
        
        umOrc.adicionarItem(itemMenor);
        umOrc.adicionarItem(itemMenor2);
        umOrc.adicionarItem(itemMenor3);
        umOrc.adicionarItem(itemMenor4);
        umOrc.adicionarItem(itemMaior);
        
        ItemDoInventario esperado = itemMaior;
        
        assertEquals(esperado, umOrc.getItemComMaiorQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeSemItemNoInventario(){
        Orc umOrc = new Orc("orc");
        
        ItemDoInventario esperado = null;
        
        assertEquals(esperado, umOrc.getItemComMaiorQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeComUmItem(){
        ItemDoInventario itemMenor = new ItemDoInventario("Machado", 10);
        
        Orc umOrc = new Orc("orc");
        
        umOrc.adicionarItem(itemMenor);
        
        ItemDoInventario esperado = itemMenor;
        
        assertEquals(esperado, umOrc.getItemComMaiorQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeEntreDoisItensComMesmaQuantidade(){
        ItemDoInventario itemMenor = new ItemDoInventario("Machado", 20);
        ItemDoInventario itemMaior = new ItemDoInventario("Poção HP", 20);
        
        Orc umOrc = new Orc("orc");
        
        umOrc.adicionarItem(itemMenor);
        umOrc.adicionarItem(itemMaior);
        
        ItemDoInventario esperado = itemMaior;
        
        assertEquals(esperado, umOrc.getItemComMaiorQuantidade());
    }
    
    @Test
    public void ordenarInventarioVazio(){
        Orc umOrc = new Orc("nome");
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> esperado = new ArrayList<>();
        
        assertEquals(esperado, umOrc.getItens());
    }
    
    @Test
    public void ordenarInventarioComUmItem(){
        ItemDoInventario adaga = new ItemDoInventario("Adaga" , 20);
        Orc umOrc = new Orc("nome");
        umOrc.adicionarItem(adaga);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> esperado = new ArrayList<>();
        esperado.add(adaga);
        ArrayList<ItemDoInventario> resultado = new ArrayList<>();
        
        for(int i=0; i < umOrc.getContarItensDoInventario(); i++){
            resultado.add(umOrc.getItem(i));
        }
        
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void ordenarInventarioComDoisItens(){
        ItemDoInventario adaga = new ItemDoInventario("Adaga" , 20);
        ItemDoInventario escudo = new ItemDoInventario("Escudo" , 10);
        Orc umOrc = new Orc("nome");
        umOrc.adicionarItem(adaga);
        umOrc.adicionarItem(escudo);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> esperado = new ArrayList<>();
        esperado.add(escudo);
        esperado.add(adaga);
        ArrayList<ItemDoInventario> resultado = new ArrayList<>();
        
        for(int i=0; i < umOrc.getContarItensDoInventario(); i++){
            resultado.add(umOrc.getItem(i));
        }
        
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void ordenarInventarioComTresItensSendoUmNegativo(){
        ItemDoInventario adaga = new ItemDoInventario("Adaga" , 20);
        ItemDoInventario escudo = new ItemDoInventario("Escudo" , 10);
        ItemDoInventario flecha = new ItemDoInventario("Flecha" , -10);
        Orc umOrc = new Orc("nome");
        umOrc.adicionarItem(adaga);
        umOrc.adicionarItem(escudo);
        umOrc.adicionarItem(flecha);
        
        umOrc.ordenarItens();
        
        ArrayList<ItemDoInventario> esperado = new ArrayList<>();
        esperado.add(flecha);
        esperado.add(escudo);
        esperado.add(adaga);
        ArrayList<ItemDoInventario> resultado = new ArrayList<>();
        
        for(int i=0; i < umOrc.getContarItensDoInventario(); i++){
            resultado.add(umOrc.getItem(i));
        }
        
        assertEquals(esperado, resultado);
    }
}