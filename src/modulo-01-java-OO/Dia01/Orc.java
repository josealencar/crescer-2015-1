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
            double numero=gerarNumero();
            if(numero<0){
                this.experiencia +=2;
            }else if(numero>100){
                this.vida -= 10;
            }
        }
        // this.vida = this.vida - 10;
    }
    
    public void setStatus(String status){
        this.status = status.toUpperCase();
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
}
