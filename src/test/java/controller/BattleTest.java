package controller;

import org.example.model.game.Attacks.Attack;
import org.example.model.game.Attacks.VineWhip;
import org.example.model.game.Pokemons.Builder;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Pokemons.PokemonBuilder;
import org.example.model.game.Pokemons.PokemonDirector;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTest {

    @Test
    public void battleTest() throws FileNotFoundException, URISyntaxException {
        PokemonBuilder teste = new Builder("bulbasaur");
        PokemonDirector director = new PokemonDirector(teste);
        director.makePokemon();
        Pokemon pokemonTeste = director.getPokemon();

        PokemonBuilder teste2 = new Builder("charmander");
        PokemonDirector director2 = new PokemonDirector(teste2);
        director2.makePokemon();
        Pokemon pokemonTeste2 = director2.getPokemon();


        pokemonTeste.getattack(0).dealDMG(pokemonTeste, pokemonTeste2);
        assertEquals(pokemonTeste2.getHP(), 34);
        pokemonTeste2.getattack(0).dealDMG(pokemonTeste2, pokemonTeste);
        assertEquals(pokemonTeste2.getHP(), 34);
    }
}
