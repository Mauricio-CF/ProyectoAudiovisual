package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Podcasts extends ContenidoAudiovisual {
    public String descripcion;
    public String fechaLanzamiento; 
    private List<Host> hosts;

    
    public Podcasts(int id, String titulo, int duracionEnMinutos, String genero, String descripcion, String fechaLanzamiento) {
        super(id, titulo, duracionEnMinutos, genero); 
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.hosts = new ArrayList<>(); 
        }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    
    public void agregarHost(Host host) {
        hosts.add(host);
    }

    
    @Override
    public String toCSV() {
        String hostsNombres = String.join("|", hosts.stream().map(Host::getNombre).toList());
        return id + "," + titulo + "," + duracionEnMinutos + "," + genero + "," + descripcion + "," + fechaLanzamiento + "," + hostsNombres;
    }

   
    public static Podcasts fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        Podcasts podcast = new Podcasts(
                Integer.parseInt(parts[0]), 
                parts[1],                   
                Integer.parseInt(parts[2]), 
                parts[3],                   
                parts[4],                   
                parts[5]                    
        );


            String[] hostNombres = parts[6].split("\\|");
            for (String nombre : hostNombres) {
                podcast.agregarHost(new Host(nombre.trim()));
            }

        return podcast;
    }

        public List<String> getHosts() {
        return hosts.stream().map(Host::getNombre).toList();
    }
}
