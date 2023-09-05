package org.petproject.minesweeper.window;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class FrameMinesweeper extends JFrame {
    protected void initWindow() {
        setTitle("Minesweeper");
        setSize(1000,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
