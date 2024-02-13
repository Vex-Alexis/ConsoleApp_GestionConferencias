import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Charla> charlas = new ArrayList<>();
        charlas.add(new Charla("Writing Fast Tests Against Enterprise Rails", 60));
        charlas.add(new Charla("Overdoing it in Python", 45));
        charlas.add(new Charla("Lua for the Masses", 30));
        charlas.add(new Charla("Ruby Errors from Mismatched Gem Versions", 45));
        charlas.add(new Charla("Common Ruby Errors", 45));
        charlas.add(new Charla("Rails for Python Developers lightning", 60));
        charlas.add(new Charla("Communicating Over Distanceon", 60));
        charlas.add(new Charla("Accounting-Driven Development", 45));
        charlas.add(new Charla("Woah", 30));
        charlas.add(new Charla("Sit Down and Write", 30));
        charlas.add(new Charla("Pair Programming vs Noise", 45));
        charlas.add(new Charla("Rails Magic", 60));
        charlas.add(new Charla("Ruby on Rails: Why We Should Move On", 60));
        charlas.add(new Charla("Clojure Ate Scala (on my project)", 45));
        charlas.add(new Charla("Programming in the Boondocks of Seattle", 30));
        charlas.add(new Charla("Ruby vs. Clojure for Back-End Development ", 30));
        charlas.add(new Charla("Ruby on Rails Legacy App Maintenance", 60));
        charlas.add(new Charla("A World Without HackerNews", 30));
        charlas.add(new Charla("User Interface CSS in Rails Apps", 30));
        // Agrega todas las charlas restantes

        // Ordena las charlas en orden descendente por duración
        Collections.sort(charlas);

        Pista pista = new Pista();
        pista.programarCharlas(charlas);
        pista.imprimirPrograma();
    }
}