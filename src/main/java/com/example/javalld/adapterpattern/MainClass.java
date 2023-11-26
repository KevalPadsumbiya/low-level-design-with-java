package com.example.javalld.adapterpattern;

public class MainClass {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.playMusic(MusicType.MP3, "Song_1.mp3");
        audioPlayer.playMusic(MusicType.MP4, "Song_2.mp4");
        audioPlayer.playMusic(MusicType.VLC, "Song_3.vlc");
    }
}
