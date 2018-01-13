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

        if (res == -1){
            System.out.println(x + "--" + y);
        }
        return res;
    }

}
