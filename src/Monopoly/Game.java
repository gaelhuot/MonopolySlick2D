package Monopoly;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gagz on 22/03/16.
 */
public class Game {

    public ArrayList<Player> players = new ArrayList<Player>();
    public int toPlay = 0;
    public int nbJoueurs;

    public Map map;

    public boolean inGame = false;

    public Game(int i){
        map = new Map();
        if(i == 2){
            System.out.println(" deux");
            players.add(new Player(0,"char1","player1"));
            players.add(new Player(1,"char2","player2"));
        }
        else if (i == 3){
            System.out.println(" trois");
            players.add(new Player(0,"char1","player1"));
            players.add(new Player(1,"char2","player2"));
            players.add(new Player(2,"char3","player3"));
        }
        else if (i == 4){
            System.out.println(" ada");
            players.add(new Player(0,"char1","player1"));
            players.add(new Player(1,"char2","player2"));
            players.add(new Player(2,"char3","player3"));
            players.add(new Player(3,"char4","player4"));

        }
        else if (i == 5){
            System.out.println(" cinq");
            players.add(new Player(0,"char1","player1"));
            players.add(new Player(1,"char2","player2"));
            players.add(new Player(2,"char3","player3"));
            players.add(new Player(3,"char4","player4"));
            players.add(new Player(4,"char5","player5"));

        }
        else{
            players.add(new Player(0,"char1","player1"));
            players.add(new Player(1,"char2","player2"));
            players.add(new Player(2,"char3","player3"));
            players.add(new Player(3,"char4","player4"));
            players.add(new Player(4,"char5","player5"));
            players.add(new Player(5,"char6","player6"));
        }
    }

    public Player getCurrent(){
        return players.get(toPlay);
    }

    public Player getPlayer(int index){
        return players.get(index);
    }

    public void nextPlayer(){
        getCurrent().played = false;
        if (toPlay + 1 >= players.size())
            toPlay = 0;
        else
            toPlay++;
    }

    public boolean canBuy(){
        boolean canbuy = true;
        if(!map.get_index(getCurrent().Case).isAvailable())
            canbuy = false;

        if(map.get_index(getCurrent().Case).getPlayer() != -1)
            canbuy = false;

        return canbuy;
    }

    public void verifMove(){
        if(getCurrent().Case == 30){
            getCurrent().Case = 10;
            getCurrent().inJail = true;
        }

        if(getCurrent().money <= 0){
            players.remove(toPlay);
        }

        int c = getCurrent().Case;

        /*
        String currentCase = map.get_index(c).getName();
        for (int i = 0; i < players.size(); i++){
            if(players.get(i).searchProperty(map.get_index(c).getName()) != -1){
                int nbC = players.get(i).nbCarteGroup(map.get_index(c).getGroup());
                int paid = 100 * nbC;
                getCurrent().money -= paid;
            }
        }*/

        if(c == 7 || c == 22 || c == 36){
            Random rand = new Random();
            int r = rand.nextInt(3);
            getCurrent().money += r*100;
        }
    }

    public void addPlayer(int id, String figurine, String name){
        players.add(new Player(id, figurine, name));
    }

}
