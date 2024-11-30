package Modelo;

import java.util.ArrayList;
import java.util.List;

public class NoticiasDeTV extends ContenidoAudiovisual{
    public String canal;
    private List<Presentador>presentadores;

    public NoticiasDeTV(int id, String titulo, int duracionEnMinutos, String genero, String canal) {
        super(id, titulo, duracionEnMinutos, genero);
        this.canal = canal;
        this.presentadores = new ArrayList<>();
    }

    public void agregarPresentadores(Presentador presentador){
        presentadores.add(presentador);
    }

    public String getCanal() {
        return canal;
    }

    public List<Presentador> getPresentadores() {
        return presentadores;
    }

    @Override
    public String toCSV(){
        String presentadoresNombres = String.join("|", presentadores.stream().map(Presentador::getNombre).toList());
        return id + "," + titulo + "," + duracionEnMinutos + "," + genero + "," + canal + "," +presentadoresNombres;
    }

    public static NoticiasDeTV fromCSV(String csvLine){
        String[] parts = csvLine.split(",");
        NoticiasDeTV noticiasDeTV = new NoticiasDeTV(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);

        String[] presentadoresNombres = parts[5].split("\\|");
        for (String nombre : presentadoresNombres){
            noticiasDeTV.agregarPresentadores(new Presentador(nombre));
        }
        return noticiasDeTV;
    }

    public List<String> getNombre(){
        return presentadores.stream().map(Presentador::getNombre).toList();
    }
}
