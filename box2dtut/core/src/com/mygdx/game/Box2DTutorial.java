package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.loader.B2dAssetManager;
import com.mygdx.game.views.*;

public class Box2DTutorial extends Game {

	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;

	private LoadingScreen loadingScreen;
	private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private  MainScreen mainScreen;
	private EndScreen endScreen;
	private AppPreferences preferences;
	private Music playingMusic;
	public B2dAssetManager assMan = new B2dAssetManager();

	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
		preferences = new AppPreferences();
		assMan.queueAddMusic();
		assMan.manager.finishLoading();
		playingMusic = assMan.manager.get("musics/take-on-me.mp3");
		playingMusic.play();
	}

	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
				this.setScreen(preferencesScreen);
				break;
			case APPLICATION:
				if(mainScreen == null) mainScreen = new MainScreen(this);
				this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if(endScreen == null) endScreen = new EndScreen(this);
				this.setScreen(endScreen);
				break;
		}
	}

	public AppPreferences getPreferences() {
		return this.preferences;
	}
}