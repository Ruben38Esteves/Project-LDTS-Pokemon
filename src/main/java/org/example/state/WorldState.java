package org.example.state;

import org.example.model.game.Map;
import org.example.controller.Controller;
import org.example.controller.game.world.MapController;
import org.example.viewer.Viewer;
import org.example.viewer.game.world.MapViewer;

import java.util.List;

public class WorldState extends State<Map> {
    public WorldState(List<Map> world, int i){super(world.get(i-1));}
    @Override
    protected Viewer<Map> getViewer() {
        return new MapViewer(getModel());
    }
    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }
}
