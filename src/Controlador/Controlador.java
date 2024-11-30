package Controlador;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.*;

import javax.swing.text.Document;

public class Controlador {
    private List<ContenidoAudiovisual> contenidos; // Lista de contenidos audiovisuales.

    public Controlador() {
        this.contenidos = new ArrayList<>();
    }

    // Método para verificar si ya existe una película con el mismo ID.
    private boolean existePeliculaConId(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido instanceof Pelicula)
                .anyMatch(contenido -> contenido.id == id);
    }

    // Método para verificar si ya existe una serie con el mismo ID.
    private boolean existeSerieConId(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido instanceof SerieDeTV)
                .anyMatch(contenido -> contenido.id == id);
    }

    private boolean existeDocumentalConId(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido instanceof Documental)
                .anyMatch(contenido -> contenido.id == id);
    }

    private boolean existeNoticiasDeTVConId(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido instanceof NoticiasDeTV)
                .anyMatch(contenido -> contenido.id == id);
    }

    private boolean existePodcastsConId(int id) {
        return contenidos.stream()
                .filter(contenido -> contenido instanceof Podcasts)
                .anyMatch(contenido -> contenido.id == id);
    }

    // Carga datos desde un archivo CSV, permitiendo filtrar por tipo (Pelicula o Serie).
    public void cargarDesdeCSV(String rutaArchivo, String tipo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                ContenidoAudiovisual nuevoContenido = null;

                 // Crea un objeto según el tipo especificado.
                if (tipo.equals("Pelicula")) {
                    nuevoContenido = Pelicula.fromCSV(linea);
                    if (nuevoContenido != null && existePeliculaConId(nuevoContenido.id)) {
                        System.out.println("Advertencia: Película con ID " + nuevoContenido.id + " ya está registrada. Se omitirá.");
                        continue;
                    }
                }else if (tipo.equals("Serie")) {
                    nuevoContenido = SerieDeTV.fromCSV(linea);
                    if (nuevoContenido != null && existeSerieConId(nuevoContenido.id)) {
                        System.out.println("Advertencia: Serie con ID " + nuevoContenido.id + " ya está registrada. Se omitirá.");
                        continue;
                    }
                }else if (tipo.equals("Documental")) {
                    nuevoContenido = Documental.fromCSV(linea);
                    if (nuevoContenido != null && existeDocumentalConId(nuevoContenido.id)) {
                        System.out.println("Advertencia: Documental con ID " + nuevoContenido.id + " ya está registrada. Se omitirá.");
                        continue;
                    }
                }else if (tipo.equals("NoticiasDeTV")) {
                    nuevoContenido = NoticiasDeTV.fromCSV(linea);
                    if (nuevoContenido != null && existeNoticiasDeTVConId(nuevoContenido.id)) {
                        System.out.println("Advertencia: Noticias De TV con ID " + nuevoContenido.id + " ya está registrada. Se omitirá.");
                        continue;
                    }
                }else if (tipo.equals("Podcasts")) {
                    nuevoContenido = Podcasts.fromCSV(linea);
                    if (nuevoContenido != null && existePodcastsConId(nuevoContenido.id)) {
                        System.out.println("Advertencia: Podcasts con ID " + nuevoContenido.id + " ya está registrada. Se omitirá.");
                        continue;
                    }
                }

                        // Si pasa la validación, se agrega el contenido a la lista.
                        if (nuevoContenido != null) {
                            contenidos.add(nuevoContenido);
                            System.out.println(tipo + " con ID " + nuevoContenido.id + " cargada correctamente.");
                        }
                    }
                }
            }


            // Guarda los datos en un archivo CSV.
            public void guardarEnCSV (String rutaArchivo) throws IOException {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                    for (ContenidoAudiovisual contenido : contenidos) {
                        if (contenido instanceof Pelicula) {
                            bw.write("Pelicula," + contenido.toCSV() + "\n");
                        } else if (contenido instanceof SerieDeTV) {
                            bw.write("Serie," + contenido.toCSV() + "\n");
                        } else if (contenido instanceof Documental) {
                            bw.write("Documental," + contenido.toCSV() + "\n");
                        }else if (contenido instanceof NoticiasDeTV) {
                            bw.write("NoticiasDeTV," + contenido.toCSV() + "\n");
                        }else if (contenido instanceof Podcasts) {
                            bw.write("Podcasts," + contenido.toCSV() + "\n");
                        }
                    }
                }
            }

            // Retorna la lista de contenidos cargados.
            public List<ContenidoAudiovisual> getContenidos () {
                return contenidos;
            }
        }
