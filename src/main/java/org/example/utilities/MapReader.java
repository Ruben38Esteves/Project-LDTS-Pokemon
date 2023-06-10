package org.example.utilities;

import org.example.model.game.Terrain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;

public class MapReader {
    private List<Rock> rocks= new ArrayList<>();
    private List<Bush> bushes= new ArrayList<>();
    private List<Water> river=new ArrayList<>();
    private List<TallGrass> tallGrasses=new ArrayList<>();
    private List<Pokeball> pokeballs=new ArrayList<>();
    private List<Potion> potions=new ArrayList<>();
    public List<Rock> getRocks() {return rocks;}
    public List<Bush> getBushes() {return bushes;}
    public List<Water> getRiver() {return river;}
    public List<TallGrass> getTallGrasses() {return tallGrasses;}
    public List<Pokeball> getPokeballs() {return pokeballs;}
    public List<Potion> getPotions() {return potions;}
    public MapReader(String location) throws FileNotFoundException, URISyntaxException {
        URL resourceMap = getClass().getResource(location);
        assert resourceMap != null;
        File file =new File(resourceMap.toURI());
        Scanner mapReader = new Scanner(file);

        for(int i=0;i<30;i++){
            String l=mapReader.nextLine();
            for (int j=0;j<30;j++){
                switch (l.charAt(j)){
                    case('R'):{
                        rocks.add(new Rock(j*5,i*5));
                        break;
                    }
                    case('W'):{
                        river.add(new Water(j*5,i*5));
                        break;
                    }
                    case('G'):{
                        tallGrasses.add(new TallGrass(j*5,i*5));
                        break;
                    }
                    case('B'):{
                        bushes.add(new Bush(j*5,i*5));
                        break;
                    }
                    case('O'):{
                        pokeballs.add(new Pokeball(j*5,i*5));
                        break;
                    }
                    case('P'):{
                        potions.add(new Potion(j*5,i*5));
                        break;
                    }
                }
            }
        }

    }
}
