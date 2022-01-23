package com.batman.menu;

import com.batman.engine.GUIState;
import com.batman.engine.GUIStateManager;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Introduction extends GUIState {

    private static final File backGround = new File("src/main/resources/menu/img/introduction.jpg");

    private BufferedImage introductionBackGround;

    public Introduction(GUIStateManager GUIStateManager) {
        this.GUIStateManager = GUIStateManager;
        init();
    }

    @Override
    public void init() {
        try {
            introductionBackGround = ImageIO.read(backGround);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(introductionBackGround, 0, 0, null);
    }

    @Override
    public void onKeyPressed(KeyEvent key) {

    }

    @Override
    public void onKeyReleased(KeyEvent key) {

    }
}
