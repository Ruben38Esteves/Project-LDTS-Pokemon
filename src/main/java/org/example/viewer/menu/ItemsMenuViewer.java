package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.menu.ItemsMenu;
import org.example.viewer.Viewer;

import javax.swing.text.View;

public class ItemsMenuViewer extends Viewer<ItemsMenu> {
    public ItemsMenuViewer(ItemsMenu itemsMenu){
        super(itemsMenu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawInventory(getModel().getPlayer());
    }
}
