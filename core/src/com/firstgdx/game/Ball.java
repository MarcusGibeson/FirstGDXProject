package com.firstgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;


public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

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
        shape.setColor(color);
        shape.circle(x,y,size);
    }

    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)){
            //generate random color
            float r = (float) Math.random();
            float g = (float) Math.random();
            float b = (float) Math.random();
            color = new Color(r, g, b, 1);

            //then reverses the ball
            ySpeed = -ySpeed;
        }
    }
    public void checkCollision(ArrayList<Block> blocks) {
        for (Block block : blocks) {
            if(collidesWith(block)) {
                ySpeed = -ySpeed;
                block.setDestroyed(true);
            }
        }

    }

    private boolean collidesWith(Paddle paddle) {
        //Calculate edges of the ball and paddle
        float ballLeft = x;
        float ballRight = x + size;
        float ballTop = y + size;
        float ballBottom = y;

        float paddleLeft = paddle.getX();
        float paddleRight = paddle.getX() + paddle.getWidth();
        float paddleTop = paddle.getY() + paddle.getHeight();
        float paddleBottom = paddle.getY();

        return ballRight >= paddleLeft && ballLeft <= paddleRight && ballBottom <= paddleTop && ballTop >= paddleBottom;
    }

    private boolean collidesWith(Block block) {
        float ballLeft = x;
        float ballRight = x + size;
        float ballTop = y + size;
        float ballBottom = y;

        float blockLeft = block.x;
        float blockRight = block.x + block.width;
        float blockTop = block.y + block.height;
        float blockBottom = block.y;

        return ballRight >= blockLeft && ballLeft <= blockRight && ballBottom <= blockTop && ballTop >= blockBottom;
    }

}
