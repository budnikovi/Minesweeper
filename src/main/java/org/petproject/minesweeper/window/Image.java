package org.petproject.minesweeper.window;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Objects;

@Component
public class Image {
    protected java.awt.Image getImageRes(String name) {
        String filename = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(filename)));
        return icon.getImage();

    }
}
