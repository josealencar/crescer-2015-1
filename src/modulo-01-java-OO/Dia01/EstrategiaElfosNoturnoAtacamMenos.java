import java.util.*;
/**
 * Write a description of class EstrategiaElfosNoturnoAtacamMenos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaElfosNoturnoAtacamMenos implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        int totalAtaques = elfos.size() * orcs.size();
        int ataquesNoturnos = (int)(totalAtaques * 0.3);
        
        for (Elfo elfo : elfos){
            for (Orc orc : orcs){
                if(elfo instanceof ElfoNoturno){
                    if(ataquesNoturnos > 0){
                        elfo.atirarFlecha(orc);
                        ataquesNoturnos --;
                    }
                }else{
                    elfo.atirarFlecha(orc);
                }
            }
        }
    }
}
