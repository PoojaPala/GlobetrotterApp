package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FlightBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_book)

        // Initialize buttons
        val viewDetail1: Button = findViewById(R.id.viewDetail1)
        val viewDetail2: Button = findViewById(R.id.viewDetail2)
        val viewDetail3: Button = findViewById(R.id.viewDetail3)
        val viewDetail4: Button = findViewById(R.id.viewDetail4)

        // Set up click listeners for each button
        viewDetail1.setOnClickListener {
            navigateToFlightDetailsActivity()
        }

        viewDetail2.setOnClickListener {
            navigateToFlightDetailsActivity()
        }

        viewDetail3.setOnClickListener {
            navigateToFlightDetailsActivity()
        }

        viewDetail4.setOnClickListener {
            navigateToFlightDetailsActivity()
        }
    }

    private fun navigateToFlightDetailsActivity() {
        val intent = Intent(this, FlightDetailsActivity::class.java)
        startActivity(intent)
    }
}
