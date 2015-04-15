
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{
    // instance variables - replace the example below with your own
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    @Override
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia+=3;
        vida *= 0.95;
        if (vida < 1) vida=0;
        super.atualizaEstatusSeMerecerMorrer();
        umOrc.recebeAtaque();
    }
}
