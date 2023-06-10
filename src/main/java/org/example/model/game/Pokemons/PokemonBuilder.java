package org.example.model.game.Pokemons;

public interface PokemonBuilder {
    public void buildName();
    public void buildType();
    public void buildLVL();
    public void buildHP();
    public void buildMaxHP();
    public void buildATK();
    public void buildDEF();
    public void buildSPD();
    public void buildAttacks();
    public Pokemon getPokemon();
}
