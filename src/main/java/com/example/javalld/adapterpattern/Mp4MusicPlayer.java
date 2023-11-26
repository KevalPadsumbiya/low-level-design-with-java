package com.example.javalld.adapterpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mp4MusicPlayer implements AdvanceMusicPlayer {
    @Override
    public void playMp4Song(String songName) {
        log.info("Playing Mp4 song: {}", songName);
    }

    @Override
    public void playVlcSong(String songName) {
        //pass
    }
}
