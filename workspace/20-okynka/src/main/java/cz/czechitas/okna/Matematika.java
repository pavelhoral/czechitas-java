package cz.czechitas.okna;

public class Matematika {

    public static double[] soucet(double[] prvni, double[] druhy) {
        return new double[] {
            prvni[0] + druhy[0],
            prvni[1] + druhy[1]
        };
    }

    public static double[] nasobek(double[] prvni, double[] druhy) {
        return new double[] {
            prvni[0] * druhy[0] - prvni[1] * druhy[1],
            prvni[0] * druhy[1] + prvni[1] * druhy[0]
        };
    }

    public static double absolut(double[] hodnota) {
        return Math.sqrt(hodnota[0] * hodnota[0] + hodnota[1] * hodnota[1]);
    }

    public static double[] z2c(double[] z, double[] c) {
        return soucet(nasobek(z, z), c);
    }

}