package org.example.controller.game.world;

import org.example.model.game.Map;
import org.example.controller.Controller;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map) {
        super(map);
    }
}
