package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlightDetailsActivity : AppCompatActivity() {

    private lateinit var departureAirport: TextView
    private lateinit var arrivalAirport: TextView
    private lateinit var editButton: Button
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)

        departureAirport = findViewById(R.id.departureAirport1)
        arrivalAirport = findViewById(R.id.arrivalAirport1)
        editButton = findViewById(R.id.edit)
        confirmButton = findViewById(R.id.book3)

        val fromLocation = intent.getStringExtra("EXTRA_FROM_LOCATION") ?: "YQT"
        val toLocation = intent.getStringExtra("EXTRA_TO_LOCATION") ?: "DEL"

        departureAirport.text = fromLocation
        arrivalAirport.text = toLocation

        editButton.setOnClickListener {
            val intent = Intent(this, FlightBookActivity::class.java)
            startActivity(intent)
        }

        confirmButton.setOnClickListener {
            val intent = Intent(this, SeatSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
