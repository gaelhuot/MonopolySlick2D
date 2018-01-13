package Monopoly;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by gagz on 22/03/16.
 */

public class Button {
    public Image def;
    public Image hover;
    public Image click;
    public int posx;
    public int posy;

    public Button(String name, int posx, int posy) throws SlickException {
        this.def = new Image("ressources/HUD/"+ name +".png");
        this.hover = new Image("ressources/HUD/"+ name +"_hover.png");

        this.posx = posx;
        this.posy = posy;
    }
}
