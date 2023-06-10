package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.menu.PokedexMenu;
import org.example.viewer.Viewer;

import javax.swing.text.View;

public class PokedexMenuViewer extends Viewer<PokedexMenu> {
    public PokedexMenuViewer(PokedexMenu pokedexMenu){
        super(pokedexMenu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawPokedex(getModel().getPlayer(),getModel().getCurrentChoice());
    }
}
