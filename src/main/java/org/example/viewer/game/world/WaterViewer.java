package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.Water;

public class WaterViewer implements TerrainViewer<Water> {
    @Override
    public void draw(Water water, GUI gui) {
        gui.drawWater(water.getPosition());
    }
}
