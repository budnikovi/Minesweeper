package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Box;

import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class DrawIconMinesweeper extends JPanel {
    @Autowired
    OperateImagesMinesweeper images;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        images.setImages();
        for (Box box: Box.values()) {
            Coordinates cord = new Coordinates(box.ordinal() * Constants.IMAGE_SIZE,0);
            g.drawImage(box.image, cord.getX() , cord.getY(),this);
        }

    }
}
