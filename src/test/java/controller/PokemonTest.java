package controller;

import org.example.model.game.Pokemons.Builder;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Pokemons.PokemonBuilder;
import org.example.model.game.Pokemons.PokemonDirector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PokemonTest {

    @BeforeEach
    public void setup(){
        PokemonBuilder testola = new Builder("bulbasaur");
        PokemonDirector director = new PokemonDirector(testola);
        director.makePokemon(); //erro nesta funçao, tentar dps fazer teste
        Pokemon testep = director.getPokemon();
    }
    @Test
    public void testPokemonCreation(){
        PokemonBuilder testola = new Builder("bulbasaur");
        PokemonDirector director = new PokemonDirector(testola);
        director.makePokemon(); //erro nesta funçao, tentar dps fazer teste
        Pokemon testep = director.getPokemon();

        assertEquals(testep.getName(), "bulbasaur");
        testep.setName("teste");
        assertEquals(testep.getName(), "teste");

        assertEquals(testep.getATK(), 5);
        testep.setATK(4);
        assertEquals(testep.getATK(), 4);

        assertEquals(testep.getDEF(), 5);
        testep.setDEF(6);
        assertEquals(testep.getDEF(),6);

        assertEquals(testep.getHP(), 40);
        testep.setHP(60);
        assertEquals(testep.getHP(), 60);

        assertEquals(testep.getSPD(), 4);
        testep.setSPD(7);
        assertEquals(testep.getSPD(), 7);

        assertEquals(testep.getType(), "Grass");
        testep.setType("Fire");
        assertEquals(testep.getType(), "Fire");

    }

    @Test
    public void testPokemonAttack(){
        PokemonBuilder testola = new Builder("bulbasaur");
        PokemonDirector director = new PokemonDirector(testola);
        director.makePokemon(); //erro nesta funçao, tentar dps fazer teste
        Pokemon testep = director.getPokemon();

        assertEquals(testep.getattack(0).getPower(), 6);
        assertEquals(testep.getattack(0).getName(), "tackle");
        assertEquals(testep.getattack(0).getType(), "Normal");
    }
}
