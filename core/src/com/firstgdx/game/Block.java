package com.firstgdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {

    int x;
    int y;
    int width;
    int height;
    boolean isDestroyed;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDestroyed = false;
    }

    public void draw(ShapeRenderer shape) {
        if (!isDestroyed) {
            shape.rect(x,y,width,height);
        }

    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

}
