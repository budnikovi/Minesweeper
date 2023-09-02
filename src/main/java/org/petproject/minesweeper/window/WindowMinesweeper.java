package org.petproject.minesweeper.window;

import javax.swing.*;
import java.awt.*;

public class WindowMinesweeper extends JFrame {

    public WindowMinesweeper() {

        setTitle("Minesweeper");
        setSize(400,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }



    public static void main(String[] args) {
        new WindowMinesweeper();
    }

}
