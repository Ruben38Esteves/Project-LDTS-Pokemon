package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.ItemsMenuController;
import org.example.model.menu.ItemsMenu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.ItemsMenuViewer;

public class InventoryState extends State<ItemsMenu> {
    public InventoryState(ItemsMenu model){
        super(model);
    }
    @Override
    protected Viewer<ItemsMenu> getViewer() {
        return new ItemsMenuViewer(getModel());
    }
    @Override
    protected Controller<ItemsMenu> getController() {
        return new ItemsMenuController(getModel());
    }
}
