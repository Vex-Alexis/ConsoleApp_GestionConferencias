import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Charla implements Comparable<Charla> {
    String titulo;
    int duracion;

    public Charla(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public int compareTo(Charla charla) {
        return charla.duracion - this.duracion; // Ordenar en orden descendente por duración
    }
}
