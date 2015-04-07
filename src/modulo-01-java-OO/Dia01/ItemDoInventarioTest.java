import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemDoInventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemDoInventarioTest
{
    @Test
    public void criaItemDoInventarioComNomeEQuantidade(){
        //Arrange
        String descricao="Martelo";
        int quantidade=5;
        ItemDoInventario umItem;
        //Act
        umItem = new ItemDoInventario(descricao, quantidade);
        //Assert
        String nomeEsperado = descricao;
        int quantidadeEsperada = quantidade;
        
        assertEquals(nomeEsperado, umItem.getDescricao());
        assertEquals(quantidadeEsperada, umItem.getQuantidade());
    }
    
    @Test
    public void criaItemDoInventarioComNomeEQuantidadeNegativa(){
        //Arrange
        String descricao=null;
        int quantidade=-5;
        ItemDoInventario umItem;
        //Act
        umItem = new ItemDoInventario(descricao, quantidade);
        //Assert
        String nomeEsperado = descricao;
        int quantidadeEsperada = quantidade;
        
        assertEquals(nomeEsperado, umItem.getDescricao());
        assertEquals(quantidadeEsperada, umItem.getQuantidade());
    }
}
