package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.PokedexMenu;
import org.example.model.menu.StatsMenu;
import org.example.state.StatsState;

import java.io.IOException;

public class PokedexController extends Controller<PokedexMenu> {
    public PokedexController(PokedexMenu pokedexMenu){
        super(pokedexMenu);
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
                game.addState(new StatsState(new StatsMenu(getModel().getPlayer().getPokemon(getModel().getCurrentChoice()),getModel().getCurrentChoice(),getModel().getPlayer())));
                break;
            }
            case QUIT:{
                game.previousState();
                break;
            }
        }
    }
}
