package com.mygdx.game.loader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class B2dAssetManager {

    public final AssetManager manager = new AssetManager();

    public final String playerImage = "images/player.png";
    public final String enemyImage = "images/enemy.png";
    public final String boingSound = "sounds/boing.mp3";
    public final String pingSound = "sounds/ping.mp3";
    public final String playingMusic = "musics/take-on-me.mp3";
    public final String skin = "skin/pixthulhu-ui.json";

    public void queueAddImages() {
        manager.load(playerImage, Texture.class);
        manager.load(enemyImage, Texture.class);
    }

    public void queueAddSounds() {
        manager.load(boingSound, Sound.class);
        manager.load(pingSound, Sound.class);
    }

    public void queueAddMusic() {
        manager.load(playingMusic, Music.class);
    }

    public void queueAddSkin() {
        SkinLoader.SkinParameter skinParameter = new SkinLoader.SkinParameter("skin/pixthulhu-ui.atlas");
        manager.load(skin, Skin.class, skinParameter);
    }
}
