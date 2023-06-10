package org.example;

import org.example.gui.LanternaGUI;
import org.example.model.menu.Menu;
import org.example.state.MenuState;
import org.example.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Stack;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private Stack<State> statestack = new Stack<State>();
    public void addState(State state){
        statestack.push(state);
    }
    public void previousState() {
        statestack.pop();
        //statestack.peek().step(this,gui,System.currentTimeMillis());
    }
    public Stack<State> getStateStack(){
        return statestack;
    }
    private MenuState menustate = new MenuState(new Menu());
    public Menu getMenu(){
        return menustate.getModel();
    }
    public Game() throws FontFormatException, IOException, URISyntaxException{
        this.gui = new LanternaGUI(150, 150);
        this.state = new MenuState(new Menu());
        statestack.push(null);
        statestack.push(menustate);
    }
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
    public void setState(State state) {
        this.state = state;
    }
    private void start() throws IOException, URISyntaxException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (statestack.peek() != null) {
            long startTime = System.currentTimeMillis();

            statestack.peek().step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}
