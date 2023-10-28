package com.example.simplemusicplayer

import android.content.Context
import android.media.MediaPlayer

class MusicManager(context: Context) {

    private var mediaPlayer: MediaPlayer? = null
    private val myContext: Context = context
    private var isReleased = true // mediaPlayerが解放されているかどうかを示すフラグ

    fun startMusic() {
        if (mediaPlayer == null || isReleased) {
            mediaPlayer = MediaPlayer.create(myContext, R.raw.music)
            mediaPlayer?.start()
            isReleased = false // mediaPlayerが作成されたので、フラグをfalseに設定
        } else if (!mediaPlayer!!.isPlaying) {
            mediaPlayer?.start()
        }
    }

    fun stopMusic() {
        if (!isReleased && mediaPlayer != null) { // isReleasedがtrueでない場合のみstopやreleaseを呼び出す
            if (mediaPlayer!!.isPlaying) {
                mediaPlayer?.stop()
                mediaPlayer?.reset()
            }
            mediaPlayer?.release()
            isReleased = true // mediaPlayerが解放されたので、フラグをtrueに設定
        }
    }
}
