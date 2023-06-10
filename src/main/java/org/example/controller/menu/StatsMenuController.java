package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.StatsMenu;
import org.example.state.StatsState;

import java.io.IOException;
import java.net.URISyntaxException;

public class StatsMenuController extends Controller<StatsMenu> {
    public StatsMenuController(StatsMenu statsMenu){super(statsMenu);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action){
            case LEFT:{
                getModel().toggleChoice();
                break;
            }
            case RIGHT:{
                getModel().toggleChoice();
                break;
            }
            case SELECT:{
                if(getModel().getChoice()){
                    getModel().getPlayer().setPokemonchoice(getModel().getPokemonchoice());
                    game.previousState();
                    game.previousState();
                    break;
                }else{
                    game.previousState();
                }
            }
        }
    }
}
