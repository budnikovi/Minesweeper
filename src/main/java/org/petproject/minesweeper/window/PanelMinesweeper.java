package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class PanelMinesweeper extends DrawIconMinesweeper {

    protected void initPanel() {
        setSize(
                new Dimension(
                        Constants.COLS * Constants.IMAGE_SIZE,Constants.ROWS * Constants.IMAGE_SIZE));
    }


}
