package com.example.globetrotterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

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

        val fromLocation = intent.getStringExtra("from") ?: ""
       val toLocation = intent.getStringExtra("to") ?: ""
        val firstName = intent.getStringExtra("firstName")?:""

        departureAirport.text = fromLocation
        arrivalAirport.text = toLocation

        editButton.setOnClickListener {
            val intent = Intent(this, TravelActivity::class.java)
            startActivity(intent)
        }

        confirmButton.setOnClickListener {
            val intent = Intent(this, SeatSelectionActivity::class.java).apply {
                putExtra("from", fromLocation)
                putExtra("to", toLocation)
                putExtra("firstName", firstName)
            }
            startActivity(intent)
        }
    }
}
