package org.example.model.menu;

import org.example.model.game.Map;
import org.example.utilities.MapReader;
import org.example.model.game.entities.Player;
import org.example.model.Position;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int currentChoice = 0;
    private Player player=new Player(75,75);
    private int currentworld =1;
    private Map map1 = new Map(150,150,player);
    private Map map2 = new Map(150,150,player);
    private Map map3 = new Map(150,150,player);
    private Map map4 = new Map(150,150,player);
    private Map map5 = new Map(150,150,player);
    private List<String> team = new ArrayList<>();
    private List<Map> world = new ArrayList<>();
    public int getCurrentChoice() {
        return currentChoice;
    }
    public Menu() throws FileNotFoundException, URISyntaxException {
        this.options = Arrays.asList("Exit","Help","Start Game");

        MapReader mapreader=new MapReader("/map1.txt");
        map1.setRocks(mapreader.getRocks());
        map1.setTallgrass(mapreader.getTallGrasses());
        map1.setBushes(mapreader.getBushes());
        map1.setRiver(mapreader.getRiver());
        map1.setPotions(mapreader.getPotions());
        map1.setPokeballs(mapreader.getPokeballs());
        team= Arrays.asList("squirtle","charmander");
        map1.setEnemyTrainer(new Position(55,40),team);
        world.add(map1);

        mapreader=new MapReader("/map2.txt");
        map2.setRocks(mapreader.getRocks());
        map2.setTallgrass(mapreader.getTallGrasses());
        map2.setBushes(mapreader.getBushes());
        map2.setRiver(mapreader.getRiver());
        map2.setPotions(mapreader.getPotions());
        map2.setPokeballs(mapreader.getPokeballs());
        team= Arrays.asList("pikachu","rockruff");
        map2.setEnemyTrainer(new Position(65,35),team);
        world.add(map2);

        mapreader=new MapReader("/map3.txt");
        map3.setRocks(mapreader.getRocks());
        map3.setTallgrass(mapreader.getTallGrasses());
        map3.setBushes(mapreader.getBushes());
        map3.setRiver(mapreader.getRiver());
        map3.setPotions(mapreader.getPotions());
        map3.setPokeballs(mapreader.getPokeballs());
        team= Arrays.asList("bulbasaur","charmander");
        map3.setEnemyTrainer(new Position(115,20),team);
        world.add(map3);

        mapreader=new MapReader("/map4.txt");
        map4.setRocks(mapreader.getRocks());
        map4.setTallgrass(mapreader.getTallGrasses());
        map4.setBushes(mapreader.getBushes());
        map4.setRiver(mapreader.getRiver());
        map4.setPotions(mapreader.getPotions());
        map4.setPokeballs(mapreader.getPokeballs());
        team= Arrays.asList("squirtle","pikachu");
        map4.setEnemyTrainer(new Position(125,40),team);
        world.add(map4);

        mapreader=new MapReader("/map5.txt");
        map5.setRocks(mapreader.getRocks());
        map5.setTallgrass(mapreader.getTallGrasses());
        map5.setBushes(mapreader.getBushes());
        map5.setRiver(mapreader.getRiver());
        map5.setPotions(mapreader.getPotions());
        map5.setPokeballs(mapreader.getPokeballs());
        team= Arrays.asList("bulbasaur","rockruff");
        map5.setEnemyTrainer(new Position(80,35),team);
        world.add(map5);
    }
    public Player getPlayer() {
        return player;
    }
    public Map getMap(int i){
        return world.get(i-1);
    }
    public List<Map> getWorld(){return this.world;}
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
    public boolean isSelectedStartGame() {
        return isSelected(0);
    }
    public boolean isSelectedHelp() {
        return isSelected(1);
    }
    public boolean isSelectedExit(){
        return isSelected(2);
    }
    public int getNumberEntries() {
        return this.options.size();
    }
    public int getCurrentworld() {
        return currentworld;
    }
    public void setCurrentworld(int currentworld) {
        this.currentworld = currentworld;
    }
}
