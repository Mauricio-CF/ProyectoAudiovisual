package Test;

import Modelo.Actor;
import Modelo.NoticiasDeTV;
import Modelo.Pelicula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoticiasDeTVTest {

    @Test
    void testCrearPelicula() {
        NoticiasDeTV noticiasDeTV = new NoticiasDeTV(1, "Noticias", 60, "News", "Univision");
        assertEquals(1, noticiasDeTV.getId());
        assertEquals("Noticias", noticiasDeTV.getTitulo());
        assertEquals(60, noticiasDeTV.getDuracionEnMinutos());
        assertEquals("News", noticiasDeTV.getGenero());
        assertEquals("Univision", noticiasDeTV.getCanal());
    }

    @Test
    void testAgregarActor() {
        Pelicula pelicula = new Pelicula(2, "Interstellar", 169, "Sci-Fi", "Paramount Pictures");
        Actor actor = new Actor("Matthew McConaughey");
        pelicula.agregarActor(actor);
        assertTrue(pelicula.getActores().contains("Matthew McConaughey"));
    }
}
