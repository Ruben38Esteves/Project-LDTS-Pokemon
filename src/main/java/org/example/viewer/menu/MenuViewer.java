package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu){
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawMenuText(getModel().getCurrentChoice());
    }

}
