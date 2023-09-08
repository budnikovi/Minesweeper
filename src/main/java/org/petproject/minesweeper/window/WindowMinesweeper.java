package org.petproject.minesweeper.window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WindowMinesweeper  {
    private final FrameMinesweeper frame;
    private final PanelMinesweeper panel;

    @Autowired
    public WindowMinesweeper(FrameMinesweeper frame, PanelMinesweeper panel) {
        this.frame = frame;
        this.panel = panel;}


    public void createWindow() {
        frame.initWindow();
        panel.initPanel();

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);

    }

}
