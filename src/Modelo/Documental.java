package Modelo;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class Documental extends ContenidoAudiovisual {

    public String tema;
    private List<Investigador>investigadores;

    public Documental(int id, String titulo, int duracionEnMinutos, String genero, String tema) {
        super(id, titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void agregarInvestigador(Investigador investigador) {
        investigadores.add(investigador); // Asegúrate de que este paso esté presente.
    }

    @Override
    public String toCSV(){
        String investigadoresNombres = String.join("|", investigadores.stream().map(Investigador::getNombre).toList());
        return id + "," + titulo + "," + duracionEnMinutos + "," + genero + "," + tema + "," +investigadoresNombres;
    }

    public static Documental fromCSV(String csvLine){
        String[] parts = csvLine.split(",");
        Documental documental = new Documental(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);

        String[] investigadorNombres = parts[5].split("\\|");
        for (String nombre : investigadorNombres){
            documental.agregarInvestigador(new Investigador(nombre));
        }
        return documental;
    }

    public List<String> getNombre(){
        return investigadores.stream().map(Investigador::getNombre).toList();
    }

}