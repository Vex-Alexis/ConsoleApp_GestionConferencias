import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pista {
    List<Sesion> sesiones = new ArrayList<>();

    public Pista() {
        sesiones.add(new Sesion(180)); // Mañana
        sesiones.add(new Sesion(240)); // Tarde
    }

    public void programarCharlas(List<Charla> charlas) {
        for (Charla charla : charlas) {
            boolean programada = false;
            for (Sesion sesion : sesiones) {
                programada = sesion.agregarCharla(charla);
                if (programada) break;
            }
            if (!programada) {
                // Si no se pudo programar en ninguna sesión, crear una nueva sesión en la tarde
                Sesion nuevaSesion = new Sesion(240);
                nuevaSesion.agregarCharla(charla);
                sesiones.add(nuevaSesion);
            }
        }
    }

    public void imprimirPrograma() {
        int numeroPista = 1;
        for (Sesion sesion : sesiones) {
            System.out.println("Pista " + numeroPista + ":");
            int horaInicio = 9 * 60; // 9:00 AM
            for (Charla charla : sesion.charlas) {
                System.out.println(String.format("%02d:%02dAM %s %dmin", horaInicio / 60, horaInicio % 60, charla.titulo, charla.duracion));
                horaInicio += charla.duracion;
            }
            if (horaInicio < 12 * 60) {
                System.out.println("12:00PM Almuerzo");
            } else {
                System.out.println("05:00PM Evento de Networking");
            }
            numeroPista++;
        }
    }
}