package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AppPreferences {

    private static final String PREFS_MUSIC_VOLUME = "volume";
    private static final String PREFS_MUSIC_ENABLE = "music.enable";
    private static final String PREFS_SOUND_VOLUME = "sound";
    private static final String PREFS_SOUND_ENABLE = "sound.enable";
    private static final String PREFS_NAME = "b2dtut";

    protected Preferences getPrefs() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public float getMusicVolume() {
        return getPrefs().getFloat(PREFS_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(PREFS_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    public float getSoundVolume() {
        return getPrefs().getFloat(PREFS_SOUND_VOLUME, 0.5f);
    }

    public void setSoundVolume(float volume) {
        getPrefs().putFloat(PREFS_SOUND_VOLUME, volume);
        getPrefs().flush();
    }

    public boolean isMusicEnabled() {
        return getPrefs().getBoolean(PREFS_MUSIC_ENABLE, true);
    }

    public void setMusicEnable(boolean musicEnable) {
        getPrefs().putBoolean(PREFS_MUSIC_ENABLE, musicEnable);
        getPrefs().flush();
    }

    public boolean isSoundEnabled() {
        return getPrefs().getBoolean(PREFS_SOUND_ENABLE, true);
    }

    public void setSoundEnable(boolean soundEnable) {
        getPrefs().putBoolean(PREFS_SOUND_ENABLE, soundEnable);
        getPrefs().flush();
    }
}
