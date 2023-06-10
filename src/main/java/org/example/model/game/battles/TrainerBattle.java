package org.example.model.game.battles;

import org.example.model.game.entities.Player;
import org.example.model.game.Pokemons.Pokemon;
import org.example.model.game.entities.EnemyTrainer;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TrainerBattle {
    private Player player;
    private Pokemon playerPokemon;
    private List<String> attacklist = new ArrayList<>();
    private EnemyTrainer enemy;
    private Stack<Pokemon> enemyteam=new Stack<Pokemon>();
    private Pokemon enemypokemon;
    private final List<String> options;
    private boolean TurnOver =false;
    private boolean attackmenu=false;
    private int attackchoice = 0;
    private int currentChoice = 0;
    private boolean changePlayerPokemon=false;
    public TrainerBattle(Player player,EnemyTrainer enemy){
        this.player=player;
        this.enemy=enemy;
        this.options = Arrays.asList("Attack","Pokedex");
        for(Pokemon pokemon:enemy.getTeam()){
            enemyteam.push(pokemon);
        }
        this.playerPokemon=player.getPokemon(player.getPokemonchoice());
        this.enemypokemon=enemyteam.peek();
    }
    public Player getPlayer() {
        return player;
    }
    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }
    public EnemyTrainer getEnemyTrainer(){
        return this.enemy;
    }
    public Pokemon getEnemypokemon() {
        return enemypokemon;
    }

    public void startTurn() throws FileNotFoundException, URISyntaxException {
        TurnOver=false;
        updatePokemonChoices();
        if(isplayerfaster()){
            playerAttack();
            if(!TurnOver){
                opponentAttack();
            }
        }else{
            opponentAttack();
            if(!TurnOver){
                playerAttack();
            }
        }
    }
    public boolean isplayerfaster(){
        return playerPokemon.getSPD() >= enemypokemon.getSPD();
    }
    public void playerAttack() throws FileNotFoundException, URISyntaxException {
        playerPokemon.getattack(attackchoice).dealDMG(playerPokemon,enemypokemon );
        if(enemypokemon.getHP()<=0){
            enemypokemon.setHP(0);
            enemyteam.pop();
            if(enemyteam.size()>0){
                updatePokemonChoices();
            }else{
                toggleBattleOver();
            }
            for(Pokemon pokemon: player.getPokedex()){
                if(pokemon==playerPokemon){
                    player.pokemonLVLup(pokemon);
                }
            }
            TurnOver =true;
        }
    }
    public void opponentAttack() throws FileNotFoundException, URISyntaxException {
        enemypokemon.getattack(1).dealDMG(enemypokemon, playerPokemon);
        if(playerPokemon.getHP()<=0){
            playerPokemon.setHP(0);
            if(playerlost()){
                toggleBattleOver();
            }
            changePlayerPokemon=true;
            TurnOver =true;
        }
    }
    public boolean isBattleOver(){
        if(enemyteam.size()==0||player.lostTheGame()){
            return true;
        }
        return false;
    }
    public void updatePokemonChoices(){
        playerPokemon=player.getPokemon(player.getPokemonchoice());
        if(enemyteam.size()>0)enemypokemon=enemyteam.peek();
    }
    public void toggleBattleOver(){
        TurnOver = !(TurnOver);
    }
    public void togglechangePlayerPokemon(){
        changePlayerPokemon= !(changePlayerPokemon);
    }
    public boolean isChangePlayerPokemon(){
        return changePlayerPokemon;
    }
    //Menu
    public int getCurrentChoice() {
        return currentChoice;
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
    public boolean isSelected(int i) {
        return currentChoice == i;
    }
    public boolean isSelectedAttack() {
        return isSelected(0);
    }
    public boolean isSelectedPokedex() {
        return isSelected(1);
    }

    //Attack Menu
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
    public boolean playerlost(){
        for(Pokemon pokemon: player.getPokedex()){
            if(pokemon.getHP()>0){
                return true;
            }
        }
        return false;
    }
}
