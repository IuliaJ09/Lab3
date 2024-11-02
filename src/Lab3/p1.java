package Lab3;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> parabole = new ArrayList<>();
        Scanner sc = new Scanner(new File("C:\\Users\\Aquiris\\IdeaProjects\\Laboreator3\\src\\Lab3\\in.txt"));
        String[] linie;
        while (sc.hasNextLine()) {
            linie = sc.nextLine().split(" ");
            int a = Integer.parseInt(linie[0]);
            int b = Integer.parseInt(linie[1]);
            int c = Integer.parseInt(linie[2]);

            Parabola parabola = new Parabola(a, b, c);
            parabole.add(parabola);
        }
        sc.close();
        for (Parabola parabola : parabole) {
            System.out.println(parabola);
            double[] varf = parabola.Varf();
            System.out.println("Vârful parabolei: (" + varf[0] + ", " + varf[1] + ")");
        }
        if (parabole.size() >= 2) {
            Parabola parabola1 = parabole.get(0);
            Parabola parabola2 = parabole.get(1);
            double[] mijloc = Parabola.Varf_2Parabole(parabola1, parabola2);
            System.out.println("Coordonatele mijlocului segmentului dintre vârfuri: (" + mijloc[0] + ", " + mijloc[1] + ")");

            // Calcularea și afișarea lungimii segmentului dintre vârfurile parabolelor
            double lungime = Parabola.lungimeSegment2(parabola1, parabola2);
            System.out.println("Lungimea segmentului dintre vârfurile celor două parabole: " + lungime);
        } else {
            System.out.println("Nu există suficiente parabole pentru a calcula mijlocul și lungimea segmentului.");
        }

    }
}
