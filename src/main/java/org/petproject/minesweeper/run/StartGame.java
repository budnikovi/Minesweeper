package org.petproject.minesweeper.run;

import jakarta.annotation.PostConstruct;
import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.GameConstantClass;
import org.petproject.minesweeper.logic.Game;
import org.petproject.minesweeper.window.WindowMinesweeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartGame {
    WindowMinesweeper windowMinesweeper;
    Game game = GameConstantClass.getGame();

    @Autowired
    public StartGame(WindowMinesweeper windowMinesweeper) {
        this.windowMinesweeper = windowMinesweeper;
    }

    @PostConstruct
    public void initialize() {
        windowMinesweeper.createWindow();
        game.start();
    }
}
