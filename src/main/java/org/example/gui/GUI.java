package org.example.gui;

import org.example.model.game.entities.Player;
import org.example.model.Position;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Terrain.Bush;
import org.example.model.game.Terrain.Rock;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void drawGround();
    void drawPlayer(Player player);
    void drawBush(Position position, Bush bush);
    void drawRock(Position position, Rock rock);
    void drawTallGrass(Position position);
    void drawWater(Position position);
    void drawPotion(Position position);
    void drawPokeball(Position position);
    void drawText(String s, int x, int y,String color);
    void drawEnemyTrainer(Position position);
    void drawMenuText(int i);
    void drawBattleMenu(int i,int j, boolean x, Pokemon playerpokemon, Pokemon opponent);
    void drawTrainerBattleMenu(int i,int j,boolean x,Pokemon playerpokemon, Pokemon opponent);
    void drawPokedex(Player player,int j);
    void drawStats(Pokemon pokemon,boolean choice);
    void drawInventory(Player player);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    enum ACTION{UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, BATTLE, POKEDEX,INVENTORY};
}

