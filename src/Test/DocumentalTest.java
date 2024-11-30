package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Modelo.*;

class DocumentalTest {

    @Test
    void testCrearDocumental() {
        Documental documental = new Documental(1, "Planeta Tierra", 120, "Naturaleza", "Vida Marina");
        assertEquals(1, documental.getId());
        assertEquals("Planeta Tierra", documental.getTitulo());
        assertEquals(120, documental.getDuracionEnMinutos());
        assertEquals("Naturaleza", documental.getGenero());
        assertEquals("Vida Marina", documental.getTema());
    }

    @Test
    void testAgregarInvestigador() {
        Documental documental = new Documental(2, "El Universo", 90, "Ciencia", "Cosmología");
        Investigador investigador = new Investigador("Neil deGrasse Tyson");
        documental.agregarInvestigador(investigador);
        assertTrue(documental.getNombre().contains("Neil deGrasse Tyson"));
    }
}
