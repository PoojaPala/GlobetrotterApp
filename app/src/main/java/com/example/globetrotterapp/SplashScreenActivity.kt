package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // Delay to show splash screen and then navigate to SignUpActivity
        val splashScreenDuration = 2000L // 2 seconds
        android.os.Handler().postDelayed({
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Close SplashScreenActivity
        }, splashScreenDuration)
    }
}
