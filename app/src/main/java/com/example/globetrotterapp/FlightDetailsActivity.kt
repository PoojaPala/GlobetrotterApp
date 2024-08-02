package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FlightDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)

        // Initialize your views
        val editButton: Button = findViewById(R.id.edit)
        val confirmButton: Button = findViewById(R.id.book3)

        // Set up edit button click listener to navigate to FlightBookActivity
        editButton.setOnClickListener {
            val intent = Intent(this, FlightBookActivity::class.java)
            startActivity(intent)
        }

        // Set up confirm button click listener to navigate to BoardingPassActivity
        confirmButton.setOnClickListener {
            val intent = Intent(this, SeatSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
