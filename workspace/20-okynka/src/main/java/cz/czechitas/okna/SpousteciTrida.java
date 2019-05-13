package cz.czechitas.okna;

import java.util.Arrays;

public class SpousteciTrida {

    public static void main(String[] args) {
        double[] prvni = new double[] { 1, 1 };
        double[] druhy = new double[] { 2, 2 };
        System.out.println(Arrays.toString(Matematika.soucet(prvni, druhy)));
        System.out.println(Arrays.toString(Matematika.nasobek(prvni, druhy)));
        System.out.println(Matematika.absolut(prvni));
        System.out.println(Arrays.toString(Matematika.z2c(prvni, druhy)));
        // new MainWindow().initialize();
    }

}
