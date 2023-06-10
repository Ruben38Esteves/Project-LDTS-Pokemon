package org.example.viewer.game.battle;

import org.example.gui.GUI;
import org.example.model.game.battles.TrainerBattle;
import org.example.viewer.Viewer;

public class TrainerBattleViewer extends Viewer<TrainerBattle> {
    public TrainerBattleViewer(TrainerBattle model){super(model);}
    @Override
    protected void drawElements(GUI gui) {
        gui.drawTrainerBattleMenu(getModel().getCurrentChoice(), getModel().getAttackchoice(), getModel().isAttackmenu(), getModel().getPlayerPokemon(), getModel().getEnemypokemon());
    }
}
