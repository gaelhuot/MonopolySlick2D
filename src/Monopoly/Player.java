package Monopoly;

import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * Created by gagz on 04/03/16.
 */
public class Player {
    public int Case;

    public float posX;
    public float posY;

    public float camX;
    public float camY;

    public int money;
    public int last_play = 0;
    public int last_pos;
    public int id;
    public int animID;
    public Figurine figurine;
    public String name;

    public boolean inJail = false;

    public int d;
    public int d2;

    public boolean played;

    public ArrayList<Property> property = new ArrayList<Property>();

    public Player(int i,String figurine, String name){
        this.name = name;
        this.money = GameOptions.default_money;
        this.id = i;
        try {
            this.figurine = new Figurine(figurine);
        } catch (SlickException e) {
            e.printStackTrace();
        }

        Case = 0;

        posX = 2015;
        posY = 2115;

        camX = posX;
        camY = posY;
    }

    public void move(){
        int d = new Dice().getRoll();
        int d2 = new Dice().getRoll();

        int next = d + d2;
        if(d == d2 && inJail) inJail = false;
        if(!inJail) {
            last_pos = Case;
            if (Case + next < 40)
                Case += next;
            else {
                money += 200;
                Case = Case + next - 40;
            }
            this.d = d;
            this.d2 = d2;
            last_play = next;
            played = true;
        }
    }

    public void buy(Property card) {
        money -= card.getValue();
        property.add(card);
    }

    public int searchProperty(String name){
        for (int i = 0; i < property.size(); i++){
            if(property.get(i).getName() == name) return i;
        }
        return -1;
    }

    public int nbCarteGroup(int group){
        int r = 0;
        for (int i = 0; i < property.size(); i++){
            if(property.get(i).getGroup() == group) r++;
        }
        return r;
    }


    public void addMoney(int value){money += value;}

    public void lostMoney(int value){money -= value;}

    public int getNbPropertyFromTheSameGroup(int group){
        int res = 0;
        for(int i = 0; i < property.size(); i++)
            if(property.get(i).getGroup() == group) res++;
        return res;
    }
}
