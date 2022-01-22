package com.batman.engine;

import com.batman.menu.Help;
import com.batman.menu.MainMenu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GUIStateManager {

    private final List<GUIState> gamesStates = new ArrayList<>();

    public static final int MENU = 0;
    public static final int HELP = 1;

    private int currentState;

    public GUIStateManager() {
        currentState = MENU;
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
}
