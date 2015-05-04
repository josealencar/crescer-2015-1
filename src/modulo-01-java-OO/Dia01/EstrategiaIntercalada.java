import java.util.*;
/**
 * Write a description of class EstrategiaIntercalada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaIntercalada implements EstrategiaDeAtaque
{
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        int contadorVerde = 0;
        int contadorNoturno = 0;
        
        for (Elfo elfo : elfos){
            if (elfo instanceof ElfoVerde){
                contadorVerde ++;
            } else{
                contadorNoturno ++;
            }
        }
        
        if (contadorVerde == contadorNoturno){
            ArrayList<Elfo> aux = new ArrayList<>();
            int contador = 0;
            int maximo = elfos.size();
            for (int i = 0; i < maximo; i ++){
                if( (contador%2) == 0){
                    for (Elfo elfo : elfos){
                        if (elfo instanceof ElfoNoturno){
                            aux.add(elfo);
                            elfos.remove(elfo);
                            contador ++;
                            break;
                        }
                    }
                } else{
                    for (Elfo elfo : elfos){
                        if (elfo instanceof ElfoVerde){
                            aux.add(elfo);
                            elfos.remove(elfo);
                            contador ++;
                            break;
                        }
                    }
                }
            }
            
            while (aux.size() > 0){
                Elfo umElfo = aux.get(0);
                elfos.add(umElfo);
                aux.remove(umElfo);
            }
            
            for (Elfo elfo : elfos){
                for (Orc orc : orcs){
                    elfo.atirarFlecha(orc);
                }
            }
        } else{
            System.out.println("Não é possível utilizar esta estratégia pois não temos alistados"
                + " 50% de elfos verdes e 50% de elfos noturnos.");
        }
    }
}
