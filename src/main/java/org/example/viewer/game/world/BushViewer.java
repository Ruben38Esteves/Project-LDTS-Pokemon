package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.Bush;

public class BushViewer implements TerrainViewer<Bush>{
    public void draw(Bush bush, GUI gui){
        gui.drawBush(bush.getPosition(),bush);
    }
}
