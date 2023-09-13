package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;
import org.petproject.minesweeper.logic.Game;
import org.petproject.minesweeper.logic.PressButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class MouseClick extends MouseAdapter {

    private final PressButton pressButton;
    private final Panel panel;
    private final Label label;
    private final Game game;

    @Autowired
    public MouseClick(PressButton pressButton, Panel panel, Label label, Game game) {
        this.pressButton = pressButton;
        this.panel = panel;
        this.label = label;
        this.game = game;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Coordinates cord = new Coordinates(e.getX() / Constants.IMAGE_SIZE,
                e.getY() / Constants.IMAGE_SIZE);
        if (e.getButton() == MouseEvent.BUTTON1) {
            pressButton.pressLeftButton(cord);
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            pressButton.pressRightButton(cord);
        }
        panel.repaint();
        label.updateLabel(game.getState());


    }
}
