/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private String status;

    {
        //vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
    public Orc()
    {
        //vida = 110;
    }
    **/
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        this.vida<=0 ? status=Statid.MORTO: Status.VIVO;
        this.vida -= 10;
        // this.vida = this.vida - 10;
    }
    
    public int getVida() {
        return this.vida;
    }
}
