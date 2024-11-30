package Vista;

import java.io.IOException;
import Modelo.*;
import Controlador.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);
        String rutaPeliculas = "src/Source/Entrada/Peliculas.csv";
        String rutaSeries = "src/Source/Entrada/Series.csv";
        String rutaDocumentales="src/Source/Entrada/Documentales.csv";
        String rutaNoticiasDeTV="src/Source/Entrada/NoticiasDeTV.csv";
        String rutaPodcasts="src/Source/Entrada/Podcasts.csv";
        String rutaRespaldo="src/Source/Salida/Respaldo.csv";


        while (true) {
            // Mostrar el menú al usuario.
            System.out.println("\n*** Menú Principal ***");
            System.out.println("1. Cargar información de películas");
            System.out.println("2. Cargar información de series");
            System.out.println("3. Cargar información de Documentales");
            System.out.println("4. Cargar información de Noticias De TV");
            System.out.println("5. Cargar información de Podcasts");
            System.out.println("6. Mostrar información cargada");
            System.out.println("7. Generar archivo de respaldo");
            System.out.println("8. Salir \n");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer del scanner.

            switch (opcion) {
                case 1: // Cargar información de películas.
                    try {
                        System.out.println("Cargando datos de películas...");
                        controlador.cargarDesdeCSV(rutaPeliculas, "Pelicula");
                        System.out.println("Películas cargadas correctamente.");
                    } catch (IOException e) {
                        System.err.println("Error al cargar las películas: " + e.getMessage());
                    }
                    break;

                case 2: // Cargar información de series.
                    try {
                        System.out.println("Cargando datos de series...");
                        controlador.cargarDesdeCSV(rutaSeries, "Serie");
                        System.out.println("Series cargadas correctamente.");
                    } catch (IOException e) {
                        System.err.println("Error al cargar las series: " + e.getMessage());
                    }
                    break;

                case 3: // Cargar información de películas.
                    try {
                        System.out.println("Cargando datos de Documentales...");
                        controlador.cargarDesdeCSV(rutaDocumentales, "Documental");
                        System.out.println("Documentales cargadas correctamente.");
                    } catch (IOException e) {
                        System.err.println("Error al cargar los Documentales: " + e.getMessage());
                    }
                    break;

                case 4: // Cargar información de películas.
                    try {
                        System.out.println("Cargando datos de Noticias De TV...");
                        controlador.cargarDesdeCSV(rutaNoticiasDeTV, "NoticiasDeTV");
                        System.out.println("Noticias De TV cargadas correctamente.");
                    } catch (IOException e) {
                        System.err.println("Error al cargar los Documentales: " + e.getMessage());
                    }
                    break;

                case 5: // Cargar información de películas.
                    try {
                        System.out.println("Cargando datos de Noticias De TV...");
                        controlador.cargarDesdeCSV(rutaPodcasts, "Podcasts");
                        System.out.println("Podcasts cargados correctamente.");
                    } catch (IOException e) {
                        System.err.println("Error al cargar los Documentales: " + e.getMessage());
                    }
                    break;

                case 6: // Mostrar información cargada.
                    System.out.println("\n*** Contenidos Audiovisuales Cargados ***");
                    for (ContenidoAudiovisual contenido : controlador.getContenidos()) {
                        if (contenido instanceof Pelicula) {
                            mostrarPelicula((Pelicula) contenido);
                        } else if (contenido instanceof SerieDeTV) {
                            mostrarSerie((SerieDeTV) contenido);
                        } else if (contenido instanceof Documental) {
                            mostrarDocumental((Documental) contenido);
                        }else if (contenido instanceof NoticiasDeTV) {
                            mostrarNoticiasDeTV((NoticiasDeTV) contenido);
                        }else if (contenido instanceof Podcasts) {
                            mostrarPodcasts((Podcasts) contenido);
                        }

                    }
                    break;

                case 7: // Generar archivo de respaldo.
                    try {
                        controlador.guardarEnCSV(rutaRespaldo);
                        System.out.println("Archivo de respaldo generado correctamente en: " + rutaRespaldo);
                    } catch (IOException e) {
                        System.err.println("Error al generar el archivo de respaldo: " + e.getMessage());
                    }
                    break;

                case 8: // Salir.
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default: // Opción no válida.
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para mostrar la información de una película con encabezados.
    private static void mostrarPelicula(Pelicula pelicula) {
        System.out.println("\n*** Película ***");
        System.out.println("Id: " + pelicula.id);
        System.out.println("Título: " + pelicula.titulo);
        System.out.println("Duración en minutos: " + pelicula.duracionEnMinutos);
        System.out.println("Género: " + pelicula.genero);
        System.out.println("Estudio: " + pelicula.estudio);
        System.out.println("Actores: " + String.join(", ", pelicula.getActores()));
    }

    // Método para mostrar la información de una serie de TV con encabezados.
    private static void mostrarSerie(SerieDeTV serie) {
        System.out.println("\n*** Serie de TV ***");
        System.out.println("Id: " + serie.id);
        System.out.println("Título: " + serie.titulo);
        System.out.println("Duración en minutos: " + serie.duracionEnMinutos);
        System.out.println("Género: " + serie.genero);
        System.out.println("Temporadas:");

        // Iterar sobre las cadenas devueltas por getTemporadas()
        for (String temporadaInfo : serie.getTemporadas()) {
            System.out.println("  " + temporadaInfo); // Cada temporada es una cadena que describe la temporada
        }
    }

    private static void mostrarDocumental(Documental documental) {
        System.out.println("\n*** Documental ***");
        System.out.println("Id: " + documental.id);
        System.out.println("Título: " + documental.titulo);
        System.out.println("Duración en minutos: " + documental.duracionEnMinutos);
        System.out.println("Género: " + documental.genero);
        System.out.println("Tema: " + documental.tema);
        System.out.println("Investigadores: " + String.join(", ", documental.getNombre()));
    }

    private static void mostrarNoticiasDeTV(NoticiasDeTV noticiasDeTV) {
        System.out.println("\n*** Noticias De TV ***");
        System.out.println("Id: " + noticiasDeTV.id);
        System.out.println("Título: " + noticiasDeTV.titulo);
        System.out.println("Duración en minutos: " + noticiasDeTV.duracionEnMinutos);
        System.out.println("Género: " + noticiasDeTV.genero);
        System.out.println("Canal: " + noticiasDeTV.canal);
        System.out.println("Presentadores: " + String.join(", ", noticiasDeTV.getNombre()));
    }

    private static void mostrarPodcasts(Podcasts podcasts) {
        System.out.println("\n*** Podcasts ***");
        System.out.println("Id: " + podcasts.id);
        System.out.println("Título: " + podcasts.titulo);
        System.out.println("Duración en minutos: " + podcasts.duracionEnMinutos);
        System.out.println("Género: " + podcasts.genero);
        System.out.println("Descripción: " + podcasts.descripcion);
        System.out.println("Fecha Lanzamiento: " + podcasts.fechaLanzamiento);
        System.out.println("Host: " + String.join(", ", podcasts.getHosts()));
    }
}