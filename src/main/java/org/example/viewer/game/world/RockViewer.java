package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.Terrain.Rock;

public class RockViewer implements TerrainViewer<Rock>{
    public void draw(Rock rock, GUI gui){
        gui.drawRock(rock.getPosition(), rock);
    }
}
