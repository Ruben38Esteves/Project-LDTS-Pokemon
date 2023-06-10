package viewer;

import org.example.model.game.entities.Player;
import org.example.gui.GUI;
import org.example.viewer.game.world.PlayerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayerViewerTest {
    private Player player;
    private GUI gui;
    private PlayerViewer viewer;

    @BeforeEach
    void setup(){
        player=new Player(10,10);
        viewer=new PlayerViewer();
        gui= Mockito.mock(GUI.class);
    }

    @Test
    void drawPlayer(){
        viewer.draw(player, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(player);
    }
}
