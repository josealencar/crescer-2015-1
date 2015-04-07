
/**
 * Write a description of class ItemDoInventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemDoInventario
{
    // instance variables - replace the example below with your own
    private String descricao;
    private int quantidade;

    /**
     * Constructor for objects of class ItemDoInventario
     * 
     * @param descricao é a descricao do item
     * @param quantidade é a quantidade do item descrito
     */
    public ItemDoInventario(String descricao, int quantidade)
    {
        // initialise instance variables
        this.descricao=descricao;
        this.quantidade=quantidade;
    }
    
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade=quantidade;
    }

    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}
