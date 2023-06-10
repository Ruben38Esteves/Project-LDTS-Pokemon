package org.example.state;

import org.example.controller.Controller;
import org.example.controller.game.battle.TrainerBattleController;
import org.example.model.game.battles.TrainerBattle;
import org.example.viewer.Viewer;
import org.example.viewer.game.battle.TrainerBattleViewer;

public class TrainerBattleState extends State<TrainerBattle>{
    public TrainerBattleState(TrainerBattle model){super(model);}
    @Override
    protected Viewer<TrainerBattle> getViewer() {
        return new TrainerBattleViewer(getModel());
    }
    @Override
    protected Controller<TrainerBattle> getController() {
        return new TrainerBattleController(getModel());
    }
}
