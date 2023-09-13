package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;
import org.petproject.minesweeper.constant.GameConstantClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class DrawIcon extends JPanel {
    private final OperateImages images;

    @Autowired
    public DrawIcon(OperateImages images) {
        this.images = images;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        images.setImages();
        for (Coordinates cord : Constants.getAllCoordinates()) {
            g.drawImage(GameConstantClass.getGame().getBoxGame(cord).image, cord.getX() * Constants.IMAGE_SIZE, cord.getY() * Constants.IMAGE_SIZE, this);
        }

    }
}
