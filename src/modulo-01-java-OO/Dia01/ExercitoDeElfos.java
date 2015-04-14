import java.util.*;

/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();// = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito(){
        return this.exercitoDeElfos;
    }
    
    public void alistarElfo(Elfo umElfo){
        boolean isGreen = umElfo instanceof ElfoVerde;
        boolean isNight = umElfo instanceof ElfoNoturno;
        
        if(isGreen || isNight){
            exercitoDeElfos.put(umElfo.getNome(), umElfo);
        }
    }
    
    public Elfo getElfoAlistado(String nome){
        return exercitoDeElfos.get(nome);
    }
}
