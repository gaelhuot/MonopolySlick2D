package Monopoly;

public class Property {
    private String name;
    private int value;
    private boolean available;
    private int player;
    private int group;

    public Property() {
        this.player = -1;
    }

    public Property Available(boolean b) {
        available = b;
        return this;
    }
    public Property Value(int val) {
        value = val;
        return this;
    }
    public Property Name(String sname) {
        name = sname;
        return this;
    }
    public Property Group(int sgroup) {
        group = sgroup;
        return this;
    }

    //setters
    public void setAvailable(boolean b) {
        available = b;
    }
    public void setPlayer(int splayer) {
        player = splayer;
    }
    public void setGroup(int sgroup) {
        group = sgroup;
    }

    //getters
    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
    public boolean isAvailable() {
        return available;
    }
    public int getPlayer() {
        return player;
    }
    public int getGroup() {
        return group;
    }
}