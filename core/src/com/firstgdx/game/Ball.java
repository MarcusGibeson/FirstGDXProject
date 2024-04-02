package com.firstgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        //Print ball's position and speed
        System.out.println("Ball Position: (" + x + ", " + y + ")");
        System.out.println("Ball Speed: (" + xSpeed + ", " + ySpeed + ")");

        //Check left and right bounds
        if (x <0) {
            x = 0;
            xSpeed = -xSpeed;
        } else if (x + size> Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth() - size;
            xSpeed = -xSpeed;
        }

        //check vertical bounds
        if (y < 0) {
            y = 0;
            ySpeed = -ySpeed;
        } else if (y + size > Gdx.graphics.getHeight()) {
            y = Gdx.graphics.getHeight() - size;
            ySpeed = -ySpeed;
        }

    }

    public void draw (ShapeRenderer shape) {
        shape.circle(x,y,size);
    }
}
