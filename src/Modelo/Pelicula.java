package Modelo;

import java.util.ArrayList;
import java.util.List;

// Representa una película con atributos adicionales y una lista de actores.
public class Pelicula extends ContenidoAudiovisual {
    public String estudio; // Estudio responsable de la película.
    private List<Actor> actores; // Lista de actores que participan.

    // Constructor que inicializa los atributos de la película.
    public Pelicula(int id, String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(id, titulo, duracionEnMinutos, genero); // Llama al constructor de la clase base.
        this.estudio = estudio;
        this.actores = new ArrayList<>(); // Inicializa la lista de actores.
    }

    public String getEstudio() {
        return estudio;
    }

    // Método para agregar un actor a la lista.
    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    // Convierte la película a formato CSV. Incluye todos los actores en una cadena separada por "|".
    @Override
    public String toCSV() {
        String actoresNombres = String.join("|", actores.stream().map(Actor::getNombre).toList());
        return id + "," + titulo + "," + duracionEnMinutos + "," + genero + "," + estudio + "," + actoresNombres;
    }

    // Crea un objeto Pelicula a partir de una línea CSV.
    public static Pelicula fromCSV(String csvLine) {
        String[] parts = csvLine.split(","); // Divide la línea CSV en partes.
        Pelicula pelicula = new Pelicula(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
        // Agrega actores a la película.
        String[] actorNombres = parts[5].split("\\|");
        for (String nombre : actorNombres) {
            pelicula.agregarActor(new Actor(nombre));
        }
        return pelicula;
    }

    public List<String> getActores() {
        return actores.stream().map(Actor::getNombre).toList();
    }
}