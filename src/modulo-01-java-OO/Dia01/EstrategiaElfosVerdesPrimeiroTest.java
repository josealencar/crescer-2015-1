
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaElfosVerdesPrimeiroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaElfosVerdesPrimeiroTest
{
    @Test
    public void estrategiaElfosVerdesAtacamPrimeiro(){
        // Arrange
        Elfo elfo1 = new ElfoVerde("Green 1");
        Elfo elfo2 = new ElfoNoturno("Nigth 1");
        Elfo elfo3 = new ElfoVerde("Green 2");
        Elfo elfo4 = new ElfoNoturno("Nigth 2");
        
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.add(elfo2);
        elfos.add(elfo4);
        elfos.add(elfo1);
        elfos.add(elfo3);
        
        ArrayList<Orc> orcs = new ArrayList<>();
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        orcs.add(new Orc());
        // Act
        EstrategiaDeAtaque ataque = new EstrategiaElfosVerdesPrimeiro();
        ataque.atacarOrcs(elfos, orcs);
        // Assert
        ArrayList<Elfo> esperado = new ArrayList<>();
        esperado.add(elfo1);
        esperado.add(elfo3);
        esperado.add(elfo2);
        esperado.add(elfo4);
        
        assertEquals(esperado, elfos);
    }
}
