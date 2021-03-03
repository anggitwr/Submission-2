package com.anggit.githubusersubmission2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private val loading = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        if (supportActionBar !=null) {
            supportActionBar!!.title=""
        }
        Handler().postDelayed({
            val splash = Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(splash)
            finish()
        }, loading.toLong())
    }
}