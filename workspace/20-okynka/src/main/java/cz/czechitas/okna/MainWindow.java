package cz.czechitas.okna;

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
    }

}