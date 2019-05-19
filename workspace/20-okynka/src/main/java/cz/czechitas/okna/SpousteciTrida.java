package cz.czechitas.okna;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SpousteciTrida {

    public static void main(String[] args) {
        JFrame okno = new JFrame("Czechitas");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);

        Image obrazek = generujObrazek(600, 600);
        okno.add(new JLabel(new ImageIcon(obrazek)));

        okno.pack();
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
    }

    public static Image generujObrazek(int sirka, int vyska) {
        // Vytvarim prazdny obrazek o velikosti sirka x vyska
        BufferedImage obrazek = new BufferedImage(sirka, vyska, BufferedImage.TYPE_INT_RGB);
        // Do obrazku muzeme kreslit pres tridu "Graphics2D"
        Graphics2D platno = (Graphics2D) obrazek.getGraphics();
        // Postupne generuji barvu pro kazdy jeho pixel
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                // Troska matematiky, aby souradnice (0, 0) byly uprostred obrazku
                double zoom = 5.0 / sirka;
                double[] souradnice = { (x - sirka / 2) * zoom, (y - vyska / 2) * zoom };
                // Urceni barvy a obarveni pixelu
                platno.setColor(ziskejOdstin(souradnice, 50));
                platno.drawRect(x, y, 1, 1);
            }
        }
        return obrazek;
    }

    private static Color ziskejOdstin(double[] souradnice, int pocetOdstinu) {
        int rychlost = spocitejRychlost(souradnice, pocetOdstinu);
        int odstin = (255 * rychlost) / pocetOdstinu;
        return new Color(odstin, odstin, odstin);
    }

    // Trocha magie pro Mandelbrotovu mnozinu (pocet volani z2c pro |z| > 2)
    // https://cs.wikipedia.org/wiki/Mandelbrotova_mno%C5%BEina
    private static int spocitejRychlost(double[] c, int maximum) {
        double[] z = c;
        for (int kroky = 0; kroky < maximum; kroky++) {
            if (Matematika.absolut(z) > 2) {
                return kroky;
            }
            z = Matematika.z2c(z, c);
        }
        return maximum;
    }

}
