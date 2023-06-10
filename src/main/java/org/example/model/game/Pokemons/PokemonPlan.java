package org.example.model.game.Pokemons;

import org.example.model.game.Attacks.Attack;

import java.util.List;

public interface PokemonPlan {
    public void setName(String Name);
    public void setHP(int HP);
    public void setLVL(int LVL);
    public void setMaxHp(int HP);
    public void setATK(int ATK);
    public void setDEF(int DEF);
    public void setSPD(int SPD);
    public void setType(String type);
    public void addattack(List<Attack> attacks);
}
