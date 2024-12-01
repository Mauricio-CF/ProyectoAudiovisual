package Modelo;

import java.util.ArrayList;
import java.util.List;


public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas; 

    public SerieDeTV(int id, String titulo, int duracionEnMinutos, String genero) {
        super(id, titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    public List<String> getTemporadas() {
        return temporadas.stream()
                .map(temporada -> "Temporada " + temporada.getNumero() + ": " + temporada.getCantidadEpisodios() + " episodios")
                .toList();
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

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

    public static SerieDeTV fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        SerieDeTV serie = new SerieDeTV(
                Integer.parseInt(parts[0]), 
                parts[1],                   
                Integer.parseInt(parts[2]), 
                parts[3]                    
        );

        
        if (parts.length > 4 && !parts[4].isEmpty()) {
            String[] temporadasData = parts[4].split("\\|");
            for (String temporadaData : temporadasData) {
                String[] tempParts = temporadaData.split("-"); 
                int numeroTemporada = Integer.parseInt(tempParts[0]); 
                int numeroEpisodios = Integer.parseInt(tempParts[1]); 
                serie.agregarTemporada(new Temporada(numeroTemporada, numeroEpisodios));
            }
        }
        return serie;
    }

    
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