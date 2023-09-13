package org.petproject.minesweeper.window;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Frame extends JFrame {
    protected void initWindow() {
        setTitle("Minesweeper");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
