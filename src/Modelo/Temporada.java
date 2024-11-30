package Modelo;

public class Temporada {
    private int numero; // Número de la temporada.
    private int cantidadEpisodios; // Número de episodios.

    public Temporada(int numero, int cantidadEpisodios) {
        this.numero = numero;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getNumero() {
        return numero;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    @Override
    public String toString() {
        return "Temporada " + numero + " - Episodios: " + cantidadEpisodios;
    }
}