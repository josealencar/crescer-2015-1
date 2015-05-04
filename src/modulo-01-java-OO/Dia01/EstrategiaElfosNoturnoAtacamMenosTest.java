
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaElfosNoturnoAtacamMenosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaElfosNoturnoAtacamMenosTest
{
    @Test
    public void estrategiaElfosNoturnosAtacamMenos(){
        // Arrange
        Elfo elfo1 = new ElfoVerde("Green 1");
        Elfo elfo2 = new ElfoNoturno("Nigth 1");
        Elfo elfo3 = new ElfoVerde("Green 2");
        
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.add(elfo1);
        elfos.add(elfo2);
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
        EstrategiaDeAtaque ataque = new EstrategiaElfosNoturnoAtacamMenos();
        ataque.atacarOrcs(elfos, orcs);
        // Assert
        int flechasEsperadas = 33;
        
        assertEquals(flechasEsperadas, elfo2.getFlechas());
    }
}
