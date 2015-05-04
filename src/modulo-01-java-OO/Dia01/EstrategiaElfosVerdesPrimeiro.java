import java.util.*;
/**
 * Write a description of class EstrategiaElfosVerdesPrimeiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaElfosVerdesPrimeiro implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        // Ordena elfos
        int totalElfos = elfos.size();
        for(int i = 0; i < (totalElfos - 1); i ++){
            for(int o = (i + 1); o < totalElfos; o ++){
                Elfo atual = elfos.get(i);
                Elfo proximo = elfos.get(o);
                if(atual instanceof ElfoNoturno && proximo instanceof ElfoVerde){
                    elfos.set(i, proximo);
                    elfos.set(o, atual);
                }
            }
        }
        // Atacar
        for (Elfo elfo : elfos){
            for (Orc orc : orcs){
                elfo.atirarFlecha(orc);
            }
        }
    }
}
