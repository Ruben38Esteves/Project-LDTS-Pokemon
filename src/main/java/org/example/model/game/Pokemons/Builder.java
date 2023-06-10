package org.example.model.game.Pokemons;

import org.example.model.game.Attacks.*;

import java.util.ArrayList;
import java.util.List;

public class Builder implements PokemonBuilder {
    String Name;
    int lvl;
    int hp;
    int atk;
    int def;
    int spd;
    String type;
    List<Attack> attacks=new ArrayList<>();
    private Pokemon pokemon;
    public Builder(String Name){
        this.pokemon=new Pokemon();
        this.Name=Name;
        switch (Name){
            case("charmander"):{
                lvl = 1;
                hp = 40;
                atk = 5;
                def = 5;
                spd = 6;
                type = "Fire";
                attacks.add(new Tackle());
                attacks.add(new Ember());
                attacks.add(new Thundershock());
                break;
            }
            case("bulbasaur"):{
                lvl = 1;
                hp = 40;
                atk = 5;
                def = 5;
                spd = 4;
                type = "Grass";
                attacks.add(new Tackle());
                attacks.add(new VineWhip());
                attacks.add(new WaterGun());
                break;
            }
            case("squirtle"):{
                lvl = 1;
                hp = 44;
                atk = 5;
                def = 6;
                spd = 4;
                type = "Water";
                attacks.add(new Tackle());
                attacks.add(new WaterGun());
                attacks.add(new RockTomb());
                break;
            }
            case("pikachu"):{
                lvl = 1;
                hp = 35;
                atk = 5;
                def = 5;
                spd = 9;
                type = "Electric";
                attacks.add(new Tackle());
                attacks.add(new Thundershock());
                attacks.add(new WaterGun());
                break;
            }
            case("rockruff"):{
                lvl = 1;
                hp = 45;
                atk = 7;
                def = 4;
                spd = 6;
                type = "Rock";
                attacks.add(new Tackle());
                attacks.add(new RockTomb());
                attacks.add(new Ember());
                break;
            }
        }
    }
    @Override
    public void buildName(){pokemon.setName(Name);}
    @Override
    public void buildHP() {pokemon.setHP(hp);}
    @Override
    public void buildMaxHP() {pokemon.setMaxHp(hp);}
    @Override
    public void buildATK() {pokemon.setATK(atk);}
    @Override
    public void buildDEF() {pokemon.setDEF(def);}
    @Override
    public void buildSPD() {pokemon.setSPD(spd);}
    @Override
    public void buildType() {pokemon.setType(type);}
    @Override
    public void buildLVL() {pokemon.setLVL(lvl);}
    @Override
    public void buildAttacks(){pokemon.addattack(attacks);}
    public Pokemon getPokemon(){
        return this.pokemon;
    }
}
