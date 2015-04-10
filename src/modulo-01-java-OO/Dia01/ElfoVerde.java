
/**
 * Write a description of class ElfoVerde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
    // instance variables - replace the example below with your own
    private String cor = "VERDE";
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){
        super(nome, flechas);
    }
    
    public String getCor(){
        return this.cor;
    }
    
    @Override
    public void adicionarItem(ItemDoInventario item){
        if(item.getDescricao().equals("Espada de aço valiriano") || 
                item.getDescricao().equals("Arco e Flecha de vidro"))
        {
            inventario.add(item);
        }
    }
}
