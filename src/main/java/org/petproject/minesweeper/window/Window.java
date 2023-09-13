package org.petproject.minesweeper.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;


@Component
public class Window {
    private final MouseClick mouseClick;
    private final Frame frame;
    private final Panel panel;
    private final Label label;

    @Autowired
    public Window(MouseClick mouseClick, Frame frame, Panel panel, Label label) {
        this.mouseClick = mouseClick;
        this.frame = frame;
        this.panel = panel;
        this.label = label;
    }


    public void createWindow() {
        frame.initWindow();
        label.initLabel();
        panel.initPanel();

        panel.addMouseListener(mouseClick);

        frame.add(panel);
        frame.add(label, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);


    }

}
