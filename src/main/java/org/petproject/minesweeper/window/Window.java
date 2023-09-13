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
    private final MenuBar menuBar;

    @Autowired
    public Window(MouseClick mouseClick, Frame frame, Panel panel, Label label, MenuBar menuBar) {
        this.mouseClick = mouseClick;
        this.frame = frame;
        this.panel = panel;
        this.label = label;
        this.menuBar = menuBar;
    }


    public void createWindow() {
        frame.initWindow();
        label.initLabel();
        panel.initPanel();
        menuBar.initMenuBar();

        menuBar.viewMenuBar(frame, panel);

        panel.addMouseListener(mouseClick);

        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.add(label, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);


    }

}
