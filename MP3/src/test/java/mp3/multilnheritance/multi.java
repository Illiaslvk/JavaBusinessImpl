package mp3.multilnheritance;

import org.junit.Test;

import static org.junit.Assert.*;


public class multi {

    @Test
    public void test() {
        Animal animal = new Animal(10.5, "Crocodile");
        Farmer farmer = new Farmer("John", 80.0, "Cow", 10.0);

        assertEquals(10.5, animal.getWeight(), 0.0);
        assertEquals("Crocodile", animal.getAnimalName());

        assertEquals("John", farmer.getName());
        assertEquals(80.0, farmer.getWeight(), 0.0);
        assertEquals("Cow", farmer.getAnimalName());
        assertEquals(10.0, farmer.getSurface(), 0.0);

        farmer.setName("Michael");
        farmer.setSurface(15.0);
        assertEquals("Michael", farmer.getName());
        assertEquals(15.0, farmer.getSurface(), 0.0);

        IPlot plot = new Plot(100.0);
        assertEquals(100.0, plot.getSurface(), 0.0);

        plot.setSurface(150.0);
        assertEquals(150.0, plot.getSurface(), 0.0);


    }
}
