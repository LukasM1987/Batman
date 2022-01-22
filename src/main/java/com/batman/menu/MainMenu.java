package com.batman.menu;

import com.batman.engine.GUIState;
import com.batman.engine.GUIStateManager;
import com.batman.engine.GameEngine;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends GUIState {

    private static final String[] options = {" NEW GAME", "   OPTIONS", "QUIT  GAME"};
    private static final File background = new File("src/main/resources/menu/img/MenuBG.jpg");
    private static final File menuMusic = new File("src/main/resources/menu/sounds/THE BATMAN Main Music.wav");

    private static int currentChoice = 0;

    private BufferedImage backgroundImage;
    private Clip clip;

    public MainMenu(GUIStateManager GUIStateManager) {
        this.GUIStateManager = GUIStateManager;
        init();
    }

    public void init() {
        try {
            backgroundImage = ImageIO.read(background);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(menuMusic);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(2147483647);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void update() {

    }

    public void draw(Graphics g) {
        drawGraphics(g);
        drawMenuOptions(g);
    }

    public static int setCurrentChoice(int choice) {
        return currentChoice = choice;
    }

    private void drawGraphics(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
        g.setFont(new Font("Impact", Font.PLAIN, 52));
    }

    private void drawMenuOptions(Graphics g) {
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(new Color(58,6,10));
            } else {
                g.setColor(new Color(187,6,21));
            }
            g.drawString(options[i], (GameEngine.WIDTH / 2) + 90, 70 + i * 58);
        }
    }

    private int selectMenuOption() {
        if(currentChoice == 0){
            //GUIStateManager.setStates(GUIStateManager.STORY);
            clip.stop();
        }

        if (currentChoice == 1) {
            GUIStateManager.setStates(GUIStateManager.HELP);
        }

        if(currentChoice == 2){
            exitGame();
        }
        return currentChoice;
    }

    @Override
    public void onKeyPressed(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            selectMenuOption();
        }

        if (key.getKeyCode() == KeyEvent.VK_UP || key.getKeyCode() == KeyEvent.VK_W) {
            currentChoice--;
            if (currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }

        if (key.getKeyCode() == KeyEvent.VK_DOWN || key.getKeyCode() == KeyEvent.VK_S) {
            currentChoice++;
            if (currentChoice == options.length) {
                currentChoice = 0;
            }
        }
    }

    @Override
    public void onKeyReleased(KeyEvent key) {

    }

    private void exitGame() {
        System.exit(0);
    }
}
