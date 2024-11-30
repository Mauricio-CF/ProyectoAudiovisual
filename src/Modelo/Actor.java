package Modelo;

// Representa un actor con un atributo "nombre".
public class Actor {
    private String nombre;

    // Constructor que inicializa el nombre del actor.
    public Actor(String nombre) {
        this.nombre = nombre;
    }

    // Retorna el nombre del actor.
    public String getNombre() {
        return nombre;
    }
}