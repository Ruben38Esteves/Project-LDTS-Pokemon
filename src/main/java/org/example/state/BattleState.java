package org.example.state;

import org.example.model.game.battles.Battle;
import org.example.controller.Controller;
import org.example.controller.game.battle.BattleController;
import org.example.viewer.Viewer;
import org.example.viewer.game.battle.BattleViewer;

public class BattleState extends State<Battle>{
    public BattleState(Battle model) {
        super(model);
    }
    @Override
    protected Viewer<Battle> getViewer() {
        return new BattleViewer(getModel());
    }
    @Override
    protected Controller<Battle> getController() {
        return new BattleController(getModel());
    }
}
