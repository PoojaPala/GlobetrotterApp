package com.example.globetrotterapp


import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BoardingPassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boarding_pass)
        val downloadButton: Button = findViewById(R.id.book)

        // Set up an OnClickListener for the button
        downloadButton.setOnClickListener {
            // Show a Toast message when the button is clicked
            Toast.makeText(this, "Your boarding pass has been downloaded", Toast.LENGTH_SHORT).show()
        }
    }
}
