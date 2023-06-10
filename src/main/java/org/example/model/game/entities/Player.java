package org.example.model.game.entities;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.game.Pokemons.Builder;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Pokemons.PokemonBuilder;
import org.example.model.game.Pokemons.PokemonDirector;
import org.example.model.Position;

import java.util.*;

public class Player {
    private Position position;
    private Position lastPosition;
    private List<Pokemon> pokedex;
    private int pokemonchoice = 0;
    private int potions=1;
    private int pokeballs=2;
    private HashMap<String,String> evolutions=new HashMap<>();
    private Set<String> uniquepokemon=new HashSet<>();
    public Player(){
        this.position=new Position(5,5);pokedex= new ArrayList<>();
        PokemonBuilder playerpokemon = new Builder("pikachu");
        PokemonDirector director = new PokemonDirector(playerpokemon);
        director.makePokemon();
        Pokemon first = director.getPokemon();
        pokedex.add(first);
        this.lastPosition=new Position(5,0);
        evolutions.put("charmander","charizard");
        evolutions.put("squirtle","blastoise");
        evolutions.put("pikachu","raichu");
        evolutions.put("rockruff","lycanrock");
        evolutions.put("bulbasaur","venasaur");
    }
    public Player(int x1, int y1){
        this.position=new Position(x1,y1);
        pokedex= new ArrayList<>();
        PokemonBuilder playerpokemon = new Builder("pikachu");
        PokemonDirector director = new PokemonDirector(playerpokemon);
        director.makePokemon();
        Pokemon first = director.getPokemon();
        pokedex.add(first);
        this.lastPosition=new Position(x1,y1-5);
        evolutions.put("charmander","charizard");
        evolutions.put("squirtle","blastoise");
        evolutions.put("pikachu","raichu");
        evolutions.put("rockruff","lycanrock");
        evolutions.put("bulbasaur","venasaur");
    }
    public Player(Position position){
        this.position=position;
        pokedex= new ArrayList<>();
        PokemonBuilder playerpokemon = new Builder("pikachu");
        PokemonDirector director = new PokemonDirector(playerpokemon);
        director.makePokemon();
        Pokemon first = director.getPokemon();
        pokedex.add(first);
        this.lastPosition=new Position(position.get_x(), position.get_y()-5);
        evolutions.put("charmander","charizard");
        evolutions.put("squirtle","blastoise");
        evolutions.put("pikachu","raichu");
        evolutions.put("rockruff","lycanrock");
        evolutions.put("bulbasaur","venasaur");
    }
    public Position getPosition(){
        return this.position;
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public Position getLastPosition() {
        return lastPosition;
    }
    public void setLastPosition(Position lastPosition) {
        this.lastPosition = lastPosition;
    }
    public List<Pokemon> getPokedex() {
        return pokedex;
    }
    public Pokemon getPokemon(int n){
        return pokedex.get(n);
    }
    public void capturePokemon(Pokemon pokemon){
        if(pokedex.size()<10){
            pokedex.add(pokemon);
        }
    }
    public int getPokemonchoice() {
        return pokemonchoice;
    }
    public void setPokemonchoice(int pokemonchoice) {
        this.pokemonchoice = pokemonchoice;
    }
    public boolean hasPotions(){
        return potions>0;
    }
    public void usePotion(Pokemon pokemon){
        if(hasPotions()){
            pokemon.setHP(pokemon.getHP()+20);
            if(pokemon.getHP()>pokemon.getMaxHP()){
                pokemon.setHP(pokemon.getMaxHP());
            }
            potions--;
        }
    }
    public void IncreasePotions(){
        potions++;
    }
    public int PotionAmount(){
        return potions;
    }
    public boolean hasPokeballs(){
        return pokeballs>0;
    }
    public void usePokeball(){
        pokeballs--;
    }
    public int PokeballAmount(){
        return pokeballs;
    }
    public void IncreasePokeballs(){
        pokeballs++;
    }
    public boolean canSwim(){
        for(Pokemon pokemon:pokedex){
            if(pokemon.getType()=="Water"){
                return true;
            }
        }
        return false;
    }
    public void evolvePokemon(Pokemon pokemon){
        pokemon.setName(evolutions.get(pokemon.getName()));
    }
    public void pokemonLVLup(Pokemon pokemon){
        pokemon.setLVL(pokemon.getLVL()+1);
        if(pokemon.getLVL()==3){
            evolvePokemon(pokemon);
        }
        pokemon.setMaxHp(pokemon.getMaxHP()+10);
        pokemon.setHP(pokemon.getHP()+10);
        pokemon.setATK(pokemon.getATK()+1);
        pokemon.setDEF(pokemon.getDEF()+1);
        pokemon.setSPD(pokemon.getSPD()+1);
    }
    public boolean lostTheGame(){
        for(Pokemon pokemon:pokedex){
            if(pokemon.getHP()>0){
                return false;
            }
        }
        return(!(potions>0));
    }
    public boolean wonTheGame(){
        for(Pokemon pokemon:pokedex){
            if(pokemon.getLVL()>=5){
                uniquepokemon.add(pokemon.getName());
            }
        }
        return uniquepokemon.size() == 5;
    }
}
