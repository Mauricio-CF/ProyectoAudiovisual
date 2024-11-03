package uni1a;

import java.util.List;

public class NoticiasDeTV extends  ContenidoAudiovisual{

    private String canal;
    private List<Presentador> presentadores;

    public NoticiasDeTV(String titulo, int duracionEnMinutos, String genero, String canal, List<Presentador> presentadores) {
        super(titulo, duracionEnMinutos, genero);
        this.canal = canal;
        this.presentadores = presentadores;
    }

    public void agregarPresentador(Presentador presentado){
        presentadores.add(presentado);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de las Noticias:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Canal: " + canal);
        System.out.println("Presentadores: ");
        for (Presentador present: presentadores) {
            System.out.println("- " + present.getNombre());
        }
        System.out.println();
    }
}
