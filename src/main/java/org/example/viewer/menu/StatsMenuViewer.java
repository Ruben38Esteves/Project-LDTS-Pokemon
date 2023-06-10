package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.StatsMenu;
import org.example.viewer.Viewer;

public class StatsMenuViewer extends Viewer<StatsMenu> {
    public StatsMenuViewer(StatsMenu model) {
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawStats(getModel().getPokemon(),getModel().getChoice());
    }
}
