package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Box;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperateImagesMinesweeper {

    @Autowired
    ImageMinesweeper imageMS;

    public void setImages() {
        for (Box box : Box.values()) {
            box.image = imageMS.getImageRes(box.name());
        }
    }

}
