package cz.czechitas.okna;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
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
        Dimension size = getSize();
        for (int x = 0; x < size.width; x++) {
            for (int y = 0; y < size.height; y++) {
                double[] souradnice = new double[] { x - size.width / 2, y - size.height / 2 };
                int odstin = ((int) Matematika.absolut(souradnice)) % 256;
                graphics.setColor(new Color(odstin, odstin, odstin));
                graphics.drawRect(x, y, 1, 1);
            }
        }
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
