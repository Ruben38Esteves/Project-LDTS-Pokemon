package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.Pokeball;
import org.example.model.game.Terrain.Potion;

public class PotionViewer  implements TerrainViewer<Potion>{
    @Override
    public void draw(Potion potion, GUI gui) {
        gui.drawPotion(potion.getPosition());
    }
}
