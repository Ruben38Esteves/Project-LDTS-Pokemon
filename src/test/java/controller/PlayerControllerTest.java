package controller;

import org.example.model.game.Map;
import org.example.model.game.entities.Player;
import org.example.model.Position;
import org.example.model.game.Terrain.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.controller.game.world.PlayerController;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerControllerTest {

    private Player player;
    private Map map;
    private PlayerController controller;

    @BeforeEach
    void setUp() {
        player=new Player(1,1);
        map=new Map(30,20,player);
        controller=new PlayerController(map);
        map.setRocks(Arrays.asList());
    }


    @Test
    void moveHeroRightEmpty(){ //porque andar uma unidade de posiçao pra direita significa no nosso caso andar 5 unidades
        controller.moveRight();
        assertEquals(new Position(6,1), player.getPosition());
    }

    @Test
    void moveHeroRightNotEmpty(){ //como tem uma rock, nao consegue deslocar-se para a direita
        map.setRocks(Arrays.asList(new Rock(6,1)));
        controller.moveRight();
        assertEquals(new Position(1,1), player.getPosition());
    }
}
