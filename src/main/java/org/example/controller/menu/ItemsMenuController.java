package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.menu.ItemsMenu;

import java.io.IOException;

public class ItemsMenuController extends Controller<ItemsMenu> {
    public ItemsMenuController(ItemsMenu itemsMenu){
        super(itemsMenu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case SELECT:{
                getModel().getPlayer().usePotion(getModel().getPlayer().getPokemon(getModel().getPlayer().getPokemonchoice()));
            }
            case QUIT:{
                game.previousState();
            }
        }
    }
}
