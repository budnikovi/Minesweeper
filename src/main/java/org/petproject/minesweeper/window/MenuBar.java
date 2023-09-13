package org.petproject.minesweeper.window;

import org.petproject.minesweeper.constant.Constants;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class MenuBar extends JMenuBar {
    private JMenu fileMenu;
    private JMenu settingsMenu;
    private JMenuItem newGameItem;
    private JMenuItem exitItem;
    private JMenuItem gridSizeItem;
    private Constants constants;

    public MenuBar() {
        fileMenu = new JMenu("File");
        settingsMenu = new JMenu("Settings");
        newGameItem = new JMenuItem("New Game");
        exitItem = new JMenuItem("Exit");
        gridSizeItem = new JMenuItem("Grid Size");
        constants = new Constants();
    }

    public void initMenuBar() {
        settingsMenu.add(gridSizeItem);
        fileMenu.add(newGameItem);
        fileMenu.add(exitItem);
        add(fileMenu);
        add(settingsMenu);
    }

    protected void viewMenuBar(Frame frame, Panel panel) {
        gridSizeItem.addActionListener(e -> {
            String[] options = {"Easy", "Medium", "Hard", "Custom"};
            int choice = JOptionPane.showOptionDialog(frame, "Select Difficulty",
                    "Difficulty", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                // Легкий уровень сложности
                setGameParameters(8, 8, 10); // Например, 8x8 поле и 10 бомб
            } else if (choice == 1) {
                // Средний уровень сложности
                setGameParameters(12, 12, 20); // Например, 12x12 поле и 20 бомб
            } else if (choice == 2) {
                // Сложный уровень сложности
                setGameParameters(16, 16, 40); // Например, 16x16 поле и 40 бомб
            } else if (choice == 3) {
                // Пользовательский ввод
                String customRows = JOptionPane.showInputDialog(frame, "Enter number of rows:");
                String customCols = JOptionPane.showInputDialog(frame, "Enter number of columns:");
                String customBombs = JOptionPane.showInputDialog(frame, "Enter number of bombs:");

                try {
                    int rows = Integer.parseInt(customRows);
                    int cols = Integer.parseInt(customCols);
                    int bombs = Integer.parseInt(customBombs);

                    // Установите параметры игры на основе пользовательского ввода
                    setGameParameters(rows, cols, bombs);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
                }
            }
            panel.initPanel();
            panel.repaint();
        });
    }

    private void setGameParameters(int rows, int cols, int bombs) {
        Constants.setMainParameters(rows,cols,bombs, constants);
    }
}
