import java.util.*;

/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc extends Personagem
{
    private final int NUMERO_SORTE = 3481;
    
    {
        this.vida = 110;
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
    
    public Orc(){
        
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
    
    /**
     * Método setExperiencia criado para teste do gerarNumero()
     */
    public void setExperiencia(int exp){
        this.experiencia=exp;
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
        double numeroGerado = 0.0;
        
        // A. Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número. Caso contrário, subtraia 60.
        boolean possuiNome = this.nome != null && this.nome.length() > 5;
        
        if (possuiNome && this.nome.length() > 5) {
            numeroGerado += 65;
        } else {
            numeroGerado -= 60;
        }
        
        // B. Se o orc possuir vida entre 30 e 60, multiple o número por dois,
        // senão se a vida for menor que 20 multiplique por 3.
        boolean possuiVidaEntre30e60 = this.vida >= 30 && this.vida <= 60;
        
        if (possuiVidaEntre30e60) {
            numeroGerado *= 2;
        } else if (this.vida < 20) {
            numeroGerado *= 3;
        }
        
        // C. Se o orc estiver fugindo, divida o número por 2. Senão se o orc estiver caçando ou dormindo adicione 1 ao número.
        if (this.status == Status.FUGINDO) {
            numeroGerado /= 2;
        } else if (this.status == Status.CACANDO || this.status == Status.DORMINDO) { 
            numeroGerado += 1;
        }
        
        // D. Se a experiência do orc for par, eleve o número ao cubo. 
        // Se for ímpar e o orc tiver mais que 2 de experiência, eleve o número ao quadrado.
        boolean experienciaÉPar = this.experiencia % 2 == 0;
        if (experienciaÉPar) {
            numeroGerado = numeroGerado * numeroGerado * numeroGerado;
        } else if (this.experiencia > 2) {
            numeroGerado = numeroGerado * numeroGerado;
        }
                
        return numeroGerado;
    }
    
    public void tentarSorte(){
        double numeroGerado = gerarNumero();
        
        if (numeroGerado == NUMERO_SORTE) {
            for (ItemDoInventario item : this.inventario) {
                int novaQuantidadeItem = item.getQuantidade() + 1000;
                item.setQuantidade(novaQuantidadeItem);
            }
        }
    }
}
