/*

Supposed to handle global constants but there's only one I need to be global right now

*/

package ui;

import logic.TetrisProperties;
import ui.logic.KeyInput;
import ui.logic.ReadWebPageEx;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public final class Constants {

    public static JFrame UIFrame = new JFrame(ReadWebPageEx.fetchString());

    public static int gameSpeed;

    public static final int blockSize = 15;

    public static final int boardHeight = 20;
    public static final int boardWidth = 10;

    private static final Constants INSTANCE = new Constants();
    private TetrisProperties prop;

    private Constants() {
    }

    public static Constants getInstance() {
        return INSTANCE;
    }

    //MODIFIES: this
    //EFFECTS: initializes global constants and default values
    public void initConstants(String configPath) {
        prop = new TetrisProperties();
        KeyListener keyListener = new KeyInput();
        UIFrame.addKeyListener(keyListener);

        int initialSpeed = 1;

        File properties = new File(configPath);
        try {
            if (properties.isFile()) {
                gameSpeed = prop.readFromProperties(configPath);
            } else {
                gameSpeed = initialSpeed;
                prop.writeToProperties(initialSpeed, configPath);
            }
        } catch (IOException e) {
            gameSpeed = 1;
            System.out.println("IOException was thrown initializing constants");
            e.printStackTrace();
        }
    }

    //EFFECTS: returns gameSpeed
    public int getGameSpeed() {
        return gameSpeed;
    }

    //EFFECTS: sets gameSpeed
    public void setGameSpeed(int i) {
        gameSpeed = i;
    }

}
