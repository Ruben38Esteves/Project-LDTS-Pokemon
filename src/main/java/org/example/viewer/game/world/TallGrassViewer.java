package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.TallGrass;

public class TallGrassViewer implements TerrainViewer<TallGrass>{
    public void draw(TallGrass tallgrass, GUI gui){
        gui.drawTallGrass(tallgrass.getPosition());
    }
}
