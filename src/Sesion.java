import java.util.ArrayList;
import java.util.List;

public class Sesion {
    List<Charla> charlas = new ArrayList<>();
    int tiempoRestante;

    public Sesion(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public boolean agregarCharla(Charla charla) {
        if (tiempoRestante >= charla.duracion) {
            charlas.add(charla);
            tiempoRestante -= charla.duracion;
            return true;
        }
        return false;
    }
}
