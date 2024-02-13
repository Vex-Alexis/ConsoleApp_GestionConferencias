import java.util.ArrayList;
import java.util.List;

public class Sesion {
    private int duracion;
    private List<Charla> charlas = new ArrayList<>();
    private List<Charla> charlasTarde = new ArrayList<>();

    public Sesion(int duracion) {
        this.duracion = duracion;
    }

    public boolean agregarCharla(Charla charla) {
        int tiempoDisponible = tiempoDisponible();
        if (charla.getDuracion() <= tiempoDisponible) {
            if (esTarde()) {
                charlasTarde.add(charla);
            } else {
                charlas.add(charla);
            }
            return true;
        }
        return false;
    }

    public int tiempoDisponible() {
        return duracion - duracionTotal();
    }

    public List<Charla> getCharlas() {
        return charlas;
    }

    public List<Charla> getCharlasTarde() {
        return charlasTarde;
    }

    private int duracionTotal() {
        int total = 0;
        for (Charla charla : charlas) {
            total += charla.getDuracion();
        }
        return total;
    }

    private boolean esTarde() {
        return duracion == Pista.getDuracionTarde();
    }
}

