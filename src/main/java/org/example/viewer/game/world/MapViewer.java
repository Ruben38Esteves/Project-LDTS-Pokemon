package org.example.viewer.game.world;

import org.example.model.game.Map;
import org.example.model.game.entities.Player;
import org.example.gui.GUI;
import org.example.model.game.Terrain.Terrain;
import org.example.viewer.Viewer;

import java.util.List;

public class MapViewer extends Viewer<Map> {
    public MapViewer(Map map){
        super(map);
    }
    @Override
    protected void drawElements(GUI gui) {
        drawElementGround(gui,new GroundViewer());
        drawElements(gui,getModel().getRocks(), new RockViewer());
        drawElements(gui,getModel().getBushes(), new BushViewer());
        drawElements(gui,getModel().getRiver(), new WaterViewer());
        drawElements(gui,getModel().getPotions(),new PotionViewer());
        drawElements(gui,getModel().getPokeballs(),new PokeballViewer());
        drawElement(gui,getModel().getEnemyTrainer(),new EnemyTrainerViewer());
        drawElementPlayer(gui,getModel().getPlayer(),new PlayerViewer());
        drawElements(gui,getModel().getTallgrass(), new TallGrassViewer());
    }
    private <T extends Terrain> void drawElements(GUI gui, List<T> terrains, TerrainViewer<T> viewer) {
        for (T terrain : terrains){
            drawElement(gui, terrain, viewer);
        }
    }
    private <T extends Terrain> void drawElement(GUI gui, T element, TerrainViewer<T> viewer) {
        viewer.draw(element, gui);
    }
    private void drawElementPlayer(GUI gui, Player player,PlayerViewer playerviewer){
        playerviewer.draw(player, gui);
    }
    private void drawElementGround(GUI gui, GroundViewer groundViewer){
        groundViewer.draw(gui);
    }
}
