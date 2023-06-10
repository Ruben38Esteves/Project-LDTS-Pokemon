package org.example.model.game.Attacks;

import org.example.utilities.TypeCalculator;
import org.example.model.game.Pokemons.Pokemon;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public abstract class Attack {
    private String Name;
    private String type;
    private int power;
    public Attack(){
        this.Name="Tackle";
        this.type="Normal";
        this.power=5;
    }
    public Attack(String Name,String type,int power){
        this.Name=Name;
        this.type=type;
        this.power=power;
    }
    public String getName(){return this.Name;}
    public String getType(){return this.type;}
    public int getPower(){return this.power;}
    public void dealDMG(Pokemon attacker,Pokemon target) throws FileNotFoundException, URISyntaxException {
        float dmg;
        TypeCalculator calc= new TypeCalculator(this.type, target.getType());
        float mult = calc.multCalculator();
        dmg= (mult*((this.power) + attacker.getATK() - target.getDEF()));
        target.setHP((int) (target.getHP()-dmg));
    }
}
