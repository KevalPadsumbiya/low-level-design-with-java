package com.example.javalld.adapterpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VlcMusicPlayer implements AdvanceMusicPlayer {
    @Override
    public void playMp4Song(String songName) {
        //pass
    }

    @Override
    public void playVlcSong(String songName) {
        log.info("Playing Vlc song: {}", songName);
    }
}
