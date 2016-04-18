package com.greenwolfinc.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.greenwolfinc.game.GenericRPG;

/**
 * Created by michi on 4/17/2016.
 */
public class Player {
    private Vector2 currentPosition;
    private Vector2 movement;
    private int positionIndex[] = {0, 0};

    private static final int MOVE_FACTOR = 80; //length of tiles
    private static final int TILE_CENTER = 20; //center tile

    private static final String PLAYER_TEXTURE = "player.png";
    private static final Texture player = new Texture(PLAYER_TEXTURE);

    public Player(int x, int y)
    {
        currentPosition = new Vector2(x, y);
        movement = new Vector2(0,0);
        setPositionIndex();
    }

    public void update(float dt)
    {

    }

    public Vector2 getCurrentPosition() {
        return currentPosition;
    }

    public Vector2 getMovement() {
        return movement;
    }

    public static int getMoveFactor() {
        return MOVE_FACTOR;
    }

    public static int getTileCenter() {
        return TILE_CENTER;
    }

    public static Texture getTexture() {
        return player;
    }

    public void setCurrentPosition(Vector2 movement) {
        float tempx, tempy;

        tempx = currentPosition.x + movement.x;
        tempy = currentPosition.y + movement.y;

        if (tempx > 0 && tempx < GenericRPG.WIDTH && tempy > 0 && tempy < GenericRPG.HEIGHT)
        {
            currentPosition.x = tempx;
            currentPosition.y = tempy;
        }
    }

    public void setMovement(int x, int y) {
        movement.x = x;
        movement.y = y;
    }

    public int[] getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex() {
        positionIndex[0] = (int) (currentPosition.x - 20)/80;
        positionIndex[1] = 5 - (int) (currentPosition.y - 20)/80;
    }
}
