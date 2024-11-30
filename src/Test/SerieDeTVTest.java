package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import Modelo.*;

class SerieDeTVTest {

    @Test
    void testCrearSerieDeTV() {
        SerieDeTV serie = new SerieDeTV(1, "Breaking Bad", 45, "Drama");
        assertEquals(1, serie.getId());
        assertEquals("Breaking Bad", serie.getTitulo());
        assertEquals(45, serie.getDuracionEnMinutos());
        assertEquals("Drama", serie.getGenero());
    }

    @Test
    void testAgregarTemporada() {
        SerieDeTV serie = new SerieDeTV(1, "Stranger Things", 50, "Sci-Fi");
        Temporada temporada = new Temporada(1, 8);
        serie.agregarTemporada(temporada);

        List<String> temporadas = serie.getTemporadas();
        assertEquals(1, temporadas.size());
        assertTrue(temporadas.contains("Temporada 1: 8 episodios"));
    }
}
