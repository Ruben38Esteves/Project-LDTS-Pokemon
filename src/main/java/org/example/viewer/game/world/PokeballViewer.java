package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.Bush;
import org.example.model.game.Terrain.Pokeball;

public class PokeballViewer implements TerrainViewer<Pokeball>{
    @Override
    public void draw(Pokeball pokeball, GUI gui) {
        gui.drawPokeball(pokeball.getPosition());
    }
}
