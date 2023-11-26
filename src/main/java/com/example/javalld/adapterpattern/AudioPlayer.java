package com.example.javalld.adapterpattern;

import lombok.extern.slf4j.Slf4j;

import static com.example.javalld.adapterpattern.MusicType.*;

@Slf4j
public class AudioPlayer implements MusicPlayer {
    private MusicAdapter musicAdapter;

    @Override
    public void playMusic(MusicType musicType, String songName) {
        if (MP3.equals(musicType)) {
            log.info("Playing Mp3 song: {}", songName);
        } else if (MP4.equals(musicType) || VLC.equals(musicType)) {
            musicAdapter = new MusicAdapter(musicType);
            musicAdapter.playMusic(musicType, songName);
        }
    }
}
