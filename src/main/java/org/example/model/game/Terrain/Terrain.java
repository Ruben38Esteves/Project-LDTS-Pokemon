package org.example.model.game.Terrain;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Position;

import java.io.IOException;

public abstract class Terrain {
    protected Position position;
    public Terrain(){
        this.position = new Position(1,1);
    }
    public Terrain(int x1,int y1){
        this.position = new Position(x1,y1);
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public Position getPosition(){
        return this.position;
    }

}
