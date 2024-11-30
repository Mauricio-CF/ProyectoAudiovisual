package Test;
import Modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {

    @Test
    void testCrearPelicula() {
        Pelicula pelicula = new Pelicula(1, "Inception", 148, "Sci-Fi", "Warner Bros");
        assertEquals(1, pelicula.getId());
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(148, pelicula.getDuracionEnMinutos());
        assertEquals("Sci-Fi", pelicula.getGenero());
        assertEquals("Warner Bros", pelicula.getEstudio());
    }

    @Test
    void testAgregarActor() {
        Pelicula pelicula = new Pelicula(2, "Interstellar", 169, "Sci-Fi", "Paramount Pictures");
        Actor actor = new Actor("Matthew McConaughey");
        pelicula.agregarActor(actor);
        assertTrue(pelicula.getActores().contains("Matthew McConaughey"));
    }
}