package Modelo;

public class Temporada {
    private int numero; 
    private int cantidadEpisodios; 

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