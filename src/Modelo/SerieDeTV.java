package Modelo;

import java.util.ArrayList;
import java.util.List;

// Representa una serie de TV que contiene temporadas.
public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas; // Lista de temporadas de la serie.

    // Constructor
    public SerieDeTV(int id, String titulo, int duracionEnMinutos, String genero) {
        super(id, titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    // Método para agregar una temporada a la serie.
    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    // Getters y setters
    public List<String> getTemporadas() {
        // Convierte la lista de temporadas en una lista de cadenas
        return temporadas.stream()
                .map(temporada -> "Temporada " + temporada.getNumero() + ": " + temporada.getCantidadEpisodios() + " episodios")
                .toList();
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    // Representación en texto de la serie.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(getId()).append("\n");
        sb.append("Título: ").append(getTitulo()).append("\n");
        sb.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        sb.append("Género: ").append(getGenero()).append("\n");
        sb.append("Temporadas:\n");

        for (Temporada temporada : temporadas) {
            sb.append("  - ").append(temporada.toString()).append("\n");
        }

        return sb.toString();
    }

    // Método estático para crear una serie desde una línea CSV.
    public static SerieDeTV fromCSV(String csvLine) {
        String[] parts = csvLine.split(","); // Divide la línea CSV en partes.
        SerieDeTV serie = new SerieDeTV(
                Integer.parseInt(parts[0]), // ID
                parts[1],                   // Título
                Integer.parseInt(parts[2]), // Duración en minutos
                parts[3]                    // Género
        );

        // Procesar temporadas si están presentes.
        if (parts.length > 4 && !parts[4].isEmpty()) {
            String[] temporadasData = parts[4].split("\\|");
            for (String temporadaData : temporadasData) {
                String[] tempParts = temporadaData.split("-"); // Divide "numeroTemporada-numeroEpisodios".
                int numeroTemporada = Integer.parseInt(tempParts[0]); // Número de la temporada.
                int numeroEpisodios = Integer.parseInt(tempParts[1]); // Número de episodios.
                serie.agregarTemporada(new Temporada(numeroTemporada, numeroEpisodios));
            }
        }
        return serie;
    }

    // Método para convertir la serie en formato CSV para guardar en archivo.
    @Override
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(",");
        sb.append(getTitulo()).append(",");
        sb.append(getDuracionEnMinutos()).append(",");
        sb.append(getGenero()).append(",");

        for (int i = 0; i < temporadas.size(); i++) {
            sb.append(temporadas.get(i).getCantidadEpisodios());
            if (i < temporadas.size() - 1) {
                sb.append("|");
            }
        }

        return sb.toString();
    }
}