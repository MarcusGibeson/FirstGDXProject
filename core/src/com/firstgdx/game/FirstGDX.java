package com.firstgdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.Random;

public class FirstGDX extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle;



	@Override
	public void create() {
		shape = new ShapeRenderer();
		ball = new Ball(150, 200, 20, 10, 5);
		paddle = new Paddle(10, 0, 100, 10, Gdx.graphics.getHeight());

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		//Draw screen boundries
		shape.begin(ShapeRenderer.ShapeType.Line);
		shape.setColor(Color.WHITE);
		shape.rect(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		shape.end();


		//Update and draw the ball
		ball.update();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		shape.end();

		//update and draw the paddle
		int mouseX = Gdx.input.getX();
		paddle.updatePosition(mouseX);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.draw(shape);
		shape.end();
	}
}