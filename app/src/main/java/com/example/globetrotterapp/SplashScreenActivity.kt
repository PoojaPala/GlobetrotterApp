package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Delay to simulate splash screen duration before navigating to the main activity
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity
            startActivity(Intent(this, MainActivity::class.java))
            // Finish the splash screen activity so it can't be returned to
            finish()
        }, 2000) // Duration in milliseconds (2 seconds)
    }
}
