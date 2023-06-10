package org.example.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class TypeCalculator {
    private HashMap<String,Integer> typetranslater = new HashMap<String, Integer>();
    private int typeAtk;
    private int typeDef;
    public TypeCalculator(String atktype, String deftype){
        typetranslater.put("Normal",0 );
        typetranslater.put("Grass", 1);
        typetranslater.put("Water", 2);
        typetranslater.put("Fire", 3);
        typetranslater.put("Electric",4);
        typetranslater.put("Rock",5);
        typeAtk=typetranslater.get(atktype);
        typeDef=typetranslater.get(deftype);
    }
    public float multCalculator() throws URISyntaxException, FileNotFoundException {
        int x=0;
        int y=0;
        URL resourceTypechart = getClass().getResource("/typechart.txt");
        assert resourceTypechart != null;
        File file = new File(resourceTypechart.toURI());
        Scanner typeReader = new Scanner(file);

        String l =typeReader.nextLine();
        for(int i=1;i<11;i++){
            if(Character.getNumericValue(l.charAt(i))==typeAtk){
                x=i;
                System.out.println(x);
                break;
            }
        }
        int j=1;
        while(typeReader.hasNextLine()) {
            l = typeReader.nextLine();
            if(Character.getNumericValue(l.charAt(0))==typeDef){
                y=j;
                System.out.println(y);
                break;
            }
            j++;
        }
        Scanner typeReader2 = new Scanner(file);
        String l2 = "";
        while(typeReader2.hasNextLine()){
            for(int k=0;k<=y;k++){
                l2 = typeReader2.nextLine();
            }
            switch (l2.charAt(x)){
                case('S'):{
                    return 2;
                }
                case('N'):{
                    return 1;
                }
                case('W'):{
                    return 0.5F;
                }
            }
        }
        return 100000;
    }
}
