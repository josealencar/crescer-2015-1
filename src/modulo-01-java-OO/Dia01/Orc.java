import java.util.*;

/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private String nome;
    private int experiencia = 0;
    private Status status;

    /**
     * Array de ItensDoInventario
     */
    
    public ArrayList<ItemDoInventario> inventario=new ArrayList<ItemDoInventario>();
    
    {
        //vida = 110;
        this.status=Status.VIVO;
    }
    
    /**
     * Construtor para objetos da classe Orc
     **/
    public Orc(String nome)
    {
        this.nome=nome;
        //vida = 110;
    }
    
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        if(this.vida<=0){
            this.status=Status.MORTO;
        }else{
            this.status=Status.VIVO;
            double numero=gerarNumero();
            if(numero<0){
                this.experiencia +=2;
            }else if(numero>100){
                this.vida -= 10;
            }
        }
        if(this.vida==0){this.status=Status.MORTO;}
        // this.vida = this.vida - 10;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Método setExperiencia criado para teste do gerarNumero()
     */
    public void setExperiencia(int exp){
        this.experiencia=exp;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
    
    private double gerarNumero(){
        double numero=0.0;
        numero = this.nome.length() > 5 ? numero + 65 : numero - 60;
        numero = this.vida > 30 && this.vida < 60 ? numero*2: this.vida < 20 ? numero*3 : numero*1;
        numero = this.status.equals(Status.FUGINDO.toString()) ? numero/2 : 
            this.status.equals(Status.DORMINDO.toString()) ||
            this.status.equals(Status.CACANDO.toString()) ?
            numero++ : numero*1;
        numero = this.experiencia%2 == 0 && this.experiencia!=0 ? Math.pow(numero, 3) :
            this.experiencia > 2 && this.experiencia%2 != 0? Math.pow(numero, 2) : numero;
        return numero;
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
}
