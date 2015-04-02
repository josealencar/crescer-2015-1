
/**
 * Write a description of class Orcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orcs
{
    // instance variables - replace the example below with your own
    private static int vida=110;
    private String nome;

    /**
     * Constructor for objects of class Orcs
     */
    public Orcs(String nome)
    {
        // initialise instance variables
        this.nome=nome;
    }

    /**
     * Método "morrer"
     */
    public static void levarFlechada()
    {
        if(vida>0)
        {
            vida=vida-10;
        }
    }
    
    public int getVida(){
        return this.vida;
    }
}
