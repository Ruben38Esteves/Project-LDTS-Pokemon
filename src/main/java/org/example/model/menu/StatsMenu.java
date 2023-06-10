package org.example.model.menu;

import org.example.model.game.entities.Player;
import org.example.model.game.Pokemons.Pokemon;

public class StatsMenu {
    private boolean choice = false;
    private int pokemonchoice;
    private Player player;
    private Pokemon pokemon;
    public StatsMenu(Pokemon pokemon, int i, Player player){
        this.pokemon=pokemon;
        this.player=player;
        this.pokemonchoice=i;
    }
    public Pokemon getPokemon() {
        return pokemon;
    }
    public Player getPlayer() {
        return player;
    }
    public int getPokemonchoice() {
        return pokemonchoice;
    }
    public void toggleChoice(){
        choice=!(choice);
    }
    public boolean getChoice(){
        return choice;
    }
}
