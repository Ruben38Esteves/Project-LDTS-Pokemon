package org.example.viewer.game.world;

import org.example.model.game.entities.Player;
import org.example.gui.GUI;

public class PlayerViewer {
    public void draw(Player player, GUI gui){
        gui.drawPlayer(player);
    }
}
