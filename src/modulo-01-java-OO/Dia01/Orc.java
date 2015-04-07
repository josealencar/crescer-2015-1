/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private String status, nome;
    private int experiencia = 0;

    {
        //vida = 110;
        this.status=Status.VIVO.toString();
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
            this.status=Status.MORTO.toString();
        }else{
            this.status=Status.VIVO.toString();
            this.vida -= 10;
        }
        // this.vida = this.vida - 10;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public String getStatus(){
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
}
