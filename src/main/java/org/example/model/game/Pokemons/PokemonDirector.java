package org.example.model.game.Pokemons;

public class PokemonDirector {
    private PokemonBuilder pokemonbuilder;
    public PokemonDirector(PokemonBuilder pokemonbuilder){
        this.pokemonbuilder=pokemonbuilder;
    }
    public Pokemon getPokemon(){
        return this.pokemonbuilder.getPokemon();
    }
    public void makePokemon(){
        this.pokemonbuilder.buildLVL();
        this.pokemonbuilder.buildHP();
        this.pokemonbuilder.buildMaxHP();
        this.pokemonbuilder.buildATK();
        this.pokemonbuilder.buildDEF();
        this.pokemonbuilder.buildSPD();
        this.pokemonbuilder.buildType();
        this.pokemonbuilder.buildAttacks();
        this.pokemonbuilder.buildName();
    }
}
