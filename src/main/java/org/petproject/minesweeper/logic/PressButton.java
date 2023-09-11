package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Coordinates;
import org.petproject.minesweeper.constant.GameConstantClass;
import org.springframework.stereotype.Component;

@Component
public class PressButton {

    private Game game = GameConstantClass.getGame();

    public void pressLeftButton(Coordinates cord) {
        if (game.getFlag().getFlagMap().getMatrixCord(cord) != Box.FLAGGED) {
            game.getFlag().setOpenedToBox(cord);
        }
    }

    public void pressRightButton(Coordinates cord) {
        game.getFlag().setFlaggedToBox(cord);

    }
}
