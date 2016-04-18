package com.greenwolfinc.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.greenwolfinc.game.GenericRPG;

/**
 * Created by michi on 4/17/2016.
 */
public class MenuState extends State {
    private Texture background;
    private Texture startButton;

    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        background = new Texture("testMenuBackground.png");
        startButton = new Texture("start.png");
    }

    @Override
    public void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(background, 0, 0, GenericRPG.WIDTH, GenericRPG.HEIGHT);
        sb.draw(startButton, (GenericRPG.WIDTH/2) - startButton.getWidth()/2, (GenericRPG.HEIGHT/2));
        sb.end();
    }

    @Override
    public void dispose()
    {
        background.dispose();
        startButton.dispose();
    }
}
