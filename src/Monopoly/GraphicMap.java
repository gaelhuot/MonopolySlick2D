package Monopoly;

import org.newdawn.slick.Color;

/**
 * Created by gagz on 22/03/16.
 */
public class GraphicMap {

    public int getCase(float x, float y) {
        if (y >= 2035 && y <= 2200 && x <= 1935 && x >= 1015) {
            return bottomRow(x);
        }

        if (y >= 950 && y <= 1115 && x <= 1935 && x >= 1015) {
            return topRow(x);
        }

        if (x >= 850 && x <= 1015 && y <= 2035 && y >= 1115){
            return leftRow(y);
        }

        if (x >= 1935 && x <= 2100 && y >= 1115 && y <= 2035){
            return rightRow(y);
        }

        return special(x, y);
    }

    public int bottomRow(float x){
        int getCase = (int) (1935-x)/102;
        int res = 1+getCase;

        if(res >= 9)
            return 9;
        return res;
    }

    public int topRow(float x){
        int getCase = (int) (1935-x)/102;
        int res = 29 - (getCase);

        if(res >= 29)
            res = 29;

        return res;
    }

    public int leftRow(float y){
        int getCase = (int) (2035-y)/102;
        int res = 11+getCase;

        if (res >= 19 )
            res = 19;

        return res;
    }

    public int rightRow(float y){
        int getCase = (int) (2035-y)/102;
        int res = 39-getCase;

        if (res >= 39 )
            res = 39;

        return res;
    }

    public int special(float x, float y){
        int res = -1;

        if (x >= 1935 && x <= 2100 && y >= 2035 && y <= 2200)
            res = 0;

        if (x >= 850 && x <= 1015 && y >= 2035 && y <= 2200)
            res = 10;

        if (x >= 850 && x <= 1015 && y >= 950 && y <= 1115)
            res = 20;

        if ( x >= 1935 && x <= 2100 && y >= 950 && y <= 1115)
            res = 30;

        return res;
    }

    public Color getColor(int group){
        final int BROWN = 1;
        final int LIGHT_BLUE = 2;
        final int PURPLE = 3;
        final int ORANGE = 4;
        final int RED = 5;
        final int YELLOW = 6;
        final int GREEN = 7;
        final int BLUE = 8;
        final int PUBLIC = 9;
        final int GARE = 10;
        final int NON_ACHETABLE = 11;

        if(group==1) return new Color(153,76,0);
        else if(group==2) return Color.cyan;
        else if(group==3) return new Color(102,0,102);
        else if(group==4) return Color.orange;
        else if(group==5) return Color.red;
        else if(group==6) return Color.yellow;
        else if(group==7) return Color.gray;
        else if(group==8) return Color.blue;
        else if(group==9) return Color.gray;
        else if(group==10) return Color.black;
        else if(group==11) return Color.white;
        else return Color.white;
    }
}
