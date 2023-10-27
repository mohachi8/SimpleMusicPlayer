package com.example.simplemusicplayer

import android.content.Context
import android.media.MediaPlayer

class MusicManager(context: Context) {

    private lateinit var mediaPlayer: MediaPlayer
    private val myContext: Context = context

    fun startMusic(){
        mediaPlayer = MediaPlayer.create(myContext,R.raw.music)
        mediaPlayer.start()
    }

    fun stopMusic(){
        mediaPlayer.stop()
        mediaPlayer.reset()
        mediaPlayer.release()
    }
}