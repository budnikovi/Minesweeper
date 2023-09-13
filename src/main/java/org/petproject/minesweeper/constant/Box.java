package org.petproject.minesweeper.constant;

import java.awt.*;

public enum Box {
    ZERO,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,
    BOMB,
    OPENED,
    CLOSED,
    FLAGGED,
    BOMBED,
    NOBOMB;

    public Image image;

    public Box getNumberAroundBomb() {
        return Box.values()[this.ordinal() + 1];
    }

    public Integer getNumber() {
        return this.ordinal();
    }
}
