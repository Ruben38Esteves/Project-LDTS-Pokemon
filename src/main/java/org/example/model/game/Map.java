package org.example.model.game;

import org.example.model.Position;
import org.example.model.game.entities.EnemyTrainer;
import org.example.model.game.Terrain.*;
import org.example.model.game.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private Player player;
    public int pixelsize=5;
    public boolean GameOver=false;
    private int width;
    private int height;
    int xrock;
    int yrock;
    private List<Potion> potions=new ArrayList<>();
    public List<Potion> getPotions(){
        return potions;
    }
    private List<Pokeball> pokeballs=new ArrayList<>();
    public List<Pokeball> getPokeballs(){
        return pokeballs;
    }
    private List<Water> river=new ArrayList<>();
    public List<Water> getRiver(){return river;}
    private List<Rock> rocks=new ArrayList<>();
    public List<Rock> getRocks(){
        return rocks;
    }
    private List<Bush> bushes=new ArrayList<>();
    public List<Bush> getBushes(){
        return bushes;
    }
    private List<TallGrass> tallgrass=new ArrayList<>();
    public List<TallGrass> getTallgrass(){
        return tallgrass;
    }
    private EnemyTrainer enemyTrainer;
    public EnemyTrainer getEnemyTrainer() {
        return enemyTrainer;
    }
    public int get_width(){return this.width;}
    public int get_height(){return this.height;}
    public Map(int width1, int height1,Player player){
        this.player = player;
        this.width = width1;
        this.height = height1;
    }
    public Player getPlayer(){
        return player;
    }
    public boolean PokemonBattle() {
        Random random = new Random();
        int encounter = random.nextInt(100);
        if (encounter < 91) {
            return false;
        }
        return true;
    }
    public void movePlayer(Position position){
        if(canplayermove(position)){
            player.setPosition(position);
            for(TallGrass tallGrass:tallgrass){
                if(player.getPosition().equals(tallGrass.getPosition())){
                    Random random = new Random();
                    int encounter = random.nextInt(100);
                    if(encounter>91){
                        PokemonBattle();
                    }
                }
            }
        }
    }
    public boolean isTallGrass(Position position){
        for(TallGrass tallGrass:tallgrass){
            if(player.getPosition().equals(tallGrass.getPosition())){
                return PokemonBattle();
            }
        }
        return false;
    }
    public boolean isNearTrainer(Position position){
        if(player.getPosition().getUp().equals(getEnemyTrainer().getPosition())){
            return true;
        }
        if(player.getPosition().getDown().equals(getEnemyTrainer().getPosition())){
            return true;
        }
        if(player.getPosition().getLeft().equals(getEnemyTrainer().getPosition())){
            return true;
        }
        if(player.getPosition().getRight().equals(getEnemyTrainer().getPosition())){
            return true;
        }
        return false;
    }
    public boolean canplayermove(Position position){
        for(Rock rock:rocks){
            if(rock.getPosition().equals(position)){
                return false;
            }
        }
        for(Bush bush:bushes){
            if(bush.getPosition().equals(position)){
                return false;
            }
        }
        for(Water water:river){
            if(water.getPosition().equals(position)&&(!player.canSwim())){
                return false;
            }
        }
        for(Pokeball pokeball: new ArrayList<Pokeball>(pokeballs)){
            if(pokeball.getPosition().equals(position)){
                pokeballs.remove(pokeball);
                player.IncreasePokeballs();
            }
        }
        for(Potion potion: new ArrayList<Potion>(potions)){
            if(potion.getPosition().equals(position)){
                potions.remove(potion);
                player.IncreasePotions();
            }
        }
        return true;
    }
    public void setRocks(List<Rock> rocks) {
        this.rocks = rocks;
    }
    public void setBushes(List<Bush> bushes) {
        this.bushes = bushes;
    }
    public void setTallgrass(List<TallGrass> tallgrass) {
        this.tallgrass = tallgrass;
    }
    public void setRiver(List<Water> river){
        this.river = river;
    }
    public void setPokeballs(List<Pokeball> pokeballs) {
        this.pokeballs = pokeballs;
    }
    public void setPotions(List<Potion> potions){
        this.potions=potions;
    }
    public void setEnemyTrainer(Position position, List<String> team) {
        this.enemyTrainer=new EnemyTrainer(position,team);
    }

}
