package org.example.controller.game.battle;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.model.game.battles.TrainerBattle;
import org.example.model.menu.PokedexMenu;
import org.example.state.PokedexState;

import java.io.IOException;
import java.net.URISyntaxException;

public class TrainerBattleController extends Controller<TrainerBattle> {
    public TrainerBattleController(TrainerBattle trainerBattle){super(trainerBattle);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        if(getModel().isAttackmenu()){
            switch (action){
                case DOWN:{
                    getModel().nextAttackChoice();
                    break;
                }
                case UP:{
                    getModel().previousAttackChoice();
                    break;
                }
                case SELECT:{
                    getModel().updatePokemonChoices();
                    getModel().startTurn();
                    if(getModel().isBattleOver()){
                        game.previousState();
                        getModel().getEnemyTrainer().remove();
                    }
                    if(getModel().isChangePlayerPokemon()){
                        getModel().togglechangePlayerPokemon();
                        game.addState(new PokedexState(new PokedexMenu(getModel().getPlayer())));
                    }
                    getModel().updatePokemonChoices();
                    getModel().toggleAttackMenu();
                    break;
                }
                case QUIT:{
                    getModel().toggleAttackMenu();
                    break;
                }
            }
        }else{
            switch(action){
                case RIGHT:{
                    getModel().nextChoice();
                    getModel().updatePokemonChoices();
                    break;
                }
                case LEFT:{
                    getModel().previousChoice();
                    getModel().updatePokemonChoices();
                    break;
                }
                case SELECT:{
                    if(getModel().isSelectedAttack()){
                        getModel().toggleAttackMenu();
                        break;
                    }
                    if(getModel().isSelectedPokedex()){
                        game.addState(new PokedexState(new PokedexMenu(getModel().getPlayer())));
                    }
                    break;
                }
            }
        }

    }
}
