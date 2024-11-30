package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Podcasts extends ContenidoAudiovisual {
    public String descripcion; // Descripción del podcast.
    public String fechaLanzamiento; // Fecha de lanzamiento del podcast.
    private List<Host> hosts; // Lista de hosts que participan.

    // Constructor que inicializa los atributos del podcast.
    public Podcasts(int id, String titulo, int duracionEnMinutos, String genero, String descripcion, String fechaLanzamiento) {
        super(id, titulo, duracionEnMinutos, genero); // Llama al constructor de la clase base.
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.hosts = new ArrayList<>(); // Inicializa la lista de hosts.
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    // Método para agregar un host a la lista.
    public void agregarHost(Host host) {
        hosts.add(host);
    }

    // Convierte el podcast a formato CSV. Incluye todos los hosts en una cadena separada por "|".
    @Override
    public String toCSV() {
        String hostsNombres = String.join("|", hosts.stream().map(Host::getNombre).toList());
        return id + "," + titulo + "," + duracionEnMinutos + "," + genero + "," + descripcion + "," + fechaLanzamiento + "," + hostsNombres;
    }

    // Crea un objeto Podcasts a partir de una línea CSV.
    public static Podcasts fromCSV(String csvLine) {
        String[] parts = csvLine.split(","); // Divide la línea CSV en partes.
        Podcasts podcast = new Podcasts(
                Integer.parseInt(parts[0]), // ID
                parts[1],                   // Título
                Integer.parseInt(parts[2]), // Duración en minutos
                parts[3],                   // Género
                parts[4],                   // Descripción
                parts[5]                    // Fecha de lanzamiento
        );
        // Agrega hosts al podcast.
//        if (parts.length > 6) {
            String[] hostNombres = parts[6].split("\\|");
            for (String nombre : hostNombres) {
                podcast.agregarHost(new Host(nombre.trim()));
            }
        //}
        return podcast;
    }

    // Devuelve los nombres de los hosts en una lista.
    public List<String> getHosts() {
        return hosts.stream().map(Host::getNombre).toList();
    }
}
