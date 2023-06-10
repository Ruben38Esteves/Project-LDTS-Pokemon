package org.example.controller.game.battle;

import org.example.model.game.battles.Battle;
import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;

import java.io.IOException;
import java.net.URISyntaxException;

public class BattleController extends Controller<Battle> {
    public BattleController(Battle battle) {
        super(battle);
    }

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
                    getModel().startTurn();
                    if(getModel().isBattleover()){
                        if(getModel().getPlayer().lostTheGame()){
                            game.previousState();
                            game.previousState();
                        }
                        game.previousState();
                    }
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
                    break;
                }
                case LEFT:{
                    getModel().previousChoice();
                    break;
                }
                case SELECT:{
                    if(getModel().isSelectedAttack()){
                        getModel().toggleAttackMenu();
                    }
                    if(getModel().isSelectedCapture()){
                        if(getModel().getPlayer().hasPokeballs()){
                            getModel().getPlayer().capturePokemon(getModel().getOpponent());
                            getModel().getPlayer().usePokeball();
                            if(getModel().getPlayer().wonTheGame()){
                                System.out.println("YOU WON THE GAME");
                                game.previousState();
                                game.previousState();
                            }else{
                                game.previousState();
                            }
                        }
                    }
                    if(getModel().isSelectedRun()){
                        game.previousState();
                    }
                    break;
                }
                case QUIT:{
                    game.previousState();
                    game.previousState();
                    break;
                }
            }
        }

    }
}
