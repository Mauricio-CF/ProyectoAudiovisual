package poo;
import uni1a.*;

import java.util.ArrayList;
import java.util.List;

public class PruebaAudioVisual {
    public static void main(String[] args) {

        List<Actor> actores = new ArrayList<Actor>();
        actores.add(new Actor("Sam Worthington"));
        actores.add(new Actor("Zoe Saldaña"));
        actores.add(new Actor("Stephen Lang"));

        List<Temporada> temporadas = new ArrayList<Temporada>();
        temporadas.add(new Temporada(1,10));
        temporadas.add(new Temporada(2,10));
        temporadas.add(new Temporada(3,10));
        temporadas.add(new Temporada(4,10));
        temporadas.add(new Temporada(5,10));
        temporadas.add(new Temporada(6,10));
        temporadas.add(new Temporada(7,7));
        temporadas.add(new Temporada(8,6));


        List<Investigador> invest = new ArrayList<Investigador>();
        invest.add(new Investigador("Neil deGrasses Tyson"));
        invest.add(new Investigador("Steven Soter"));
        invest.add(new Investigador("Carl Sagan"));

        List<Presentador> Present = new ArrayList<Presentador>();
        Present.add(new Presentador("Jeanette Hinostroza"));
        Present.add(new Presentador("Alejandra Boada"));
        Present.add(new Presentador("Milton Pérez"));


        List<Host> host = new ArrayList<Host>();
        host.add(new Host("Tomàs Fuente"));
        host.add(new Host("Ignasi Taltavull"));

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios",actores);
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8, temporadas);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy",invest);
        contenidos[3] = new NoticiasDeTV("Noticiero de la Mañana", 90, "Noticias", "Teleamazonas",Present);
        contenidos[4] = new Podcasts("La Ruina", 60, "Comedia", "se dedican a comentar, junto con un invitado al que llevan cada semana, la peor anécdota que cuente alguna de las personas que haya ido de público al programa","18-01-2023",host);


        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
}