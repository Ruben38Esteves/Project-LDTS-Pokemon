package org.example.model.menu;

import org.example.model.game.entities.Player;

public class ItemsMenu {
    private Player player;
    public ItemsMenu(Player player){
        this.player=player;
    }
    public Player getPlayer() {
        return player;
    }
}
