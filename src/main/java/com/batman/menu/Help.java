package com.batman.menu;

import com.batman.engine.GUIState;
import com.batman.engine.GUIStateManager;
import com.batman.engine.GameEngine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Help extends GUIState {

    private static final File backgroundFile = new File("src/main/resources/menu/img/OptionsBG.jpg");

    private BufferedImage backgroundImage;

    public Help(GUIStateManager GUIStateManager) {
        this.GUIStateManager = GUIStateManager;
        init();
    }

    @Override
    public void init() {
        try {
            backgroundImage = ImageIO.read(backgroundFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        drawGraphics(g);
        drawHelpInformation(g);
        drawMenuOption(g);
    }

    @Override
    public void onKeyPressed(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            selectMenuOption();
        }
    }

    @Override
    public void onKeyReleased(KeyEvent key) {

    }

    private void selectMenuOption() {
        GUIStateManager.setStates(GUIStateManager.MENU);
    }

    private void drawGraphics(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }

    private void drawHelpInformation(Graphics g) {

    }

    private void drawMenuOption(Graphics g) {
        g.setColor(new Color(58,6,10));
        g.drawString("BACK", (GameEngine.WIDTH / 2) - 68, GameEngine.HEIGHT - 20);
    }
}
