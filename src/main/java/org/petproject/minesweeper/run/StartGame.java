package org.petproject.minesweeper.run;

import jakarta.annotation.PostConstruct;
import org.petproject.minesweeper.logic.Game;
import org.petproject.minesweeper.window.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartGame {
    Window windowMinesweeper;
    private final Game game;

    @Autowired
    public StartGame(Window windowMinesweeper, Game game) {
        this.windowMinesweeper = windowMinesweeper;
        this.game = game;
    }

    @PostConstruct
    public void initialize() {
        windowMinesweeper.createWindow();
        game.start();
    }
}
