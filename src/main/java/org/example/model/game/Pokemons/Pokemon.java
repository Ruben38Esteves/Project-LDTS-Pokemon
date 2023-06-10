package org.example.model.game.Pokemons;

import org.example.model.game.Attacks.Attack;

import java.util.ArrayList;
import java.util.List;

public class Pokemon implements PokemonPlan {
    private String Name;
    private String type;
    private int LVL;
    private int HP;
    private int MaxHP;
    private int ATK;
    private int DEF;
    private int SPD;
    private List<Attack> attacks = new ArrayList<>();
    public void levelUP(){
        LVL++;
        HP+=10;
        MaxHP+=10;
        ATK++;
        DEF++;
        SPD++;
    }
    public String getName(){return this.Name;}
    public int getHP() {return this.HP;}
    public int getLVL() {return this.LVL;}
    public int getMaxHP(){return this.MaxHP;}
    public int getATK() {return this.ATK;}
    public int getDEF() {return this.DEF;}
    public int getSPD() { return this.SPD; }
    public String getType() { return this.type; }
    public Attack getattack(int n){return this.attacks.get(n);}
    public List<Attack> getattacks(){return this.attacks;}
    @Override
    public void setName(String Name) {this.Name=Name;}
    @Override
    public void setHP(int HP) { this.HP = HP; }
    @Override
    public void setLVL(int LVL) {this.LVL=LVL;}
    @Override
    public void setMaxHp(int HP) {
        this.MaxHP=HP;
    }
    @Override
    public void setATK(int ATK) { this.ATK = ATK; }
    @Override
    public void setDEF(int DEF) { this.DEF = DEF; }
    @Override
    public void setSPD(int SPD) { this.SPD = SPD; }
    @Override
    public void setType(String type){ this.type=type; }
    @Override
    public void addattack(List<Attack> attacks) { this.attacks=attacks; }
}
