package Modelo;

// Clase abstracta que sirve como base para películas y series de TV.
public abstract class ContenidoAudiovisual {
    // Atributos básicos comunes a películas y series.
    public int id;
    public String titulo;
    public int duracionEnMinutos;
    public String genero;

    // Constructor para inicializar los atributos.
    public ContenidoAudiovisual(int id, String titulo, int duracionEnMinutos, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getGenero() {
        return genero;
    }

    // Método abstracto que las subclases deben implementar para convertir un objeto en CSV.
    public abstract String toCSV();

    // Método para leer datos desde CSV. Será implementado en las subclases.
    public static ContenidoAudiovisual fromCSV(String csvLine) {
        return null; // Implementación en subclases.
    }
}