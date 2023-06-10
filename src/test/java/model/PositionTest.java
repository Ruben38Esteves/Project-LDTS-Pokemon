package model;

import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    private Position position;


    @BeforeEach
    void setUp(){
        position = new Position(1,1);
    }


    @Test
    void equals(){
        assertTrue(position.equals(new Position(1,1)));
    }

   @Test
    void positionLeft(){
        assertEquals(position.getLeft(), new Position(-4,1));
    }

    @Test
    void positionRight(){
        assertEquals(position.getRight(), new Position(6,1));
    }

    @Test
    void positionUp(){
        assertEquals(position.getUp(), new Position(1,-4));
    }

    @Test
    void positionDown(){
        assertEquals(position.getDown(), new Position(1,6));
    }
}


