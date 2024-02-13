import java.util.ArrayList;
import java.util.List;

public class Pista {
    private static final int DURACION_MANANA = 180;
    private static final int DURACION_TARDE = 240;
    private static final int HORA_INICIO_TARDE = 13 * 60;

    private List<Sesion> sesiones = new ArrayList<>();

    public Pista() {
        sesiones.add(new Sesion(DURACION_MANANA));
        sesiones.add(new Sesion(DURACION_TARDE));
    }

    // GETTER
    public static int getDuracionTarde() {
        return DURACION_TARDE;
    }



    public void programarCharlas(List<Charla> charlas) {
        for (Charla charla : charlas) {
            boolean programada = false;
            for (Sesion sesion : sesiones) {
                programada = sesion.agregarCharla(charla);
                if (programada) break;
            }
            if (!programada) {
                Sesion nuevaSesion = new Sesion(DURACION_TARDE);
                nuevaSesion.agregarCharla(charla);
                sesiones.add(nuevaSesion);
            }
        }
    }

    public void imprimirPrograma() {
        int numeroPista = 1;

        for (Sesion sesion : sesiones) {
            System.out.println("Pista " + numeroPista + ":");
            int horaInicio = 9 * 60;

            for (Charla charla : sesion.getCharlas()) {
                System.out.println(String.format("%02d:%02dAM %s %dmin", horaInicio / 60, horaInicio % 60, charla.getTitulo(), charla.getDuracion()));
                horaInicio += charla.getDuracion();
            }

            if (horaInicio < HORA_INICIO_TARDE) {
                System.out.println("12:00PM Almuerzo");
            } else {
                for (Charla charla : sesion.getCharlasTarde()) {
                    System.out.println(String.format("%02d:%02dPM %s %dmin", horaInicio / 60, horaInicio % 60, charla.getTitulo(), charla.getDuracion()));
                    horaInicio += charla.getDuracion();
                }
            }

            System.out.println("05:00PM Evento de Networking\n");
            numeroPista++;
        }
    }
}