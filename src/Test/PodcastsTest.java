package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.*;

import java.time.LocalDate;

class PodcastsTest {

    @Test
    void testCrearPodcast() {
        Podcasts podcast = new Podcasts(1, "Aprende Java", 30, "Educación", "Un curso de Java básico.", "2024-01-15");
        assertEquals(1, podcast.getId());
        assertEquals("Aprende Java", podcast.getTitulo());
        assertEquals(30, podcast.getDuracionEnMinutos());
        assertEquals("Educación", podcast.getGenero());
        assertEquals("Un curso de Java básico.", podcast.getDescripcion());
        assertEquals("2024-01-15", podcast.getFechaLanzamiento());
    }

    @Test
    void testAgregarHost() {
        Podcasts podcast = new Podcasts(2, "Programadores al Rescate", 45, "Tecnología", "Discusión sobre desarrollo de software.", "10-02-2024");
        Host host = new Host("Carlos García");
        podcast.agregarHost(host);
        assertTrue(podcast.getHosts().contains("Carlos García"));
    }
}