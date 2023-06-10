package org.example.controller.game.world;

import org.example.Game;
import org.example.model.game.Map;
import org.example.gui.GUI;
import org.example.model.menu.ItemsMenu;
import org.example.model.menu.PokedexMenu;
import org.example.state.*;

import java.io.IOException;

public class MapController extends GameController{

    private final PlayerController playerController;

    public MapController(Map map){
        super(map);
        this.playerController = new PlayerController(map);
    }
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT){
            game.previousState();
        }else if(action == GUI.ACTION.POKEDEX){
            game.addState(new PokedexState(new PokedexMenu(getModel().getPlayer())));
        }else if(action == GUI.ACTION.INVENTORY){
            game.addState(new InventoryState(new ItemsMenu(getModel().getPlayer())));
        }else{
            playerController.step(game,action,time);
        }
    }
}
