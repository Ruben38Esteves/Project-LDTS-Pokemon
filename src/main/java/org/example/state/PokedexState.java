package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.PokedexController;
import org.example.model.menu.PokedexMenu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.PokedexMenuViewer;

public class PokedexState extends State<PokedexMenu> {
    public PokedexState(PokedexMenu model){
        super(model);
    }
    @Override
    protected Viewer<PokedexMenu> getViewer() {
        return new PokedexMenuViewer(getModel());
    }
    @Override
    protected Controller<PokedexMenu> getController() {
        return new PokedexController(getModel());
    }
}
