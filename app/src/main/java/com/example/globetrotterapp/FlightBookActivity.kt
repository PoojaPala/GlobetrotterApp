package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.Button
import android.widget.TextView

class FlightBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_book)

        // CardView 1
        val cardView1: CardView = findViewById(R.id.cardView1)
        val departureAirport1: TextView = findViewById(R.id.departureAirport1)
        val arrivalAirport1: TextView = findViewById(R.id.arrivalAirport1)
        val flightDuration1: TextView = findViewById(R.id.flightDuration1)
        val departureTime1: TextView = findViewById(R.id.departureTime1)
        val arrivalTime1: TextView = findViewById(R.id.arrivalTime1)
        val cost1: TextView = findViewById(R.id.cost1)
        val viewDetail1: Button = findViewById(R.id.viewDetail1)

        // CardView 2
        val cardView2: CardView = findViewById(R.id.cardView2)
        val departureAirport2: TextView = findViewById(R.id.departureAirport2)
        val arrivalAirport2: TextView = findViewById(R.id.arrivalAirport2)
        val flightDuration2: TextView = findViewById(R.id.flightDuration2)
        val departureTime2: TextView = findViewById(R.id.departureTime2)
        val arrivalTime2: TextView = findViewById(R.id.arrivalTime2)
        val cost2: TextView = findViewById(R.id.cost2)
        val viewDetail2: Button = findViewById(R.id.viewDetail2)

        // CardView 3
        val cardView3: CardView = findViewById(R.id.cardView3)
        val departureAirport3: TextView = findViewById(R.id.departureAirport3)
        val arrivalAirport3: TextView = findViewById(R.id.arrivalAirport3)
        val flightDuration3: TextView = findViewById(R.id.flightDuration3)
        val departureTime3: TextView = findViewById(R.id.departureTime3)
        val arrivalTime3: TextView = findViewById(R.id.arrivalTime3)
        val cost3: TextView = findViewById(R.id.cost3)
        val viewDetail3: Button = findViewById(R.id.viewDetail3)

        // CardView 4
        val cardView4: CardView = findViewById(R.id.cardView4)
        val departureAirport4: TextView = findViewById(R.id.departureAirport4)
        val arrivalAirport4: TextView = findViewById(R.id.arrivalAirport4)
        val flightDuration4: TextView = findViewById(R.id.flightDuration4)
        val departureTime4: TextView = findViewById(R.id.departureTime4)
        val arrivalTime4: TextView = findViewById(R.id.arrivalTime4)
        val cost4: TextView = findViewById(R.id.cost4)
        val viewDetail4: Button = findViewById(R.id.viewDetail4)

        // Set up click listeners for the flight details buttons
        viewDetail1.setOnClickListener {
            navigateToBookingDetails("Flight 1")
        }

        viewDetail2.setOnClickListener {
            navigateToBookingDetails("Flight 2")
        }

        viewDetail3.setOnClickListener {
            navigateToBookingDetails("Flight 3")
        }

        viewDetail4.setOnClickListener {
            navigateToBookingDetails("Flight 4")
        }
    }

    private fun navigateToBookingDetails(flight: String) {
        // Replace 'BookingDetailsActivity' with the appropriate activity
        val intent = Intent(this, TravelActivity::class.java)
        intent.putExtra("FLIGHT_DETAILS", flight)
        startActivity(intent)
    }
}
