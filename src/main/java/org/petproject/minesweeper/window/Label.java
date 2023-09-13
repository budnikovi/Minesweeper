package org.petproject.minesweeper.window;

import org.petproject.minesweeper.logic.Game;
import org.petproject.minesweeper.logic.State;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Label extends JLabel {

    private final Game game;

    public Label(Game game) {
        this.game = game;
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    protected void initLabel() {
        setText(game.getState().getMessage());
    }

    public void updateLabel(State state) {
        setText(state.getMessage());
    }


}
