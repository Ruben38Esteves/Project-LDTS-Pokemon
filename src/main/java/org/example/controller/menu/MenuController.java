package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.Menu;
import org.example.state.State;
import org.example.state.WorldState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }
    private State worldState = new WorldState(getModel().getWorld(),1);
    public State getWorldState(){
        return worldState;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:{
                getModel().previousChoice();
                break;
            }
            case DOWN:{
                getModel().nextChoice();
                break;
            }
            case SELECT:{
                if(getModel().isSelectedStartGame()){
                    game.addState(worldState);
                }
                if(getModel().isSelectedExit()){
                    game.previousState();
                }
            }
        }
    }
}
