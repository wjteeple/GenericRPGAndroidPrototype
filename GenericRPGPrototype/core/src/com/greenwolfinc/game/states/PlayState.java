package com.greenwolfinc.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.greenwolfinc.game.GenericRPG;
import com.greenwolfinc.game.sprites.Player;

/**
 * Created by michi on 4/17/2016.
 */
public class PlayState extends State {
    private Player player;
    private boolean keyPressed = false;

    private char[][] area = {{'G','G','G','G','G','G','G','G','G','G'},
            {'P','P','P','P','P','P','P','P','P','P'},
            {'P','P','P','P','P','P','P','P','P','P'},
            {'G','G','G','G','G','G','G','G','G','G'},
            {'P','P','P','P','P','P','P','P','P','P'},
            {'P','P','P','P','P','P','P','P','P','P'}};

    private static final int TILE_DIM = 80;

    //tile textures
    private static final Texture PATH = new Texture("path.png");
    private static final Texture GRASS = new Texture("grass.png");
    private static final Texture WATER = new Texture("water.png");

    public PlayState(GameStateManager gsm) {
        super(gsm);
        player = new Player(Player.getTileCenter(), (GenericRPG.HEIGHT/2) - (2*Player.getTexture().getHeight()) + Player.getTexture().getHeight()/2);
    }

    @Override
    protected void handleInput() {
        if(!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY))
        {
            keyPressed = false;
        }
        if (!keyPressed) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) //move right
            {
                player.setMovement(0, Player.getMoveFactor());
                player.setCurrentPosition(player.getMovement());
                player.setPositionIndex();
                keyPressed = true;
                System.out.println(player.getPositionIndex()[0] + ", " + player.getPositionIndex()[1]);
                System.out.println(player.getCurrentPosition().x + ", " + player.getCurrentPosition().y);
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.A)) //move right
            {
                player.setMovement(-(Player.getMoveFactor()), 0);
                player.setCurrentPosition(player.getMovement());
                player.setPositionIndex();
                keyPressed = true;
                System.out.println(player.getPositionIndex()[0] + ", " + player.getPositionIndex()[1]);
                System.out.println(player.getCurrentPosition().x + ", " + player.getCurrentPosition().y);
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.S)) //move right
            {
                player.setMovement(0, -(Player.getMoveFactor()));
                player.setCurrentPosition(player.getMovement());
                player.setPositionIndex();
                keyPressed = true;
                System.out.println(player.getPositionIndex()[0] + ", " + player.getPositionIndex()[1]);
                System.out.println(player.getCurrentPosition().x + ", " + player.getCurrentPosition().y);
            }
            else if (Gdx.input.isKeyPressed(Input.Keys.D)) //move right
            {
                player.setMovement(Player.getMoveFactor(), 0);
                player.setCurrentPosition(player.getMovement());
                player.setPositionIndex();
                keyPressed = true;
                System.out.println(player.getPositionIndex()[0] + ", " + player.getPositionIndex()[1]);
                System.out.println(player.getCurrentPosition().x + ", " + player.getCurrentPosition().y);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        drawArea(area, 10, 6, sb);
        sb.draw(player.getTexture(), player.getCurrentPosition().x, player.getCurrentPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }

    public void drawArea(char[][] area, int x, int y, SpriteBatch sb)
    {
        int temp = y - 1;

        for (int i = 0; i < y ; i++)
        {
            for (int j = 0; j < x; j++)
            {
                if (area[i][j] == 'P')
                {
                    sb.draw(PATH, j*TILE_DIM, temp*TILE_DIM);
                }
                else if (area[i][j] == 'G')
                {
                    sb.draw(GRASS, j*TILE_DIM, temp*TILE_DIM);
                }
                else if (area[i][j] == 'W')
                {
                    sb.draw(WATER, j*TILE_DIM, temp*TILE_DIM);
                }
            }
            temp--;
        }
    }
}
