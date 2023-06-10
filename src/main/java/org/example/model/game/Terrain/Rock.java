package org.example.model.game.Terrain;

import org.example.utilities.TestPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rock extends Terrain {
    List<TestPair> pixels = new ArrayList<>();
    public Rock(int x1, int y1){
        super(x1,y1);
        Random random = new Random();
        for(int i = 0;i<10;i++){
            int x = random.nextInt(5);
            int y = random.nextInt(5);
            TestPair testpair = new TestPair(x,y);
            pixels.add(testpair);
        }
    }
    public List<TestPair> getPixels(){
        return pixels;
    }
}
