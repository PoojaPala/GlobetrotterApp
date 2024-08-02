package com.example.globetrotterapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // CardView and Button for booking
        val cardView = findViewById<CardView>(R.id.cardView)
        val bookButton = findViewById<Button>(R.id.book)
        bookButton.setOnClickListener {
            // Navigate to TravelActivity when "Book Now" is clicked
            val intent = Intent(this, TravelActivity::class.java)
            startActivity(intent)
        }

        // ImageButtons and TextViews for destinations
        val parisButton = findViewById<ImageButton>(R.id.paris)
        val niagaraButton = findViewById<ImageButton>(R.id.niagara)
        val nyButton = findViewById<ImageButton>(R.id.ny)
        val indiaButton = findViewById<ImageButton>(R.id.india)
        val disneyButton = findViewById<ImageView>(R.id.disney)
        val maldivesButton = findViewById<ImageView>(R.id.maldives)
        val turkeyButton = findViewById<ImageView>(R.id.turkey)

        parisButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to Paris
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "Paris, France")
            startActivity(intent)
        }

        niagaraButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to Niagara
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "Niagara, Canada")
            startActivity(intent)
        }

        nyButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to New York
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "New York, USA")
            startActivity(intent)
        }

        indiaButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to Delhi
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "Delhi, India")
            startActivity(intent)
        }

        disneyButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to Disneyland
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "Disneyland")
            startActivity(intent)
        }

        maldivesButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to Maldives
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "Maldives")
            startActivity(intent)
        }

        turkeyButton.setOnClickListener {
            // Navigate to FlightBookActivity with the destination set to Turkey
            val intent = Intent(this, FlightBookActivity::class.java)
            intent.putExtra("DESTINATION", "Turkey")
            startActivity(intent)



        }
    }
}

