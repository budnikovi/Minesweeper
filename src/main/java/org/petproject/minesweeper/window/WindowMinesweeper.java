package org.petproject.minesweeper.window;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WindowMinesweeper  {
    @Autowired
    FrameMinesweeper frame;
    @Autowired
    PanelMinesweeper panel;

    @PostConstruct
    public void initialize() {
        frame.initWindow();
        panel.initPanel();

        frame.add(panel);

    }



}
