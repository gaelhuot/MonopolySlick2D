package Monopoly;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainApplication extends BasicGame {
    private static String nbJoueurs;
    GameContainer container;
    private TiledMap map;

    private ArrayList<Button> btns = new ArrayList<Button>();

    private int btn_num;
    private int btn_t;

    private int selectHUD = 0;
    private boolean displayHUD = true;

    private Game game;
    private Map plateau;
    private GraphicMap gm = new GraphicMap();

    private static Options options;

    private int direction = 0;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private static int xSize;
    private static int ySize;

    public MainApplication() {
        super("Monopoly");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        //View view = new View();
        //NameView nameView = new NameView();



        addBtn();
        plateau = new Map();
        game = new Game(Integer.parseInt(nbJoueurs));
        this.container = container;
        this.container.setShowFPS(false);

        if(game.players.size() > 0){
            this.map = new TiledMap("ressources/map/plat.tmx");
            this.map.render((int) game.getCurrent().camX, (int) game.getCurrent().camY);

            btn_num = -1;
            btn_t = -1;
        }

    }

    private void addBtn() throws SlickException {
        this.btns.add(new Button("play",-50, 290));
        this.btns.add(new Button("buy", -210, 290));
        this.btns.add(new Button("finish", -370, 290));

     }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        /**/
        if(game.players.size() > 0){

            int xCam = (int) -game.getCurrent().camX;
            int yCam = (int) -game.getCurrent().camY;

            this.map.render(xCam,yCam);

            g.translate(container.getWidth() / 2 - game.getCurrent().camX, container.getHeight() / 2 - game.getCurrent().camY);

            game.getCurrent().animID = direction + (moving ? 4 : 0);
            updateHUD(g);
            updateFig(g);
            updateHUDInformations(g);
            g.setColor(new Color(0, 0, 0, .5f));
            g.fillOval(game.getCurrent().posX - 16, game.getCurrent().posY - 8, 32, 16);
            g.drawAnimation(game.getCurrent().figurine.getAnimation()[game.getCurrent().animID], game.getCurrent().posX - 32, game.getCurrent().posY - 60);
        }

    }

    private void updateFig(Graphics g) {
        if(game.players.size() > 0){
            for (int i = 0; i < game.players.size(); i++){
                if (i != game.toPlay){
                    g.fillOval(game.getPlayer(i).posX - 16, game.getPlayer(i).posY - 8, 32, 16);
                    g.drawAnimation(game.getPlayer(i).figurine.getAnimation()[game.getPlayer(i).animID], game.getPlayer(i).posX-32, game.getPlayer(i).posY-60);
                }
            }
        }
    }

    private void updateHUDInformations(Graphics g) throws SlickException {
        if(game.players.size() > 0 && displayHUD) {
            g.setColor(Color.black);
            g.drawLine(game.getCurrent().posX + 160, 0, game.getCurrent().posX + 160, game.getCurrent().posY+300);
            g.setColor(new Color(0, 0, 0, .5f));
            g.fillRect(game.getCurrent().posX + 160, 0, game.getCurrent().posX + 50, game.getCurrent().posY + 300);
            g.setColor(Color.white);
            //580 - 40     775 - 40 // height 20 , width 20
            Player p = game.players.get(selectHUD);
            g.drawString(p.name, game.getCurrent().posX + 220, game.getCurrent().posY - 260);
            g.drawImage(new Image("ressources/HUD/minus.png"), game.getCurrent().posX + 180, game.getCurrent().posY - 265);
            g.drawImage(new Image("ressources/HUD/plus.png"), game.getCurrent().posX + 340, game.getCurrent().posY - 265);
            g.drawString(p.money + " euros", game.getCurrent().posX + 180, game.getCurrent().posY - 220);
            for (int i = 0; i < p.property.size(); i++){
                g.setColor(gm.getColor(p.property.get(i).getGroup()));
                g.fillRect(game.getCurrent().posX+170, (game.getCurrent().posY - 195) + (i*15), 10, 10);
                g.drawString(p.property.get(i).getName(), game.getCurrent().posX+180, (game.getCurrent().posY - 200) + (i*15));
            }
            g.drawString(plateau.get_index(gm.getCase(game.getCurrent().posX, game.getCurrent().posY)).getName(),game.getCurrent().posX + 160, game.getCurrent().posY + 250);
            if(plateau.get_index(gm.getCase(game.getCurrent().posX, game.getCurrent().posY)).getValue() != -1 && plateau.get_index(gm.getCase(game.getCurrent().posX, game.getCurrent().posY)).isAvailable())
                g.drawString(plateau.get_index(gm.getCase(game.getCurrent().posX, game.getCurrent().posY)).getValue() + " euros",game.getCurrent().posX + 160, game.getCurrent().posY + 270);
            g.setColor(new Color(0, 0, 0, .5f));
        }
    }


    private void updateHUD(Graphics g) throws SlickException {
        for(int i = 0; i < this.btns.size(); i++)
            btns.get(i).def.draw(game.getCurrent().posX + btns.get(i).posx, game.getCurrent().posY - btns.get(i).posy);
        if(btn_num != -1){
            if(btn_t == 0) btns.get(btn_num).def.draw(game.getCurrent().posX + btns.get(btn_num).posx, game.getCurrent().posY - btns.get(btn_num).posy);
            if(btn_t == 1) btns.get(btn_num).hover.draw(game.getCurrent().posX + btns.get(btn_num).posx, game.getCurrent().posY - btns.get(btn_num).posy);
            if(btn_t == 2) btns.get(btn_num).click.draw(game.getCurrent().posX + btns.get(btn_num).posx, game.getCurrent().posY - btns.get(btn_num).posy);
        }
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        if (game.players.size() <= 0 ) return;

        if (this.moving) {
            float nextx = game.getCurrent().posX;
            float nexty = game.getCurrent().posY;
            switch (this.direction) {
                case 0:
                    nexty -= .125f * delta;
                    break;
                case 1:
                    nextx -= .125f * delta;
                    break;
                case 2:
                    nexty += .125f * delta;
                    break;
                case 3:
                    nextx += .125f * delta;
                    break;
            }


            if(gm.getCase(nextx, nexty) != -1 && !game.getCurrent().inJail){
                game.getCurrent().posX = nextx;
                game.getCurrent().posY = nexty;
                game.getCurrent().camX = nextx;
                game.getCurrent().camY = nexty;

                game.getCurrent().camX = game.getCurrent().camX;
                game.getCurrent().camY = game.getCurrent().camY;
            }
        }

        Input input = container.getInput();

        if(input.getMouseX() >= 30 && input.getMouseX() <= 160 && input.getMouseY() >= 10 && input.getMouseY() <= 30){
            btn_num = 2; btn_t = 1;
        }
        else if(input.getMouseX() >= 190 && input.getMouseX() <= 320 && input.getMouseY() >= 10 && input.getMouseY() <= 30){
            btn_num = 1; btn_t = 1;
        }
        else if(input.getMouseX() >= 350 && input.getMouseX() <= 510 && input.getMouseY() >= 10 && input.getMouseY() <= 30){
            btn_num = 0; btn_t = 1;
        }
        else{
            btn_num = -1;
            btn_t = -1;
        }
    }

    @Override
    public void mousePressed(int button, int x, int y)
    {
        if(game.players.size() <= 0) return;
        if(x >= 740 && x <= 770 && y >= 40 && y <= 70 && button==0){
            if ( this.selectHUD + 1 >= game.players.size() ) this.selectHUD = 0;
            else this.selectHUD++;
        }

        if(x >= 580 && x <= 610 && y >= 40 && y <= 70 && button==0){
            if ( this.selectHUD - 1 < 0 ) this.selectHUD = game.players.size() - 1;
            else this.selectHUD--;
        }

        if(x >= 350 && x <= 510 && y >= 10 && y <= 30){
            if(button == 0) clickPlay();
        }
        else if(x >= 190 && x <= 320 && y >= 10 && y <= 30){
            if(button == 0) clickBuy();
        }
        else if(x >= 30 && x <= 160 && y >= 10 && y <= 30){
            if(button == 0) clickFinish();
        }
        else{
            btn_num = -1;
            btn_t = -1;
        }
    }

    private void clickFinish() {
        if(game.getCurrent().played || game.getCurrent().inJail){
            if(gm.getCase(game.getCurrent().posX, game.getCurrent().posY) == game.getCurrent().Case)
                game.nextPlayer();
            else
                JOptionPane.showMessageDialog(null, "Vous devez vous placez sur la bonne case !");
        }
        else
            JOptionPane.showMessageDialog(null, "Vous devez jouer !");

    }

    private void clickBuy() {
        if(game.getCurrent().played && !game.getCurrent().inJail){
            if(gm.getCase(game.getCurrent().posX, game.getCurrent().posY) == game.getCurrent().Case){
                if(game.canBuy()) game.getCurrent().buy(plateau.get_index(game.getCurrent().Case));
                else JOptionPane.showMessageDialog(null, "Cette carte n'est pas achetable !");
            }
            else
                JOptionPane.showMessageDialog(null, "Vous devez vous placez sur la bonne case !");
        }
        else
            JOptionPane.showMessageDialog(null, "Vous devez jouer !");
    }

    private void clickPlay() {
        if(!game.getCurrent().played || !game.getCurrent().inJail){
            System.out.println("Vous êtes sur " + plateau.get_index(game.getCurrent().Case).getName());
            game.getCurrent().move();
            game.verifMove();
            JOptionPane.showMessageDialog(null, "Vous avez fait " + game.getCurrent().d + " et " + game.getCurrent().d2 + " (" + game.getCurrent().last_play + "), avancez jusqu'à " + plateau.get_index(game.getCurrent().Case).getName() + " !");

        }
        else
            JOptionPane.showMessageDialog(null, "Vous avez déjà joué ..");
    }

    @Override
    public void keyPressed(int key, char c) {
        if(game.players.size() <= 0) return;
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

    public Property getCurrent(){
        return plateau.get_index(game.getCurrent().Case);
    }

    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public static void main(String[] args) throws SlickException {
        nbJoueurs = "3";
        Toolkit tk = Toolkit.getDefaultToolkit();
        xSize = (int)( tk.getScreenSize().getWidth() * 0.6);
        ySize = (int)( tk.getScreenSize().getHeight() * 0.7);
        new AppGameContainer(new MainApplication(), 800, 600, false).start();
    }
}