package org.example.model.game.entities;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Position;
import org.example.model.game.Pokemons.Builder;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Pokemons.PokemonBuilder;
import org.example.model.game.Pokemons.PokemonDirector;
import org.example.model.game.Terrain.Terrain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnemyTrainer extends Terrain {
    private Position position;
    private List<Pokemon> team=new ArrayList<>();
    public EnemyTrainer(Position position, List<String> pokemons){
        for(String name:pokemons){
            PokemonBuilder enemypokemonbuilder = new Builder(name);
            PokemonDirector director = new PokemonDirector(enemypokemonbuilder);
            director.makePokemon();
            team.add(director.getPokemon());
        }
        this.position=position;
    }
    public List<Pokemon> getTeam() {
        return team;
    }
    public Position getPosition() {
        return position;
    }
    public void remove(){this.position.changeTo(new Position(500,500));}
}
