package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class FrameMinesweeper extends JFrame {
    protected void initWindow() {
        setTitle("Minesweeper");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
}
