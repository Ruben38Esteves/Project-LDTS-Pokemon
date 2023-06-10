package controller;

import org.example.model.game.Map;
import org.example.model.game.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map map;
    private Player player;

    @BeforeEach
    void setUp() throws IOException{
        player= new Player();
        map = new Map(30,40,player);
    }


    @Test
    void constructor(){
        assertEquals(30, map.get_width());
        assertEquals(40, map.get_height());
    }

 /*   @Test
    void testplayermovement(){
        Player mockPlayer = mock(Player.class);
        when(mockPlayer.getPosition()).thenReturn(new Position(2,1));
        when(mockPlayer.moveRight()).thenReturn(new Position(2,1));
        map.movePlayer(mockPlayer.moveRight());
        assertEquals(new Position(2,1),mockPlayer.getPosition());
    }
*/
}
