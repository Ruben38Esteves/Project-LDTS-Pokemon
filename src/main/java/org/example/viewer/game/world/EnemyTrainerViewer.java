package org.example.viewer.game.world;

import org.example.gui.GUI;
import org.example.model.game.entities.EnemyTrainer;

public class EnemyTrainerViewer implements TerrainViewer<EnemyTrainer>{
    public void draw(EnemyTrainer terrain, GUI gui) {
        gui.drawEnemyTrainer(terrain.getPosition());
    }
}
