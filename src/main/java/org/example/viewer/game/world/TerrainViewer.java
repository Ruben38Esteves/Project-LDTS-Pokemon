package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.Terrain;

public interface TerrainViewer<T extends Terrain> {
    void draw(T terrain, GUI gui);
}
