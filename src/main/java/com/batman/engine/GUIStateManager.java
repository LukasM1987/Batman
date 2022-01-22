package com.batman.engine;

import com.batman.menu.Help;
import com.batman.menu.MainMenu;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIStateManager {

    private final List<GUIState> gamesStates = new ArrayList<>();
    private static final File menuMusic = new File("src/main/resources/menu/sounds/THE BATMAN Main Music.wav");


    public static final int MENU = 0;
    public static final int HELP = 1;

    private Clip clip;
    private int currentState;

    public GUIStateManager() {
        currentState = MENU;
        playMainMenuMusic();
        gamesStates.add(new MainMenu(this));
        gamesStates.add(new Help(this));

    }

    public void setStates(int state) {
        setCurrentState(state);
        gamesStates.get(getCurrentState()).init();
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public void update() {
        gamesStates.get(currentState).update();
    }


    public void draw(Graphics g) {
        gamesStates.get(getCurrentState()).draw(g);
    }

    public void keyPressed(KeyEvent key) {
        gamesStates.get(getCurrentState()).onKeyPressed(key);
    }


    public void keyReleased(KeyEvent key) {
        gamesStates.get(getCurrentState()).onKeyReleased(key);
    }

    public Clip getClip() {
        return clip;
    }

    private void playMainMenuMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(menuMusic);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(2147483647);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}
