package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 touch;
    private Vector2 tmp;
    private Vector2 v;
    private final float V_LENGTH = 0.5f;


    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        tmp.set(touch);
        if (tmp.sub(pos).len() > V_LENGTH){
            pos.add(v);
        } else{
            pos.set(touch);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch. cpy().sub(pos)).setLength(V_LENGTH);
        return super.touchDown(screenX, screenY, pointer, button);
    }




    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        pos.set(touch);
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                v.set(0, 5);
                break;
            case Input.Keys.DOWN:
                v.set(0, -5);
                break;
            case Input.Keys.RIGHT:
                v.set(5, 0);
                break;
            case Input.Keys.LEFT:
                v.set(-5, 0);
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        v.setZero();
        return super.keyUp(keycode);
    }

}
