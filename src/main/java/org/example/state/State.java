package org.example.state;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.viewer.Viewer;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;
    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public T getModel() {
        return model;
    }
    public void step(Game game, GUI gui, long time) throws IOException, URISyntaxException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
