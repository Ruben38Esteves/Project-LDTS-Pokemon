package org.example.model.menu;

import org.example.model.game.entities.Player;
import org.example.model.game.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokedexMenu {
    private final List<String> options =new ArrayList<>();
    private int currentChoice = 0;
    private Player player;
    public PokedexMenu(Player player){
        for(Pokemon pokemon: player.getPokedex()){
            options.add(pokemon.getName());
        }
        this.player=player;
    }
    public void nextChoice() {
        currentChoice++;
        if (currentChoice ==this.options.size()){
            currentChoice = 0;
        }
    }
    public void previousChoice() {
        currentChoice--;
        if (currentChoice == -1){
            currentChoice = this.options.size() - 1;
        }
    }
    public int getCurrentChoice(){
        return currentChoice;
    }
    public Player getPlayer() {
        return player;
    }
}
