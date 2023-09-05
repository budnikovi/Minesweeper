package org.petproject.minesweeper;

import org.petproject.minesweeper.window.WindowMinesweeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinesweeperApplication {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(MinesweeperApplication.class, args);

    }

}
