package org.example.controller.game.world;

import org.example.model.game.battles.Battle;
import org.example.Game;
import org.example.model.game.Map;
import org.example.model.Position;
import org.example.gui.GUI;
import org.example.model.game.battles.TrainerBattle;
import org.example.state.BattleState;
import org.example.state.TrainerBattleState;
import org.example.state.WorldState;

import java.io.IOException;

public class PlayerController extends GameController {

    public PlayerController(Map map) {
        super(map);
    }

    public void moveUp(){
        movePLayer(getModel().getPlayer().getPosition().getUp());
    }
    public void moveDown(){
        movePLayer(getModel().getPlayer().getPosition().getDown());
    }
    public void moveLeft(){
        movePLayer(getModel().getPlayer().getPosition().getLeft());
    }
    public void moveRight(){
        movePLayer(getModel().getPlayer().getPosition().getRight());
    }

    private void movePLayer(Position position){
        if(getModel().canplayermove(position)){
            getModel().getPlayer().setLastPosition(getModel().getPlayer().getPosition());
            getModel().getPlayer().setPosition(position);
        }
        if(getModel().isTallGrass(position)){
            getModel().PokemonBattle();
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action){
            case UP:{
                moveUp();
                if(getModel().isTallGrass(getModel().getPlayer().getPosition())){
                    game.addState(new BattleState(new Battle(getModel().getPlayer())));
                }
                if(getModel().isNearTrainer(getModel().getPlayer().getPosition())){
                    game.addState(new TrainerBattleState(new TrainerBattle(getModel().getPlayer(),getModel().getEnemyTrainer())));
                }
                if(getModel().getPlayer().getPosition().get_y()<0){
                    if(game.getMenu().getCurrentworld()==1){
                        getModel().getPlayer().getPosition().set_y(140);
                        getModel().getPlayer().getLastPosition().set_y(145);
                        game.previousState();
                        game.getMenu().setCurrentworld(5);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    } else if (game.getMenu().getCurrentworld()==3) {
                        getModel().getPlayer().getPosition().set_y(140);
                        getModel().getPlayer().getLastPosition().set_y(145);
                        game.previousState();
                        game.getMenu().setCurrentworld(1);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    }
                }
                break;
            }
            case RIGHT:{
                moveRight();
                if(getModel().isTallGrass(getModel().getPlayer().getPosition())){
                    game.addState(new BattleState(new Battle(getModel().getPlayer())));
                }
                if(getModel().isNearTrainer(getModel().getPlayer().getPosition())){
                    game.addState(new TrainerBattleState(new TrainerBattle(getModel().getPlayer(),getModel().getEnemyTrainer())));
                }
                if(getModel().getPlayer().getPosition().get_x()>145){
                    if(game.getMenu().getCurrentworld()==1){
                        getModel().getPlayer().getPosition().set_x(5);
                        getModel().getPlayer().getLastPosition().set_x(0);
                        game.previousState();
                        game.getMenu().setCurrentworld(2);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    } else if (game.getMenu().getCurrentworld()==4) {
                        getModel().getPlayer().getPosition().set_x(5);
                        getModel().getPlayer().getLastPosition().set_x(0);
                        game.previousState();
                        game.getMenu().setCurrentworld(1);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    }
                }
                break;
            }
            case DOWN:{
                moveDown();
                if(getModel().isTallGrass(getModel().getPlayer().getPosition())){
                    game.addState(new BattleState(new Battle(getModel().getPlayer())));
                }
                if(getModel().isNearTrainer(getModel().getPlayer().getPosition())){
                    game.addState(new TrainerBattleState(new TrainerBattle(getModel().getPlayer(),getModel().getEnemyTrainer())));
                }
                if(getModel().getPlayer().getPosition().get_y()>145){
                    if(game.getMenu().getCurrentworld()==1){
                        getModel().getPlayer().getPosition().set_y(5);
                        getModel().getPlayer().getLastPosition().set_y(0);
                        game.previousState();
                        game.getMenu().setCurrentworld(3);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    } else if (game.getMenu().getCurrentworld()==5) {
                        getModel().getPlayer().getPosition().set_y(5);
                        getModel().getPlayer().getLastPosition().set_y(0);
                        game.previousState();
                        game.getMenu().setCurrentworld(1);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    }
                }
                break;
            }
            case LEFT:{
                moveLeft();
                if(getModel().isTallGrass(getModel().getPlayer().getPosition())){
                    game.addState(new BattleState(new Battle(getModel().getPlayer())));
                }
                if(getModel().isNearTrainer(getModel().getPlayer().getPosition())){
                    game.addState(new TrainerBattleState(new TrainerBattle(getModel().getPlayer(),getModel().getEnemyTrainer())));
                }
                if(getModel().getPlayer().getPosition().get_x()<0){
                    if(game.getMenu().getCurrentworld()==1){
                        getModel().getPlayer().getPosition().set_x(140);
                        getModel().getPlayer().getLastPosition().set_x(145);
                        game.previousState();
                        game.getMenu().setCurrentworld(4);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    } else if (game.getMenu().getCurrentworld()==2) {
                        getModel().getPlayer().getPosition().set_x(140);
                        getModel().getPlayer().getLastPosition().set_x(145);
                        game.previousState();
                        game.getMenu().setCurrentworld(1);
                        game.addState(new WorldState(game.getMenu().getWorld(),game.getMenu().getCurrentworld()));
                    }
                }
                break;
            }
        }
    }
}
