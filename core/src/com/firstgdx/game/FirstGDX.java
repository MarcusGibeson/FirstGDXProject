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
	ArrayList<Block> blocks = new ArrayList<>();



	@Override
	public void create() {
		shape = new ShapeRenderer();
		ball = new Ball(150, 200, 10, 15, 8);
		paddle = new Paddle(10, 30, 100, 10, Gdx.graphics.getHeight());

		int blockWidth = 63;
		int blockHeight = 20;
		int screenHeight = Gdx.graphics.getHeight();

		for (int y = screenHeight / 2 + 10; y < screenHeight; y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);

		//Update and draw the ball
		ball.update();
		ball.checkCollision(paddle);
		shape.setColor(ball.color);
		shape.circle(ball.x, ball.y, ball.size);

		//update and draw the paddle
		int mouseX = Gdx.input.getX();
		paddle.updatePosition(mouseX);
		shape.setColor(Color.WHITE);
		shape.rect(paddle.x, paddle.y, paddle.width, paddle.height);

		//draw all the blocks
		for (Block block : blocks) {
			if (!block.isDestroyed()) {
				shape.setColor(Color.RED);
				shape.rect(block.x, block.y, block.width, block.height);
			}
		}

		//check collision with blocks
		ball.checkCollision(blocks);

		for (int i=0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.isDestroyed) {
				blocks.remove(b);
				i--;
			}
		}

		shape.end();
	}
}