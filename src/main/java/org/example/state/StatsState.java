package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.StatsMenuController;
import org.example.model.menu.StatsMenu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.StatsMenuViewer;

public class StatsState extends State<StatsMenu>{
    public StatsState(StatsMenu model){super(model);}
    @Override
    protected Viewer<StatsMenu> getViewer() {
        return new StatsMenuViewer(getModel());
    }
    @Override
    protected Controller<StatsMenu> getController() {
        return new StatsMenuController(getModel());
    }
}
