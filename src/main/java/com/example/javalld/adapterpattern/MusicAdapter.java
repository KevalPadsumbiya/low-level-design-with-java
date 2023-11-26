package com.example.javalld.adapterpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MusicAdapter implements MusicPlayer {
    private AdvanceMusicPlayer advanceMusicPlayer;

    public MusicAdapter(MusicType musicType) {
        switch (musicType) {
            case MP4:
                advanceMusicPlayer = new Mp4MusicPlayer();
                break;
            case VLC:
                advanceMusicPlayer = new VlcMusicPlayer();
                break;
        }
    }

    @Override
    public void playMusic(MusicType musicType, String songName) {
        switch (musicType) {
            case MP4:
                advanceMusicPlayer.playMp4Song(songName);
                break;
            case VLC:
                advanceMusicPlayer.playVlcSong(songName);
                break;
            default:
                log.info("Invalid songType!");
        }
    }
}
