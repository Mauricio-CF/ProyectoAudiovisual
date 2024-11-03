package uni1a;

import java.util.List;

public class Podcasts extends ContenidoAudiovisual{

    private String descripcion;
    private String fechaLanzamiento;
    private List<Host> host;

    public Podcasts(String titulo, int duracionEnMinutos, String genero, String descripcion, String fechaLanzamiento, List<Host> host) {
        super(titulo, duracionEnMinutos, genero);
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.host = host;
    }

    public void agregarHost(Host hos){
        host.add(hos);
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.descripcion);
        System.out.println("Fecha Lanzamiento: " + this.fechaLanzamiento);
        System.out.println("Host: ");
        for (Host hos: host){
            System.out.println("- " + hos.getNombre());
        }
        System.out.println();
    }
}
