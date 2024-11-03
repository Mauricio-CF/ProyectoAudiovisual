/**
 * Class SerieDeTV
 */
package uni1a;


import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private List<Temporada> listaTemporadas; // Agregación con Temporada

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas, List<Temporada> listaTemporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = listaTemporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporadas(Temporada tempo){
        listaTemporadas.add(tempo);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de serie de tv:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println("Episodios por temporada");
        for (Temporada temp: listaTemporadas){
            System.out.println("Temporada: " + temp.getNumero() + " Episidios: " + temp.getEpisodios());
        }
        System.out.println();
    }
}