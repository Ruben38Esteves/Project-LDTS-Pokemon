package org.example.viewer.game.battle;

import org.example.model.game.battles.Battle;
import org.example.gui.GUI;
import org.example.viewer.Viewer;

public class BattleViewer extends Viewer<Battle> {
    public BattleViewer(Battle battle) {
        super(battle);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawBattleMenu(getModel().getCurrentChoice(),getModel().getAttackchoice(),getModel().isAttackmenu(), getModel().getPlayerPokemon(), getModel().getOpponent());
    }
}
