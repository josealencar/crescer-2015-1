import java.util.*;

/**
 * Classe base para todos Personagem do jogo.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem
{
    // instance variables - replace the example below with your own
    protected Status status = Status.VIVO;
    protected double vida;
    protected int experiencia;
    protected String nome;
    
    protected ArrayList<ItemDoInventario> inventario=new ArrayList<ItemDoInventario>();
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void adicionarItem(ItemDoInventario item){
        inventario.add(item);
    }
    
    public void perderItem(ItemDoInventario item){
        for(int i = 0; i < inventario.size(); i++){
            ItemDoInventario umItem = inventario.get(i);
            if(umItem.getDescricao().equals(item.getDescricao())){
                inventario.remove(umItem);
                break;
            }
        }
    }
    
    public int getContarItensDoInventario(){
        int contador = inventario.size();
        return contador;
    }
    
    public ItemDoInventario getItem(int i){
        ItemDoInventario umItem = inventario.get(i);
        return umItem;
    }
    
    public String imprimirItens(){
        String imprimir = inventario.size() > 0 ? "" : null;
        for(int i = 0; i < inventario.size() ; i++){
            ItemDoInventario umItem= inventario.get(i);
            imprimir += umItem.getDescricao();
            if(i != (inventario.size()-1)){
                imprimir += ",";
            }
        }
        return imprimir;
    }
    
    public ItemDoInventario getItemComMaiorQuantidade(){
        ItemDoInventario item = this.inventario.size() > 0 ?  this.inventario.get(0) : null;
        //int posicao = this.inventario.size() > 0 ? item.getQuantidade() : null;
        
        if(this.inventario.size() > 1){
            for(int i = 1; i < this.inventario.size(); i++){
                ItemDoInventario itemParaComparar = this.inventario.get(i);
                
                item = item.getQuantidade() > itemParaComparar.getQuantidade() ? item : itemParaComparar;
            }
        }
        return item;
    }
    
    public void ordenarItens(){
        boolean temItens = this.inventario.size() > 0;
        boolean temMaisDeUmItem = this.inventario.size() > 1;
        
        if(temItens && temMaisDeUmItem){
            ArrayList<ItemDoInventario> ordenado = new ArrayList<>();
            ItemDoInventario auxiliar;
            
            do {
                int i = 0;
                auxiliar = this.inventario.get(i);
                for(int o = i+1; o < this.inventario.size(); o++){
                    boolean itemEMenor = this.inventario.get(i).getQuantidade() > 
                        this.inventario.get(o).getQuantidade();
                    if(itemEMenor){
                        auxiliar = this.inventario.get(o);
                    }
                }
                ordenado.add(auxiliar);
                this.inventario.remove(auxiliar);
            } while(this.inventario.size() > 0);
            this.inventario = ordenado;
        }
    }
    
    public ArrayList<ItemDoInventario> getItens(){
        return this.inventario;
    }
}
