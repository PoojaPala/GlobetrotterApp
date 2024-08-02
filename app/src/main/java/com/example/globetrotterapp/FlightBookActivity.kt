package com.example.globetrotterapp

import android.widget.TextView
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FlightBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_book)


        // Retrieve the selected values from the Intent
        val fromLocation = intent.getStringExtra("fromLocation") ?: "N/A"
        val toLocation = intent.getStringExtra("toLocation") ?: "N/A"

        // Set the values to the UI components
        findViewById<TextView>(R.id.departureAirport1).text = fromLocation
        findViewById<TextView>(R.id.arrivalAirport1).text = toLocation
        val viewDetail1: Button = findViewById(R.id.viewDetail1)
        val viewDetail2: Button = findViewById(R.id.viewDetail2)
        val viewDetail3: Button = findViewById(R.id.viewDetail3)
        val viewDetail4: Button = findViewById(R.id.viewDetail4)

        // Set up click listeners for each button
        viewDetail1.setOnClickListener {
            navigateToSeatSelectionActivity()
        }

        viewDetail2.setOnClickListener {
            navigateToSeatSelectionActivity()
        }

        viewDetail3.setOnClickListener {
            navigateToSeatSelectionActivity()
        }

        viewDetail4.setOnClickListener {
            navigateToSeatSelectionActivity()
        }
    }

    private fun navigateToSeatSelectionActivity() {
        val intent = Intent(this, FlightDetailsActivity::class.java)
        startActivity(intent)
    }
}
