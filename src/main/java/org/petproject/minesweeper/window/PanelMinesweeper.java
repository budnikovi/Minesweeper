package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class PanelMinesweeper extends DrawIconMinesweeper {

    @Autowired
    public PanelMinesweeper(OperateImagesMinesweeper images) {
        super(images);
    }

    protected void initPanel() {
        setPreferredSize(
                new Dimension(
                        Constants.getSize().getX() * Constants.IMAGE_SIZE,Constants.getSize().getY() * Constants.IMAGE_SIZE));

    }


}
