package cz.czechitas.okna;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    public void initialize() {
        setTitle("Czechitas");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        addMouseListener(new MouseHandler());
    }
    
    private void makej(Point point) {
        Graphics graphics = getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.fillOval(point.x, point.y, 10, 10);
    }


    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            makej(e.getPoint());
        }

    }

}
