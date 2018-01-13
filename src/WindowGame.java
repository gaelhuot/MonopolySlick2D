import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;
import java.util.ArrayList;

public class WindowGame extends BasicGame {
    GameContainer container;
    private TiledMap map;

    private ArrayList<Button> btns = new ArrayList<Button>();

    private int btn_num;
    private int btn_t;

    private Game game;

    private float x = 300, y = 300;
    private float xCamera = x, yCamera = y;
    private int direction = 0;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private static int xSize;
    private static int ySize;
    private GraphicMap gm = new GraphicMap();

    public WindowGame() {
        super("Monopoly");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
        this.map = new TiledMap("ressources/map/plat.tmx");
        SpriteSheet spriteSheet = new SpriteSheet("ressources/char/lpc_entry/png/char/char6.png", 64, 64);
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
        this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
        this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
        this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);


        x = 2015;
        y = 2115;

        xCamera = x;
        yCamera = y;
        this.map.render((int) xCamera, (int) yCamera);

        btn_num = -1;
        btn_t = -1;

        addBtn();

    }

    private void addBtn() throws SlickException {
        this.btns.add(new Button("play",260, 300));
        this.btns.add(new Button("play", 100, 300));
        this.btns.add(new Button("play", -60, 300));

     }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        /**/


        int xCam = (int) -xCamera;
        int yCam = (int) -yCamera;
        int test = 0;


        this.map.render(xCam,yCam);

        g.translate(container.getWidth() / 2 - xCamera, container.getHeight() / 2 - yCamera);

        g.setColor(new Color(0, 0, 0, .5f));
        g.fillOval(x - 16, y - 8, 32, 16);
        g.drawAnimation(animations[direction + (moving ? 4 : 0)], x-32, y-60);
        updateHUD(g);
    }

    private void updateHUD(Graphics g) throws SlickException {
        //btn : num button, si -1, aucun
        //type: 0->def, 1->hover, 2->click

        for(int i = 0; i < this.btns.size(); i++)
            btns.get(i).def.draw(x + btns.get(i).posx, y - btns.get(i).posy);
        if(btn_num != -1){
            if(btn_t == 0) btns.get(btn_num).def.draw(x + btns.get(btn_num).posx, y - btns.get(btn_num).posy);
            if(btn_t == 1) btns.get(btn_num).hover.draw(x + btns.get(btn_num).posx, y - btns.get(btn_num).posy);
            if(btn_t == 2) btns.get(btn_num).click.draw(x + btns.get(btn_num).posx, y - btns.get(btn_num).posy);
        }
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        if (this.moving) {
            float nextx = x;
            float nexty = y;
            switch (this.direction) {
                case 0:
                    nexty -= .1f * delta;
                    break;
                case 1:
                    nextx -= .1f * delta;
                    break;
                case 2:
                    nexty += .1f * delta;
                    break;
                case 3:
                    nextx += .1f * delta;
                    break;
            }


            if(gm.getCase(nextx, nexty) != -1){
                this.x = nextx;
                this.y = nexty;

                this.xCamera = x;
                this.yCamera = y;
            }
        }

        Input input = container.getInput();
        if(input.getMouseX() >= 660 && input.getMouseX() <= 780 && input.getMouseY() >= 10 && input.getMouseY() <= 30){
            btn_num = 0; btn_t = 1;
        }
        else if(input.getMouseX() >= 500 && input.getMouseX() <= 620 && input.getMouseY() >= 10 && input.getMouseY() <= 30){
            btn_num = 1; btn_t = 1;
        }
        else if(input.getMouseX() >= 340 && input.getMouseX() <= 460 && input.getMouseY() >= 10 && input.getMouseY() <= 30){
            btn_num = 2; btn_t = 1;
        }
        else{
            btn_num = -1;
            btn_t = -1;
        }
    }

    @Override
    public void mousePressed(int button, int x, int y)
    {
        if(x >= 664 && x <= 780 && y >= 10 && y <= 30){
            if(button == 0) btn_num = 0; btn_t = 2;
        }
        else if(x >= 500 && x <= 620 && y >= 10 && y <= 30){
            if(button == 0) btn_num = 1; btn_t = 2;
        }
        else{
            btn_num = -1;
            btn_t = -1;
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
            case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
            case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
            case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        this.moving = false;
    }

    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public static void main(String[] args) throws SlickException {
        Toolkit tk = Toolkit.getDefaultToolkit();
        xSize = (int)( tk.getScreenSize().getWidth() * 0.6);
        ySize = (int)( tk.getScreenSize().getHeight() * 0.7);
        new AppGameContainer(new WindowGame(), 800, 600, false).start();
    }
}