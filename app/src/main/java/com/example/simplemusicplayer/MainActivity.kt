package com.example.simplemusicplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplemusicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var musicManager: MusicManager = MusicManager(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBindingを使用してUI要素を初期化
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // MusicManagerのインスタンスを生成
        musicManager = MusicManager(this)

        // Startボタンのクリックリスナー
        binding.startButton.setOnClickListener {
            musicManager.startMusic()
        }

        // Stopボタンのクリックリスナー
        binding.stopButton.setOnClickListener {
            musicManager.stopMusic()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Activityが破棄される時に音楽のリソースも解放
        musicManager.stopMusic()
    }
}