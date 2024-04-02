package com.firstgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int width;
    int height;
    int screenHeight;

    public Paddle(int x, int y, int width, int height, int screenHeight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.screenHeight = screenHeight;
    }

    public void updatePosition(int mouseX) {
        //update horizontal position
        x = mouseX - width /2;

        //ensure paddle stays with screen
        if (x<0) {
            x = 0;
        } else if (x + width > Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth() - width;
        }
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x,y,width,height);
    }

}
