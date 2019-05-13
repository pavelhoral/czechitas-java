package cz.czechitas.okna;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    private MouseHandler mouseHandler = new MouseHandler();

    public void initialize() {
        setTitle("Czechitas");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    private void makej(Point start, Point end) {
        Graphics2D graphics = (Graphics2D) getGraphics();
        Dimension windowSize = getSize();
        Insets windowInsets = getInsets();
        Dimension size = new Dimension(
                windowSize.width - windowInsets.left - windowInsets.right, 
                windowSize.height - windowInsets.top - windowInsets.bottom);
        double scale = 5.0 / size.width;
        for (int x = 0; x < size.width; x++) {
            for (int y = 0; y < size.height; y++) {
                double[] souradnice = new double[] { (x - size.width / 2) * scale, (y - size.height / 2) * scale };
                graphics.setColor(odstin(souradnice));
                graphics.drawRect(x + windowInsets.left, y + windowInsets.top, 1, 1);
            }
        }
    }

    private Color odstin(double[] souradnice) {
        double[] hodnota = souradnice;
        int kroky = 0;
        while (kroky++ < 20 && Matematika.absolut(hodnota) <= 2) {
            hodnota = Matematika.z2c(hodnota, souradnice);
        }
        if (kroky > 20) {
            return Color.WHITE;
        }
        int odstin = (int) (256 * ((double) kroky - 1) / 20);
        return new Color(odstin, odstin, odstin);
    }

    private void smazto() {
        Graphics2D graphics = (Graphics2D) getGraphics();
        Dimension size = getSize();
        graphics.clearRect(0, 0, size.width, size.height);
    }


    private class MouseHandler extends MouseAdapter {

        private Point previous;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                previous = e.getPoint();
                makej(previous, previous);
            } else {
                smazto();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            previous = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (previous == null) {
                return;
            }
            Point current = e.getPoint();
            makej(previous, current);
            previous = current;
        }

        @Override
        public void mouseExited(MouseEvent e) {
            previous = null;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            previous = e.getPoint();
        }

    }

}
