package org.example.model.game.battles;

import org.example.model.game.Attacks.Attack;
import org.example.model.game.Pokemons.Builder;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.Pokemons.PokemonBuilder;
import org.example.model.game.Pokemons.PokemonDirector;
import org.example.model.game.entities.Player;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Battle {
    private Player player;
    private Pokemon opponent;
    private Pokemon playerPokemon;
    private List<String> attacklist = new ArrayList<>();
    private boolean isplayerfaster;
    private boolean attackmenu=false;
    private int attackchoice = 0;
    private final List<String> options;
    private int currentChoice = 0;
    private boolean battleover=false;
    public Battle(Player player){
        this.player=player;
        this.options = Arrays.asList("Attack","Capture","Run");
        int randnum;
        String pokename = null;
        Random random = new Random();
        randnum = random.nextInt(5);
        switch (randnum){
            case(0):{
                pokename="charmander";
                break;
            }
            case(1):{
                pokename="bulbasaur";
                break;
            }
            case(2):{
                pokename="squirtle";
                break;
            }
            case(3):{
                pokename="pikachu";
                break;
            }
            case(4):{
                pokename="rockruff";
                break;
            }
        }
        PokemonBuilder wildpokemonbuilder = new Builder(pokename);
        PokemonDirector director = new PokemonDirector(wildpokemonbuilder);
        director.makePokemon();
        opponent = director.getPokemon();
        playerPokemon=player.getPokemon(player.getPokemonchoice());
        for(Attack attack:playerPokemon.getattacks()){
            attacklist.add(attack.getName());
        }
        isplayerfaster=playerPokemon.getSPD()>= opponent.getSPD();
    }
    public void startTurn() throws FileNotFoundException, URISyntaxException {
        if(isplayerfaster){
            playerAttack();
            if(!battleover){
                opponentAttack();
            }
        }else{
            opponentAttack();
            if(!battleover){
                playerAttack();
            }
        }
    }
    public void playerAttack() throws FileNotFoundException, URISyntaxException {
        playerPokemon.getattack(attackchoice).dealDMG(playerPokemon,opponent );
        if(opponent.getHP()<=0){
            opponent.setHP(0);
            for(Pokemon pokemon: player.getPokedex()){
                if(pokemon==playerPokemon){
                    player.pokemonLVLup(pokemon);
                }
            }
            battleover=true;
        }
    }
    public void opponentAttack() throws FileNotFoundException, URISyntaxException {
        opponent.getattack(1).dealDMG(opponent, playerPokemon);
        if(playerPokemon.getHP()<=0){
            playerPokemon.setHP(0);
            System.out.println("You lost the battle!");
            battleover=true;
        }
    }
    public Player getPlayer(){
        return player;
    }
    public Pokemon getPlayerPokemon(){
        return playerPokemon;
    }
    public Pokemon getOpponent(){
        return opponent;
    }
    public boolean isBattleover() {
        return battleover;
    }
    //Attack menu
    public boolean toggleAttackMenu(){
        attackmenu=!attackmenu;
        return attackmenu;
    }
    public boolean isAttackmenu(){return attackmenu;}
    public int getAttackchoice(){return attackchoice;}
    public void nextAttackChoice(){
        attackchoice++;
        if(attackchoice==attacklist.size()){
            attackchoice=0;
        }
    }
    public void previousAttackChoice(){
        attackchoice--;
        if(attackchoice==-1){
            attackchoice=attacklist.size()-1;
        }
    }
    //Battle menu
    public int getCurrentChoice() {
        return currentChoice;
    }
    public boolean isSelected(int i) {
        return currentChoice == i;
    }
    public boolean isSelectedAttack() {
        return isSelected(0);
    }
    public boolean isSelectedCapture() {
        return isSelected(1);
    }
    public boolean isSelectedRun() {
        return isSelected(2);
    }
    public void nextChoice() {
        currentChoice++;
        if (currentChoice ==3){
            currentChoice = 0;
        }
    }
    public void previousChoice() {
        currentChoice--;
        if (currentChoice == -1){
            currentChoice = this.options.size() - 1;
        }
    }


}
