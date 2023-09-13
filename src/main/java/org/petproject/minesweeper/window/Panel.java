package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.logic.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class Panel extends DrawIcon {

    private Constants constants;
    @Autowired
    public Panel(OperateImages images, Game game) {
        super(images, game);
    }

    protected void initPanel() {
        constants = new Constants();
        setPreferredSize(
                new Dimension(
                        constants.ROWS * Constants.IMAGE_SIZE, constants.COLS * Constants.IMAGE_SIZE));

    }


}
