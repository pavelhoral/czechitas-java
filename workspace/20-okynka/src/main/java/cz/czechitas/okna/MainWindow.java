package cz.czechitas.okna;

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
    
    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("CLICKED " + e.getPoint());
        }

    }

}