package uni1a;

public class Temporada {
    private int numero;
    private int episodios;

    public Temporada(int numero, int episodios){
        this.numero = numero;
        this.episodios = episodios;
    }

    public int getEpisodios() {
        return episodios;
    }

    public int getNumero() {
        return numero;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}