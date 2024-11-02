package Lab3;
import java.util.Scanner;
class Parabola {
    int a,b,c;
    public  Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double[] Varf(){
        double v1,v2;
        v1=-b/(2*a);
        v2=(-Math.pow(b,2)+4*a*c)/(4*a);
        return new double[]{v1, v2};
    }
    public String toString() {
        // Returnează funcția sub forma specificată
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }
    //Mijloc segmentului de dreptă care uneşte vârful parabolei curente cu varful
    //parabolei transmisă ca și parametru de intrare
    public double[] Varf_Parabole(Parabola p) {
        double[] varf1 = this.Varf();
        double[] varf2 = p.Varf();
        double xm = (varf1[0] + varf2[0]) / 2;
        double ym = (varf1[1] + varf2[1]) / 2;
        return new double[]{xm, ym};
    }
    //mijlocului segmentului de dreptă care uneşte vârfurile celor două parabole.
    public static double[] Varf_2Parabole(Parabola p1, Parabola p2){
        double[] varf1 = p1.Varf();
        double[] varf2 = p2.Varf();
        double xm = (varf1[0] + varf2[0]) / 2;
        double ym = (varf1[1] + varf2[1]) / 2;
        return new double[]{xm, ym};
    }
    // Metodă pentru calcularea lungimii segmentului de dreaptă dintre vârful parabolei curente și vârful unei parabole date
    public double lungimeSegment(Parabola p) {
        double[] varf1 = this.Varf();
        double[] varf2 = p.Varf();
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }

    // Metodă statică pentru calcularea lungimii segmentului dintre vârfurile a două parabole
    public static double lungimeSegment2(Parabola p1, Parabola p2) {
        double[] varf1 = p1.Varf();
        double[] varf2 = p2.Varf();
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }
}
