package com.example.simplemusicplayer

import android.content.Context
import android.media.MediaPlayer

class MusicManager(context: Context) {

    private lateinit var mediaPlayer: MediaPlayer
    private val myContext: Context = context

    fun startMusic() {
        // MediaPlayerが初期化されておらず、または再生中でない場合のみ音楽を再生
        if (!::mediaPlayer.isInitialized || !mediaPlayer.isPlaying) {
            mediaPlayer = MediaPlayer.create(myContext, R.raw.music)
            mediaPlayer.start()
        }
    }


    fun stopMusic(){
        mediaPlayer.stop()
        mediaPlayer.reset()
        mediaPlayer.release()
    }
}