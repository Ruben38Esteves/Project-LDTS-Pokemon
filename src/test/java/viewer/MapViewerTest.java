package viewer;

import org.example.model.game.Map;
import org.example.model.game.entities.Player;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.Terrain.*;
import org.example.viewer.game.world.MapViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class MapViewerTest {
    private GUI gui;
    private MapViewer viewer;
    private Map map;
    private Player player;

    @BeforeEach
    void setup(){
        player = new Player(10,10);
        map = new Map(30,30,player);
        gui= Mockito.mock(GUI.class);
        viewer=new MapViewer(map);

        map.setBushes(Arrays.asList(new Bush(1,2), new Bush(2,4), new Bush(4,5)));
        map.setPokeballs(Arrays.asList(new Pokeball(3,4), new Pokeball(8,5)));
        map.setPotions(Arrays.asList(new Potion(2,2), new Potion(10,10)));
        map.setRiver(Arrays.asList(new Water(1,1), new Water(5,6), new Water(6,6)));
        map.setRocks(Arrays.asList(new Rock(12,12), new Rock(12,13)));
        map.setTallgrass(Arrays.asList(new TallGrass(15,15), new TallGrass(15,16)));
        map.setEnemyTrainer(new Position(1,2), Arrays.asList("team"));
    }
/*
    @Test  nao funciona, tem uma maneira diferente de desnhar
    void drawBushes() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBush(new Position(1,2), new Bush(1,2));
        Mockito.verify(gui, Mockito.times(1)).drawBush(new Position(2,4), new Bush(2,4));
        Mockito.verify(gui, Mockito.times(1)).drawBush(new Position(4,5), new Bush(4,5));
    }*/

    @Test
    void drawPotions() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui,Mockito.times(1)).drawPotion(new Position(2,2));
        Mockito.verify(gui,Mockito.times(1)).drawPotion(new Position(10,10));
        Mockito.verify(gui,Mockito.times(2)).drawPotion(Mockito.any(Position.class));
    }

    @Test
    void drawEnemyTrainer() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemyTrainer(new Position(1,2));
    }

    @Test
    void drawPokeballs() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPokeball(new Position(3,4));
        Mockito.verify(gui, Mockito.times(1)).drawPokeball(new Position(8,5));
        Mockito.verify(gui,Mockito.times(2)).drawPokeball(Mockito.any(Position.class));
    }

    @Test
    void drawRiver() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWater(new Position(1,1));
        Mockito.verify(gui, Mockito.times(1)).drawWater(new Position(5,6));
        Mockito.verify(gui, Mockito.times(1)).drawWater(new Position(6,6));
    }

    /*@Test //nao funciona, tem uma maneira diferente de desenhar
    void drawRocks() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawRock(new Position(12,12), drawRocks());
        Mockito.verify(gui, Mockito.times(1)).drawRock(new Position(12,12), new Rock(12,13));
    }*/

    @Test
    void drawTallGrass() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawTallGrass(new Position(15,15));
        Mockito.verify(gui, Mockito.times(1)).drawTallGrass(new Position(15,16));
        Mockito.verify(gui,Mockito.times(2)).drawTallGrass(Mockito.any(Position.class));
    }
}
