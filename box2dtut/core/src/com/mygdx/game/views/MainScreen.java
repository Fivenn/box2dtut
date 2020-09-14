package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.game.Box2DTutorial;
import com.mygdx.game.controllers.KeyboardController;
import com.mygdx.game.models.B2dModel;

public class MainScreen implements Screen {

    private Box2DTutorial parent;
    private B2dModel model;
    private OrthographicCamera camera = new OrthographicCamera(32,24);
    private Box2DDebugRenderer debugRender;
    private KeyboardController controller;
    private Texture playerTex;
    private SpriteBatch sb;

    public MainScreen(Box2DTutorial box2DTutorial) {
        parent = box2DTutorial;
        controller = new KeyboardController();
        model = new B2dModel(controller, camera, parent.assMan);
        camera = new OrthographicCamera(32, 24);
        debugRender = new Box2DDebugRenderer(true, true, true, true, true, true);
        parent.assMan.queueAddImages();
        parent.assMan.manager.finishLoading();
        playerTex = parent.assMan.manager.get("images/player.png");
        sb = new SpriteBatch();
        sb.setProjectionMatrix(camera.combined);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        model.logicStep(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRender.render(model.world, camera.combined);
        sb.begin();
        sb.draw(playerTex, model.player.getPosition().x - 1, model.player.getPosition().y - 1, 2, 2);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
