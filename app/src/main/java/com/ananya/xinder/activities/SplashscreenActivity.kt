package com.ananya.xinder.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.thecode.tinderclone.R

class SplashscreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        Handler().postDelayed({
            val intent = Intent(this, TinderCloneMainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}